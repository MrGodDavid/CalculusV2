package com.mrgoddavid.geometry.line;

import com.mrgoddavid.geometry.point.Point2d;
import com.mrgoddavid.vector.Vector2d;

import java.io.Serializable;

import static com.mrgoddavid.utils.Constants.EPSILON;

/**
 * The definition of a three-dimensional line is in this form:
 * {@code r(t) = <x_0,y_0> + t<a, b>}.
 *
 * @author Mr. GodDavid
 * @since 7/23/2026 part of Two-Dimensional Point And Line Update.
 */
public final class Line2d implements Line.Line2, Serializable {

    /**
     * Starting point of this line.
     */
    private final Point2d startingPoint;
    /**
     * Direction of this line.
     */
    private final Vector2d direction;

    /**
     * Constructs a two-dimensional line with given starting point and direction.
     *
     * @param startingPoint of this line that is not null.
     * @param direction     of this line that is not null.
     */
    public Line2d(Point2d startingPoint, Vector2d direction) {
        this.startingPoint = startingPoint;
        this.direction = direction;
    }


    /**
     * Determines whether this line is parallel to the {@code other} line.
     *
     * @param other two-dimensional line that is not null.
     * @return true if this line is parallel to {@code other} line and false otherwise.
     */
    @Override
    public boolean isParallel(Line2d other) {
        return this.direction.cross_product(other.direction()) == 0.0;
    }

    /**
     * Determines whether this line and {@code other} line intersect each other.
     *
     * @param other two-dimensional line that is not null.
     * @return true if this line and {@code other} line have intersecting point.
     */
    @Override
    public boolean intersect(Line2d other) {
        return !isParallel(other);
    }

    /**
     * Determines whether this line contains {@code other} point.
     *
     * @param other 2D point that is not null.
     * @return true if this ine contains the {@code other} point.
     */
    @Override
    public boolean contains(Point2d other) {
        double tx = (other.x() - startingPoint.x()) / direction.getX();
        double ty = (other.y() - startingPoint.y()) / direction.getY();
        return Math.abs(tx - ty) <= EPSILON;
    }

    /**
     * Calculates the distance between two two-dimensional lines. The distance between two lines is zero if these
     * two lines have intersecting point.
     *
     * @param other line that is not null.
     * @return the distance between this line and {@code other} line.
     */
    @Override
    public double distance(Line2d other) {
        return 0;
    }

    /**
     * Accessor of the {@code starting point} of this line.
     *
     * @return the value of the {@code starting point} of this line.
     */
    public Point2d startingPoint() {
        return startingPoint;
    }

    /**
     * Accessor of the {@code direction} of this line.
     *
     * @return the value of the {@code direction} of this line.
     */
    public Vector2d direction() {
        return direction;
    }

    @Override
    public String toString() {
        return "r(t) = <" + startingPoint.x() + ", " + startingPoint.y() + ">" + "t" + direction;
    }
}
