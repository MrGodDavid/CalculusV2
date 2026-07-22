package com.mrgoddavid.utils;

import com.mrgoddavid.format.exception.UninstantiableClassInstantiationException;

/**
 * Holds mathematics constants.
 *
 * @author Mr. GodDavid
 * @since 7/19/2026
 */
public final class Constants {

    /**
     * Threshold in the float-point comparison of two numbers.
     */
    public static final double EPSILON = 1E-10;

    /**
     * Ten decimal places of the square root of 2.
     */
    public static final double SQRT_2 = 1.41421356237310;

    /**
     * Ten decimal places of the square root of 3.
     */
    public static final double SQRT_3 = 1.73205080756888;

    /**
     * Private constructor.
     *
     * @throws IllegalAccessException because user cannot instantiate this class.
     */
    private Constants() throws IllegalAccessException {
        throw new UninstantiableClassInstantiationException();
    }
}
