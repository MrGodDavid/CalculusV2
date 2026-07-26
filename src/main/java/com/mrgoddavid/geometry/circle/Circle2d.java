package com.mrgoddavid.geometry.circle;

import com.mrgoddavid.geometry.angle.Radian;
import com.mrgoddavid.geometry.point.Point2d;
import com.mrgoddavid.vector.Vector;
import com.mrgoddavid.vector.Vector2d;

import java.io.Serial;
import java.io.Serializable;

import static com.mrgoddavid.utils.Constants.*;

/**
 * This class defines a circle in three-dimensional space. This is hard to picture this circle at first. Imagine a
 * circle in two-dimensional xy-plane.
 * <p>In high school, we learn that we can use this equation, {@code x^2 + y^2 = r^2}
 * to graph a circle. Some key features about this equation are it tells us the centered point, {@code (0, 0)}, and
 * its radius is {@code r} units.</p>
 * <p>More general equation of a two-dimensional circle is {@code (x - h)^2 + (y - k)^2 = r^2}, which it tells as the
 * centered point is at {@code (h, k)}, and its radius is {@code r} units.</p>
 * <p>You might hear the parametric equation of a circle in two-dimensional space. Recall the parametric equation of
 * this circle, {@code x(theta) = rcos(theta), y(theta) = rsin(theta)}. Connect this idea with vectors. </p>
 * <p>Suppose we have a vector V = [x, y] and rotation matrix R = </p>
 * <pre>{@code
 * [cos(theta), -sin(theta)]
 * [sin(theta), cos(theta)]
 * }</pre>
 * <p>a = RV represents the rotation of V based on the origin.</p>
 *
 * @author Mr. GodDavid
 * @since 7/24/2026 part of Transformations & Circles Update.
 */
@SuppressWarnings("ClassCanBeRecord")
public final class Circle2d implements Serializable {

    @Serial
    private static final long serialVersionUID = -1419872634454081645L;
    /**
     * Center of the circle.
     */
    private final Point2d center;

    /**
     * Radius of the circle.
     */
    private final double radius;

    /**
     * Constructs a two-dimensional circle.
     *
     * @param center center point of this circle.
     * @param radius radius of this circle.
     */
    public Circle2d(Point2d center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Checks if the path of the circle contains the given two-dimensional point.
     *
     * @param point given point that is not null.
     * @return true if the given point is on the path of the circle and false otherwise.
     */
    public boolean contains(Point2d point) {
        double dx = point.x() - center.x();
        double dy = point.y() - center.y();
        Radian angle;

        if (dx == 0.0 && dy == 0.0) {
            return false;
        }

        if (dx == 0.0 && dy > 0.0) {
            angle = new Radian(PI_OVER_TWO);
        } else if (dx == 0.0 && dy < 0.0) {
            angle = new Radian(-PI_OVER_TWO);
        } else {
            angle = new Radian(Math.atan2(dy, dx));
        }

        Vector2d vector = new Vector2d(center.x() + radius, center.y());
        Vector2d new_vector = vector.rotate(angle);
        return vector.compareWith(new_vector, Vector.ComparisonCommand.EQUALS);
    }

    /**
     * Gets an array of endpoints of this circle. Gets the endpoint in east, north, west, and south.
     *
     * @return an array of endpoints of this circle.
     */
    private Point2d[] endpoints() {
        Vector2d vector = new Vector2d(center.x() + radius, center.y());

        Vector2d east = vector.rotate(new Radian(0));
        Vector2d north = vector.rotate(new Radian(PI_OVER_TWO));
        Vector2d west = vector.rotate(new Radian(THREE_PI_OVER_TWO));
        Vector2d south = vector.rotate(new Radian(TWO_PI));

        return new Point2d[]{
                new Point2d(center.x() + east.getX(), center.y() + east.getY()),
                new Point2d(center.x() + north.getX(), center.y() + north.getY()),
                new Point2d(center.x() + west.getX(), center.y() + west.getY()),
                new Point2d(center.x() + south.getX(), center.y() + south.getY())
        };
    }

    /**
     * Calculates the circumference of this circle.
     *
     * @return the circumference of this circle.
     */
    public double circumference() {
        return TWO_PI * radius;
    }

    /**
     * Calculates the area of this circle.
     *
     * @return the area of this circle.
     */
    public double area() {
        return PI * radius * radius;
    }

    /**
     * Accessor of the radius of this circle.
     *
     * @return the value of the radius of this circle.
     */
    public double radius() {
        return radius;
    }

    /**
     * Accessor of the center of this circle.
     *
     * @return the value of the center of this circle.
     */
    public Point2d center() {
        return center;
    }

    /**
     * Gives detailed information about this circle. Including centering point, radius, and endpoints.
     *
     * @return detailed information about this circle.
     */
    public String detailedInfo() {
        Point2d[] endpoints = this.endpoints();
        double c = this.circumference();
        double a = this.area();

        return "Circle : {center=" + center + ", radius=" + radius + "\n" +
                "endpoint1={" + endpoints[0] + "}\n" +
                "endpoint2={" + endpoints[1] + "}\n" +
                "endpoint3={" + endpoints[2] + "}\n" +
                "endpoint4={" + endpoints[3] + "}\n" +
                "circumference={" + c + "}\n" +
                "area={" + a + "}";
    }

    @Override
    public String toString() {
        return "Circle: {center=" + center + ", radius=" + radius + "}";
    }
}
