package com.mrgoddavid.vector.space.line;

import com.mrgoddavid.matrix.FixedMatrix;
import com.mrgoddavid.matrix.Matrix2d;
import com.mrgoddavid.utils.Constants;
import com.mrgoddavid.vector.Vector;
import com.mrgoddavid.vector.Vector3d;
import com.mrgoddavid.vector.Vector3i;
import com.mrgoddavid.vector.space.point.Point3d;

import static com.mrgoddavid.utils.Constants.EPSILON;

/**
 * The definition of a three-dimensional line is in this form:
 * {@code r(t) = <x_0,y_0,z_0> + t<a, b, c>}.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public final class Line3d implements Line.Line3 {

    private final Point3d startingPoint;
    private final Vector3d direction;

    /**
     * Constructs a three-dimensional line with starting point and direction vector.
     *
     * @param startingPoint of the line and it is not null.
     * @param direction     the direction vector of this line and it is not null.
     */
    public Line3d(Point3d startingPoint, Vector3d direction) {
        this.startingPoint = startingPoint;
        this.direction = direction;
    }

    /**
     * Accessor of the instance field {@code startingPoint} of this class.
     *
     * @return the value of the instance field {@code startingPoint}.
     */
    public Point3d getStartingPoint() {
        return startingPoint;
    }

    /**
     * Accessor of the instance field {@code direction} of this class.
     *
     * @return the value of the instance field {@code direction}.
     */
    public Vector3d getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "r(t) = " + "<" + startingPoint.getX() + ", " + startingPoint.getY() + ", " + startingPoint.getZ() + ">" + " + t" +
                direction.toString();
    }

    /**
     * Checks whether two three-dimensional lines intersect each other. The definition of the equation of a line is
     * <pre>{@code r(t) = &lt;x1, y1, z1 &gt; + t&lt;a, b, c&gt;}</pre>.
     * <p>We define r1(t) = &lt;x1, y1, z1 &gt; + t&lt;a1, b1, c1&gt; and r2(s) = &lt;x2, y2, z2 &gt; + s&lt;a2, b2,
     * c2&gt;</p>. Both lines' x, y, and z coordinates are equal to each other at the intersecting point. With that in
     * mind, we can construct the follow relationships: {@code x1 + ta1 = x2 + sa2}, {@code y1 + tb1 = y2 + sb2}, and
     * {@code z1 + tc1 = z2 + sc2}. The idea here is to pick two of the equations to solve for {@code t} and {@code s}.
     * We then substitute {@code t} and {@code s} into the third equation to check if both sides of the equation equal
     * to each other. If the third equation passes the test, we say r1(t) and r2(s) intersects each other and otherwise
     * the two lines don't have intersection.
     *
     * @param other three-dimensional line that is not null.
     * @return true if two three-dimensional intersect each other and false otherwise.
     * @since 7/19/2026 added this method.
     */
    public boolean intersect(Line3d other) {
        if (isParallel(other)) {
            return false;
        }
        return checkXYEquation(other)
                || checkXZEquation(other)
                || checkYZEquation(other);
    }


    /**
     * Checks the t and s from the solution of solving just the x's and y's equations fit the z's (third) equation.
     *
     * @param other line that is not null.
     * @return true if t and s come from the solution of the x's and y's equations fit the z's equation.
     */
    private boolean checkXYEquation(Line3d other) {
        // r1(t) = <x1, y1, z1> + t<a1, b1, c1> = <x1 + a1t, y1 + b1t, z1 + c1t>
        // r2(s) = <x2, y2, z2> + s<a2, b2, c2> = <x2 + a2s, y2 + b2s, z2 + c2s>
        Matrix2d coefficientMatrix = new Matrix2d(
                direction.getX(), -other.getDirection().getX(),
                direction.getY(), -other.getDirection().getY()
        );
        Matrix2d inverse = coefficientMatrix.inverse();
        if (inverse == null) {
            return false;
        }
        FixedMatrix.Matrix21d constants = new FixedMatrix.Matrix21d(
                other.getStartingPoint().getX() - startingPoint.getX(),
                other.getStartingPoint().getY() - startingPoint.getY()
        );
        FixedMatrix.Matrix21d solution = inverse.multiply(constants);

        double t = solution.a11();
        double s = solution.a21();

        double z1 = startingPoint.getZ() + t * direction.getZ();
        double z2 = other.getStartingPoint().getZ() + s * other.getDirection().getZ();

        return Math.abs(z1 - z2) < EPSILON;
    }

    /**
     * Checks the t and s from the solution of solving just the y's and z's equations fit the x's (first) equation.
     *
     * @param other line that is not null.
     * @return true if t and s come from the solution of the y's and z's equations fit the x's equation.
     */
    private boolean checkYZEquation(Line3d other) {
        // r1(t) = <x1, y1, z1> + t<a1, b1, c1> = <x1 + a1t, y1 + b1t, z1 + c1t>
        // r2(s) = <x2, y2, z2> + s<a2, b2, c2> = <x2 + a2s, y2 + b2s, z2 + c2s>
        Matrix2d coefficientMatrix = new Matrix2d(
                direction.getY(), -other.getDirection().getY(),
                direction.getZ(), -other.getDirection().getZ()
        );
        Matrix2d inverse = coefficientMatrix.inverse();
        if (inverse == null) {
            return false;
        }
        FixedMatrix.Matrix21d constants = new FixedMatrix.Matrix21d(
                other.getStartingPoint().getY() - startingPoint.getY(),
                other.getStartingPoint().getZ() - startingPoint.getZ()
        );
        FixedMatrix.Matrix21d solution = inverse.multiply(constants);

        double t = solution.a11();
        double s = solution.a21();

        double x1 = startingPoint.getX() + t * direction.getX();
        double x2 = other.getStartingPoint().getX() + s * other.getDirection().getX();

        return Math.abs(x1 - x2) < EPSILON;
    }

    /**
     * Checks the t and s from the solution of solving just the x's and z's equations fit the y's (second) equation.
     *
     * @param other line that is not null.
     * @return true if t and s come from the solution of the x's and z's equations fit the y's equation.
     */
    private boolean checkXZEquation(Line3d other) {
        // r1(t) = <x1, y1, z1> + t<a1, b1, c1> = <x1 + a1t, y1 + b1t, z1 + c1t>
        // r2(s) = <x2, y2, z2> + s<a2, b2, c2> = <x2 + a2s, y2 + b2s, z2 + c2s>
        Matrix2d coefficientMatrix = new Matrix2d(
                direction.getX(), -other.getDirection().getX(),
                direction.getZ(), -other.getDirection().getZ()
        );
        Matrix2d inverse = coefficientMatrix.inverse();
        if (inverse == null) {
            return false;
        }
        FixedMatrix.Matrix21d constants = new FixedMatrix.Matrix21d(
                other.getStartingPoint().getX() - startingPoint.getX(),
                other.getStartingPoint().getZ() - startingPoint.getZ()
        );
        FixedMatrix.Matrix21d solution = inverse.multiply(constants);

        double t = solution.a11();
        double s = solution.a21();

        double y1 = startingPoint.getY() + t * direction.getY();
        double y2 = other.getStartingPoint().getY() + s * other.getDirection().getY();

        return Math.abs(y1 - y2) < EPSILON;
    }

    /**
     * Calculates the distance between this three-dimensional line to the {@code other} three-dimensional line.
     *
     * @param other line that is not null.
     * @return the distance between this line and other line.
     * @since 7/17/2026
     */
    @Override
    public double distance(Line3d other) {
        if (intersect(other)) {
            return 0;
        }
        Vector3d normal = this.direction.crossProduct(other.direction);
        Vector3d dir = new Vector3d(
                startingPoint.getX() - other.startingPoint.getX(),
                startingPoint.getY() - other.startingPoint.getY(),
                startingPoint.getZ() - other.startingPoint.getZ()
        );
        return dir.scalar_projection(normal);
    }

    /**
     * Determines whether the given three-dimensional point is on this line.
     *
     * @param point other point that is not null.
     * @return true if the point is on the line and false otherwise.
     * @since 7/17/2026
     */
    private boolean isPointOnLine(Point3d point) {
        double t_x = (startingPoint.getX() - point.getX()) / (double) direction.getX();
        double t_y = (startingPoint.getY() - point.getY()) / (double) direction.getY();
        double t_z = (startingPoint.getZ() - point.getZ()) / (double) direction.getZ();
        return t_x == t_y && t_x == t_z;
    }

    /**
     * Determines whether this line is parallel to the {@code other} line.
     *
     * @param other line that is not null.
     * @return true if this line is parallel to {@code other} line.
     * @since 7/17/2026
     */
    private boolean isParallel(Line3d other) {
        return this.direction.crossProduct(other.getDirection()).compareWith(Vector3d.ZERO_VECTOR3D, Vector.ComparisonCommand.EQUALS);
    }
}
