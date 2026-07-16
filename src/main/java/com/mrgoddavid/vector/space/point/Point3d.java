package com.mrgoddavid.vector.space.point;

/**
 * A three-dimensional point in three-dimensional space. The point has three coordinates: the x coordinate, the y
 * coordinate, and the z coordinate. Formal notation is {@code (X, y, z)}.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public final class Point3d implements Point.Point3<Point3d> {

    private final double x, y, z;

    public Point3d() {
        this(0, 0, 0);
    }

    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
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
        double dx = Math.abs(x - other.x);
        double dy = Math.abs(y - other.y);
        double dz = Math.abs(z - other.z);
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
