package com.mrgoddavid.vector.space.point;

import java.io.Serializable;

/**
 * This is the root class for all points.
 *
 * @author Mr. GodDavod
 * @since 7/14/2026 part of the Plane-to-Plane-Distance equation feature.
 */
public interface Point<T> extends Serializable {

    /**
     * Calculates the distance between two points.
     * @param other point that is not null.
     * @return the distance between two points.
     */
    double distance(T other);

    /**
     * Interface
     * @param <T>
     */
    interface Point3<T extends Point3d> extends Point<T>, Serializable {

    }
}


