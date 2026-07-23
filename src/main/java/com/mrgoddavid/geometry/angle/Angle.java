package com.mrgoddavid.geometry.angle;

/**
 * The angle is the wideness between two rays. The angle is zero when two rays share the same starting point and
 * direction. The angle is 180 degrees when two rays share the same starting point but opposite direction. The angle can
 * be negative if and only if the second ray opens in clockwise direction.
 * <p>There are two types of angles: angles in degrees and angles in radians. 2pi radians is equal to 360 degrees.</p>
 * <p>This class is the root class for Degree class and Radian class.</p>
 *
 * @param <T> type parameter. This is the class type that implements this interface.
 * @author Mr. GodDavid
 * @since 7/22/2026 this is part of Angle Update feature.
 */
public interface Angle<T> {

    /**
     * Adds two angles.
     *
     * @param other angle that is not null.
     * @return the sum of two angles.
     */
    T add(T other);

    /**
     * Subtracts this angle from the given angle.
     *
     * @param other angle that is not null.
     * @return the difference between two angles.
     */
    T subtract(T other);

    /**
     * Multiplies this angle by a scalar that is a double.
     *
     * @param other the scalar.
     * @return the scaled angle.
     */
    T scale(double other);

    /**
     * Finds the half angle of this angle.
     *
     * @return the half angle of this angle.
     */
    T bisect();

    /**
     * Finds the one-third angle of this angle.
     *
     * @return the one-third angle of this angle.
     */
    T trisect();
}
