package com.mrgoddavid.vector.space.plane;

import com.mrgoddavid.matrix.FixedMatrix;
import com.mrgoddavid.matrix.Matrix2d;
import com.mrgoddavid.matrix.Matrix2i;
import com.mrgoddavid.utils.NumberFormatter;
import com.mrgoddavid.vector.Vector3d;
import com.mrgoddavid.vector.Vector3i;
import com.mrgoddavid.vector.space.line.Line3d;
import com.mrgoddavid.vector.space.point.Point3d;

/**
 * This class creates a three-dimensional plane in three-dimensional space. The plane is restricted to the form
 * "Ax + By + Cz = D".
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public final class RestrictedPlane3d implements Plane3 {

    /**
     * X coefficient.
     */
    private final double A; // x coefficient
    /**
     * Y coefficient.
     */
    private final double B; // y coefficient
    /**
     * Z coefficient.
     */
    private final double C; // z coefficient
    /**
     * Constant.
     */
    private final double D; // Ax + By + Cz = D

    /**
     * Constructs a three-dimensional plane that is in the form {@code Ax + By + Cz = D}.
     *
     * @param a coefficient of x.
     * @param b coefficient of y.
     * @param c coefficient of z.
     * @param d constant.
     */
    public RestrictedPlane3d(double a, double b, double c, double d) {
        A = a;
        B = b;
        C = c;
        D = d;
    }

    /**
     * Constructs a plane based on the equation in constructor. The equation in the following form:
     * {@code Ax + By + Cz = D}.
     *
     * @param equation   of the three-dimensional plane.
     * @param deprecated this constructor does nothing in this class.
     * @since 7/13/2026 added this new feature, which allows user to construct three-dimensional plane easier.
     * @deprecated detracted since 7/19/2026.
     */
    @Deprecated
    public RestrictedPlane3d(String equation, char deprecated) {
        int indexOfX = equation.indexOf('x');
        int indexOfY = equation.indexOf('y');
        int indexOfZ = equation.indexOf('z');
        A = indexOfX == 0 ? 1 : Integer.parseInt(equation.substring(indexOfX - 1, indexOfX));
        B = Integer.parseInt(equation.charAt(indexOfY - 1) == ' ' ? "1" : equation.substring(indexOfY - 1, indexOfY));
        C = Integer.parseInt(equation.charAt(indexOfZ - 1) == ' ' ? "1" : equation.substring(indexOfZ - 1, indexOfZ));
        D = Integer.parseInt(equation.substring(equation.indexOf('=') + 2));
    }

    /**
     * Constructs a plane based on the equation in constructor. The equation in following form:
     * {@code Ax + By + Cz = D}.
     *
     * @param equation the string representation of the equation of the plane.
     * @since 7/20/2026 this is the newer version of the constructor RestrictedPlane3d(String equation).
     */
    public RestrictedPlane3d(String equation) {
        String[] parts = equation.split(" ");
        // Ax
        int xIndex = parts[0].indexOf('x');
        String str = parts[0].substring(0, xIndex);
        if (str.isEmpty()) {
            A = 1.0;
        } else if (str.length() == 1 || str.length() == 2) {
            A = Double.parseDouble(str);
        } else {
            A = Double.MIN_VALUE;
        }

        // By
        int yIndex = parts[1].indexOf('y');
        str = parts[1].substring(0, yIndex);
        if (str.isEmpty()) {
            B = 1.0;
        } else if (str.length() == 1 || str.length() == 2) {
            B = Double.parseDouble(str);
        } else {
            B = Double.MIN_VALUE;
        }

        // Cz
        int zIndex = parts[3].indexOf('z');
        str = parts[3].substring(0, zIndex);
        if (str.isEmpty()) {
            C = 1.0;
        } else if (str.length() == 1 || str.length() == 2) {
            C = Double.parseDouble(str);
        } else {
            C = Double.MIN_VALUE;
        }

        // D
        str = parts[parts.length - 1];
        if (str.isEmpty()) {
            D = 1.0;
        } else if (str.length() == 1  || str.length() == 2) {
            D = Double.parseDouble(str);
        } else  {
            D = Double.MIN_VALUE;
        }
    }

    /**
     * The intersection of two three-dimensional planes is a three-dimensional line. This method finds that intersecting
     * line of this plane and the plane in the parameter of this method.
     *
     * @param plane3 other three-dimensional plane that is not null.
     * @return the intersecting line of this plane and the parameter plane3.
     */
    @Override
    public Line3d intersect(RestrictedPlane3d plane3) {
        Vector3d direction = this.getNormal().crossProduct(plane3.getNormal(), true);
        Point3d point = this.findPointOnLine(plane3);
        if (point == null) {
            System.out.println("The two planes are parallel, no line of intersection!");
            return null;
        }
        return new Line3d(point, direction);
    }

    private Point3d findPointOnLine(RestrictedPlane3d plane3) {
        Point3d point = this.assumeZeroAt(plane3, "x");
        if (point == null) {
            point = this.assumeZeroAt(plane3, "y");
        }
        if (point == null) {
            point = this.assumeZeroAt(plane3, "z");
        }
        return point;
    }

    /**
     * A(x1) + By1 + Cz2 = D1
     * A(x2) + By2 + Cz2 = D2
     *
     * @param coordinate that is assumed to be 0.
     * @return the point on the line of intersection.
     */
    private Point3d assumeZeroAt(RestrictedPlane3d plane3, String coordinate) {
        if (A == 0 || B == 0 || C == 0) {
            return null;
        }
        if (A == plane3.A && B == plane3.B && C == plane3.C) {
            return null;
        }

        Matrix2d coefficientMatrix;
        FixedMatrix.Matrix21d constantMatrix = new FixedMatrix.Matrix21d(this.D, plane3.D);
        switch (coordinate) {
            // x = 0
            case "x" -> {
                coefficientMatrix = new Matrix2d(this.B, this.C, plane3.B, plane3.C);
                Matrix2d inverse = coefficientMatrix.inverse();
                if (inverse == null) {
                    return null;
                }
                FixedMatrix.Matrix21d answer = inverse.multiply(constantMatrix);
                return new Point3d(0, answer.a11(), answer.a21());
            }

            // y = 0
            case "y" -> {
                coefficientMatrix = new Matrix2d(this.A, this.C, plane3.A, plane3.C);
                Matrix2d inverse = coefficientMatrix.inverse();
                if (inverse == null) {
                    return null;
                }
                FixedMatrix.Matrix21d answer = inverse.multiply(constantMatrix);
                return new Point3d(answer.a11(), 0, answer.a21());
            }

            // z = 0
            case "z" -> {
                coefficientMatrix = new Matrix2d(this.A, this.B, plane3.A, plane3.B);
                Matrix2d inverse = coefficientMatrix.inverse();
                if (inverse == null) {
                    return null;
                }
                FixedMatrix.Matrix21d answer = inverse.multiply(constantMatrix);
                return new Point3d(answer.a11(), answer.a21(), 0);
            }
        }
        System.err.println("[ERROR]: Unknown command: " + coordinate);
        return null;
    }

    /**
     * Gets the normal vector of this three-dimensional plane. The normal vector of a plane is the three-dimensional
     * vector that consists the coefficients of x, y, and z of the equation of the plane.
     *
     * @return the normal vector of this plane.
     */
    @Override
    public Vector3d getNormal() {
        return new Vector3d(A, B, C);
    }

    /**
     * Calculates the distance between two three-dimensional parallel planes. Note that if two planes have
     * intersection, the distance between these two planes is zero. You can easily tell whether two planes are parallel
     * by looking at the coefficients of two planes. The two planes are parallel if the first plane's and second plane's
     * x, y, and z coefficients are the same.
     *
     * @param other plane that is not null.
     * @return the distance between this plane and the other plane.
     * @since 7/14/2026 part of Plane-to-Plane-Distance equation update.
     */
    @Override
    public double distance(RestrictedPlane3d other) {
        if (this.A != other.A || this.B != other.B || this.C != other.C) {
            return 0;
        }
        return Math.abs(this.D - other.D) / Math.sqrt(this.A * this.A + this.B * this.B + this.C * this.C);
    }

    /**
     * This method returns the formatted distance between two parallel planes. I know this is kind of redundant to
     * {@link Plane3#distance(RestrictedPlane3d)}, but I don't want to change this method to something like
     * "formatted_distance"
     * or something else that sounds too long. I want every method name to read as simple as possible.
     *
     * @param other  plane that is not null.
     * @param format a boolean flag for user to choose whether to format the answer.
     * @return the formatted distance between two planes if "format" boolean flag is true.
     * @since 7/15/2026
     */
    public double distance(RestrictedPlane3d other, boolean format) {
        return format ? NumberFormatter.format(this.distance(other)) : this.distance(other);
    }

    /**
     * Calculate the distance from a plane to point.
     *
     * @param other point that is not null.
     * @return the distance from plane to point.
     * @since 7/14/2026 part of Plane-to-Plane-Distance equation update.
     */
    @Override
    public double distance(Point3d other) {
        Point3d pt = new Point3d(0, 0, this.D / this.C);
        Vector3d direction = new Vector3d((other.getX() - pt.getX()), (other.getY() - pt.getY()), (other.getZ() - pt.getZ()));
        Vector3d normal = this.getNormal();
        return Math.abs(direction.dot_product(normal)) / normal.length();
    }

    /**
     * Calculate the distance from a line to the plane. If the line is not parallel to the plane, the distance between
     * them is zero.
     *
     * @param other three-dimensional line that is not null.
     * @return the distance between line and plane.
     * @since 7/17/2026
     */
    @Override
    public double distance(Line3d other) {
        if (!isParallel(other)) return 0;
        Point3d pointOnPlane = new Point3d(0, 0, this.C);
        Point3d pointOnLine = other.getStartingPoint();
        return pointOnPlane.toVector3d(pointOnLine).scalar_projection(this.getNormal());
    }

    /**
     * Similar to {@link RestrictedPlane3d#distance(RestrictedPlane3d, boolean)}. Gives the formatted distance between a
     * plane and a line.
     *
     * @param other  three-dimensional line that is not null.
     * @param format a boolean flag that allows user to choose whether format the answer or not.
     * @return the formatted distance between a plane and a line if the "format" boolean flag is true.
     * @since 7/17/2026
     */
    public double distance(Line3d other, boolean format) {
        return format ? NumberFormatter.format(this.distance(other)) : this.distance(other);
    }

    /**
     * Determines if the line is parallel to the plane.
     *
     * @param other three-dimensional line that is not null.
     * @return true if the plane is parallel to the line.
     * @since 7/17/2026 helper method of {@link RestrictedPlane3d#distance(Line3d)}.
     */
    private boolean isParallel(Line3d other) {
        return this.getNormal().dot_product(other.getDirection()) == 0d;
    }

    /**
     * Similar to {@link RestrictedPlane3d#distance(RestrictedPlane3d, boolean)}. Gives the formatted distance between a
     * plane and a point.
     *
     * @param other  three-dimensional point that is not null.
     * @param format a boolean flag that allows user to choose whether format the answer or not.
     * @return the formatted distance between a plane and a point if the "format" boolean flag is true.
     * @since 7/16/2026
     */
    public double distance(Point3d other, boolean format) {
        return format ? NumberFormatter.format(this.distance(other)) : this.distance(other);
    }

    @Override
    public String toString() {
        return A + "x + " + B + "y + " + C + "z = " + D;
    }
}
