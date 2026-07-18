package com.mrgoddavid.vector.space.line;


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
         * Calculates the distance between this three-dimensional line to the {@code other} three-dimensional line.
         *
         * @param other line that is not null.
         * @return the distance between this line and other line.
         * @since 7/17/2026
         */
        double distance(com.mrgoddavid.vector.space.line.Line3 other);
    }
}
