package com.mrgoddavid.vector;

/**
 * Interface for operations of three-dimensional vectors. This interface extends {@link Vector}.
 *
 * @param <T> type parameter. Class type of implementation of this interface.
 * @author Mr. GodDavid
 * @since 6/9/2026
 */
public interface Vector3<T> extends Vector<T> {

    /**
     * Calculate the cross product of two three-dimensional vectors.
     *
     * @param other three-dimensional vector that is not null.
     * @return the cross product of two three-dimensional vectors.
     */
    T crossProduct(T other);
}
