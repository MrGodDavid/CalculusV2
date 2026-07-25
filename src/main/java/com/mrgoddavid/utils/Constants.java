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
     * 14 decimal places of the square root of 2.
     */
    public static final double SQRT_2 = 1.41421356237310;

    /**
     * 14 decimal places of the square root of 3.
     */
    public static final double SQRT_3 = 1.73205080756888;

    /**
     * 14 decimal places of PI.
     */
    public static final double PI = 3.14159265358979;

    /**
     * 14 decimal places of PI / 4.
     */
    public static final double PI_OVER_FOUR = 0.78539816339745;

    /**
     * 14 decimal places of PI / 2.
     */
    public static final double PI_OVER_TWO = 1.57079632679489;

    /**
     * 14 decimal places of 3 * PI / 2.
     */
    public static final double THREE_PI_OVER_TWO = 4.71238898038469;

    /**
     * 14 decimal places of 2 * PI.
     */
    public static final double TWO_PI = 6.28318530717958;

    /**
     * e.
     */
    public static final double E = 2.718281828459045;

    /**
     * Private constructor.
     *
     * @throws IllegalAccessException because user cannot instantiate this class.
     */
    private Constants() throws IllegalAccessException {
        throw new UninstantiableClassInstantiationException();
    }
}
