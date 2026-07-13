package com.mrgoddavid.vector.space.plane;

import com.mrgoddavid.matrix.FixedMatrix;
import com.mrgoddavid.matrix.Matrix2i;
import com.mrgoddavid.vector.Vector3i;
import com.mrgoddavid.vector.space.line.Line3;
import com.mrgoddavid.vector.space.point.Point3;

/**
 * This class creates a three-dimensional plane in three-dimensional space.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public final class Plane3d implements Plane3 {

    private final int A; // x coefficient
    private final int B; // y coefficient
    private final int C; // z coefficient
    private final int D; // Ax + By + Cz = D

    public Plane3d(int a, int b, int c, int d) {
        A = a;
        B = b;
        C = c;
        D = d;
    }

    /**
     * Constructs a plane based on the equation in constructor. The constructor MUST be in the following form:
     * {@code Ax + By + Cz = D}.
     *
     * @param equation of the three-dimensional plane.
     * @author Mr. GodDavid
     * @since 7/13/2026 added this new feature, which allows user to construct three-dimensional plane easier.
     */
    public Plane3d(String equation) {
        int indexOfX = equation.indexOf('x');
        int indexOfY = equation.indexOf('y');
        int indexOfZ = equation.indexOf('z');
        A = indexOfX == 0 ? 1 : Integer.parseInt(equation.substring(indexOfX - 1, indexOfX));
        B = Integer.parseInt(equation.charAt(indexOfY - 1) == ' ' ? "1" : equation.substring(indexOfY - 1, indexOfY));
        C = Integer.parseInt(equation.charAt(indexOfZ - 1) == ' ' ? "1" : equation.substring(indexOfZ - 1, indexOfZ));
        D = Integer.parseInt(equation.substring(equation.indexOf('=') + 2));
    }

    /**
     * The intersection of two three-dimensional planes is a three-dimensional line. This method finds that intersecting
     * line of this plane and the plane in the parameter of this method.
     *
     * @param plane3 other three-dimensional plane that is not null.
     * @return the intersecting line of this plane and the parameter plane3.
     */
    @Override
    public Line3 intersect(Plane3d plane3) {
        Vector3i direction = this.getNormal().crossProduct(plane3.getNormal(), true);
        Point3 point = this.findPointOnLine(plane3);
        return new Line3(point, direction);
    }

    private Point3 findPointOnLine(Plane3d plane3) {
        Point3 point = this.assumeZeroAt(plane3, "x");
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
    private Point3 assumeZeroAt(Plane3d plane3, String coordinate) {
        if (A == 0 || B == 0 || C == 0) {
            return null;
        }
        if (A == plane3.A && B == plane3.B && C == plane3.C) {
            return null;
        }

        Matrix2i coefficientMatrix;
        FixedMatrix.Matrix21i constantMatrix = new FixedMatrix.Matrix21i(this.D, plane3.D);
        switch (coordinate) {
            // x = 0
            case "x" -> {
                coefficientMatrix = new Matrix2i(this.B, this.C, plane3.B, plane3.C);
                Matrix2i inverse = coefficientMatrix.inverse();
                if (inverse == null) {
                    return null;
                }
                FixedMatrix.Matrix21i answer = inverse.multiply(constantMatrix);
                return new Point3(0, answer.a11(), answer.a21());
            }

            // y = 0
            case "y" -> {
                coefficientMatrix = new Matrix2i(this.A, this.C, plane3.A, plane3.C);
                Matrix2i inverse = coefficientMatrix.inverse();
                if (inverse == null) {
                    return null;
                }
                FixedMatrix.Matrix21i answer = inverse.multiply(constantMatrix);
                return new Point3(answer.a11(), 0, answer.a21());
            }

            // z = 0
            case "z" -> {
                coefficientMatrix = new Matrix2i(this.A, this.B, plane3.A, plane3.B);
                Matrix2i inverse = coefficientMatrix.inverse();
                if (inverse == null) {
                    return null;
                }
                FixedMatrix.Matrix21i answer = inverse.multiply(constantMatrix);
                return new Point3(answer.a11(), answer.a21(), 0);
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
    public Vector3i getNormal() {
        return new Vector3i(A, B, C);
    }

    @Override
    public String toString() {
        return A + "x + " + B + "y " + C + "z = " + D;
    }
}
