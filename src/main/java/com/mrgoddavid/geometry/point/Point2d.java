package com.mrgoddavid.geometry.point;

import com.mrgoddavid.vector.Vector2d;

import java.io.Serial;

/**
 * This class defines a two-dimensional point. A two-dimensional point contains x and y coordinate.
 *
 * @author Mr. GodDavid
 * @since 7/23/2026 part of Two-Dimensional Point And Line Update.
 */
@SuppressWarnings("ClassCanBeRecord")
public final class Point2d implements Point.Point2<Point2d> {

    @Serial
    private static final long serialVersionUID = 4657192481056013926L;
    /**
     * X coordinate of this point.
     */
    private final double x;
    /**
     * Y coordinate of this point.
     */
    private final double y;

    /**
     * Default constructor that constructs an origin point. In this case, the two-dimensional point is
     * {@code (0.0, 0.0)}.
     */
    public Point2d() {
        this(0.0, 0.0);
    }

    /**
     * Constructs a two-dimensional point with the given x and y coordinate.
     *
     * @param x the x coordinate of this point.
     * @param y the y coordinate of this point.
     */
    public Point2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the vector starting from this point and has the given point as its end point.
     *
     * @param endPoint that is not null.
     * @return the vector starting from this point to the given point.
     */
    @Override
    public Vector2d toVector2d(Point2d endPoint) {
        return new Vector2d(endPoint.x() - x, endPoint.y() - y);
    }

    /**
     * Calculates the distance between two points.
     *
     * @param other point that is not null.
     * @return the distance between two points.
     */
    @Override
    public double distance(Point2d other) {
        return toVector2d(other).length();
    }

    /**
     * Accessor of the x coordinate of this point.
     *
     * @return the value of the x coordinate of this point.
     */
    public double x() {
        return x;
    }

    /**
     * Accessor of the y coordinate of this point.
     *
     * @return the value of the y coordinate of this point.
     */
    public double y() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
