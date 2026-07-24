package com.mrgoddavid.geometry.line;


import com.mrgoddavid.geometry.point.Point2d;
import com.mrgoddavid.geometry.point.Point3d;

/**
 * This is the root interface of line in spacial vector.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public interface Line {

    /**
     * Interface of a two-dimensional line. The definition of a two-dimensional line is in this form:
     * {@code r(t) = [x_0, y_0] + t[a, b]}.
     *
     * @author Mr. GodDavid
     * @since 7/23/2026 the part of Two-Dimensional Point And Line Update.
     */
    interface Line2 extends Line {

        /**
         * Determines whether this line is parallel to the {@code other} line.
         *
         * @param other two-dimensional line that is not null.
         * @return true if this line is parallel to {@code other} line and false otherwise.
         */
        boolean isParallel(Line2d other);

        /**
         * Determines whether this line and {@code other} line intersect each other.
         *
         * @param other two-dimensional line that is not null.
         * @return true if this line and {@code other} line have intersecting point.
         */
        boolean intersect(Line2d other);

        /**
         * Determines whether this line contains {@code other} point.
         *
         * @param other 2D point that is not null.
         * @return true if this ine contains the {@code other} point.
         */
        boolean contains(Point2d other);

        /**
         * Calculates the distance between two two-dimensional lines. The distance between two lines is zero if these
         * two lines have intersecting point.
         *
         * @param other line that is not null.
         * @return the distance between this line and {@code other} line.
         */
        double distance(Line2d other);
    }

    /**
     * Interface of a three-dimensional line. The definition of a three-dimensional line is in this form:
     * {@code r(t) = <x_0,y_0,z_0> + t<a, b, c>}.
     *
     * @author Mr. GodDavid
     * @since 7/13/2026
     */
    interface Line3 extends Line {

        /**
         * Determines whether this line is parallel to the {@code other} line.
         *
         * @param other line that is not null.
         * @return true if this line is parallel to {@code other} line.
         * @since 7/17/2026
         */
        boolean isParallel(Line3d other);

        /**
         * Checks whether this three-dimensional line intersects the other three-dimensional line.
         *
         * @param other three-dimensional line that is not null.
         * @return true if this line intersects the other line and false otherwise.
         */
        boolean intersect(Line3d other);

        /**
         * Determines whether the given three-dimensional point is on this line.
         *
         * @param point other point that is not null.
         * @return true if the point is on the line and false otherwise.
         * @since 7/17/2026
         */
        boolean contains(Point3d point);

        /**
         * Calculates the distance between this three-dimensional line to the {@code other} three-dimensional line.
         *
         * @param other line that is not null.
         * @return the distance between this line and other line.
         * @since 7/17/2026
         */
        double distance(Line3d other);
    }
}
