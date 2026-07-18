package com.mrgoddavid.utils;

import java.text.DecimalFormat;

/**
 * Formates the number to keep three decimal places.
 *
 * @author Mr. GodDavid
 * @since 7/16/2026
 */
public final class NumberFormatter {

    /**
     * Pattern constant.
     */
    private static final String FORMATTING_PATTERN = "#.###";

    /**
     * Private constructor.
     *
     * @throws IllegalAccessException because this utility class cannot be instantiated.
     */
    private NumberFormatter() throws IllegalAccessException {
        throw new IllegalAccessException("You cannot instantiate this class because \"NumberFormatter\" is an utility class!");
    }

    /**
     * Formats an integer.
     *
     * @param n must be an integer
     * @return the formatted integer.
     */
    public static int format(int n) {
        return Integer.parseInt(new DecimalFormat(FORMATTING_PATTERN).format(n));
    }

    /**
     * Formats a double.
     *
     * @param n must be a double
     * @return the formatted double.
     */
    public static double format(double n) {
        return Double.parseDouble(new DecimalFormat(FORMATTING_PATTERN).format(n));
    }

    /**
     * Formats a long.
     *
     * @param n must be a long
     * @return the formatted long.
     */
    public static long format(long n) {
        return Long.parseLong(new DecimalFormat(FORMATTING_PATTERN).format(n));
    }

    /**
     * Formats a float.
     *
     * @param n must be a float
     * @return the formatted float.
     */
    public static float format(float n) {
        return Float.parseFloat(new DecimalFormat(FORMATTING_PATTERN).format(n));
    }
}
