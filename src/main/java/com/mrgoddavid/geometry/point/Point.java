package com.mrgoddavid.geometry.point;

import com.mrgoddavid.vector.immutable.ImmutableVector2d;
import com.mrgoddavid.vector.immutable.ImmutableVector3d;

import java.io.Serializable;

/**
 * This is the root class for all points.
 *
 * @param <T> Class type for the class that implements this interface.
 * @author Mr. GodDavod
 * @since 7/14/2026 part of the Plane-to-Plane-Distance equation feature.
 */
public interface Point<T> extends Serializable {

    /**
     * Calculates the distance between two points.
     *
     * @param other point that is not null.
     * @return the distance between two points.
     */
    double distance(T other);

    /**
     * Interface of a two-dimensional point.
     *
     * @param <T> class type of the class that implements this interface.
     * @since 7/23/2026 part of the Two-Dimensional Point And Line Update.
     */
    interface Point2<T extends Point2d> extends Point<T> {

        /**
         * Calculates the vector starting from this point and has the given point as its end point.
         *
         * @param endPoint that is not null.
         * @return the vector starting from this point to the given point.
         */
        ImmutableVector2d toVector2d(T endPoint);
    }

    /**
     * Interface of a three-dimensional point.
     *
     * @param <T> class type of the implementing class of this interface.
     */
    interface Point3<T extends Point3d> extends Point<T> {

        /**
         * Calculates the vector from this point, which is the starting point, to the ending point, which is given in
         * the parameter.
         *
         * @param endpoint that is not null.
         * @return the vector that starts from this point to the ending point.
         * @since 7/17/2026
         */
        ImmutableVector3d toVector3d(T endpoint);
    }
}


