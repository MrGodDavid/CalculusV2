package com.mrgoddavid.geometry.line;


import com.mrgoddavid.geometry.point.Point3d;

/**
 * This is the root interface of line in spacial vector.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public interface Line {

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
