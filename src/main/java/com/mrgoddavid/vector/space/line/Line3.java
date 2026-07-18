package com.mrgoddavid.vector.space.line;

import com.mrgoddavid.vector.Vector;
import com.mrgoddavid.vector.Vector3i;
import com.mrgoddavid.vector.space.point.Point3d;

/**
 * The definition of a three-dimensional line is in this form:
 * {@code r(t) = <x_0,y_0,z_0> + t<a, b, c>}.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public final class Line3 implements Line.Line3 {

    private final Point3d startingPoint;
    private final Vector3i direction;

    public Line3(Point3d startingPoint, Vector3i direction) {
        this.startingPoint = startingPoint;
        this.direction = direction;
    }

    public Point3d getStartingPoint() {
        return startingPoint;
    }

    public Vector3i getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "r(t) = " + "<" + startingPoint.getX() + ", " + startingPoint.getY() + ", " + startingPoint.getZ() + ">" + " + t" +
                direction.toString();
    }

    /**
     * Calculates the distance between this three-dimensional line to the {@code other} three-dimensional line.
     *
     * @param other line that is not null.
     * @return the distance between this line and other line.
     * @author Mr. GodDavid
     * @since 7/17/2026
     */
    @Override
    public double distance(com.mrgoddavid.vector.space.line.Line3 other) {
        if (!isParallel(other)) {
            return 0;
        }
        return -999;
    }

    /**
     * Determines whether the given three-dimensional point is on this line.
     *
     * @param point other point that is not null.
     * @return true if the point is on the line and false otherwise.
     * @author Mr. GodDavid
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
     * @author Mr. GodDavid
     * @since 7/17/2026
     */
    private boolean isParallel(com.mrgoddavid.vector.space.line.Line3 other) {
        return this.direction.crossProduct(other.getDirection()).compareWith(Vector3i.ZERO_VECTOR, Vector.ComparisonCommand.EQUALS);
    }
}
