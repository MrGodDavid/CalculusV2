package com.mrgoddavid.vector.space.point;

/**
 * A three-dimensional point in three-dimensional space. The point has three coordinates: the x coordinate, the y
 * coordinate, and the z coordinate. Formal notation is {@code (X, y, z)}.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public final class Point3 {

    private final double x, y, z;

    public Point3() {
        this(0, 0, 0);
    }

    public Point3(double x, double y, double z) {
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
}
