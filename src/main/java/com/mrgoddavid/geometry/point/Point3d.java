package com.mrgoddavid.geometry.point;

import com.mrgoddavid.vector.immutable.ImmutableVector3d;

import java.io.Serial;

/**
 * A three-dimensional point in three-dimensional space. The point has three coordinates: the x coordinate, the y
 * coordinate, and the z coordinate. Formal notation is {@code (X, y, z)}.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
@SuppressWarnings("ClassCanBeRecord")
public final class Point3d implements Point.Point3<Point3d> {

    @Serial
    private static final long serialVersionUID = -4922733615161342627L;
    /**
     * X coordinate.
     */
    private final double x;
    /**
     * Y coordinate.
     */
    private final double y;
    /**
     * Z coordinate.
     */
    private final double z;

    /**
     * Default constructor that constructs a three-dimensional point.
     */
    public Point3d() {
        this(0.0, 0.0, 0.0);
    }

    /**
     * Constructs a three-dimensional point.
     *
     * @param x coordinate of the point.
     * @param y coordinate of the point.
     * @param z coordinate of the point.
     */
    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Accessor of the x coordinate.
     *
     * @return the value of the x coordinate.
     */
    public double x() {
        return x;
    }

    /**
     * Accessor of the y coordinate.
     *
     * @return the value of the y coordinate.
     */
    public double y() {
        return y;
    }

    /**
     * Accessor of the z coordinate.
     *
     * @return the value of the z coordinate.
     */
    public double z() {
        return z;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }

    /**
     * Calculates the distance between two points.
     *
     * @param other point that is not null.
     * @return the distance between two points.
     */
    @Override
    public double distance(Point3d other) {
        return toVector3d(other).length();
    }

    /**
     * Calculates the vector from this point, which is the starting point, to the ending point, which is given in
     * the
     * parameter.
     *
     * @param endpoint that is not null.
     * @return the vector that starts from this point to the ending point.
     * @since 7/17/2026
     */
    @Override
    public ImmutableVector3d toVector3d(Point3d endpoint) {
        return new ImmutableVector3d(endpoint.x - x, endpoint.y - y, endpoint.z - z);
    }
}
