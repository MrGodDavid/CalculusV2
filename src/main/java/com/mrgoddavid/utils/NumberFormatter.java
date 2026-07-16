package com.mrgoddavid.utils;

import java.text.DecimalFormat;

/**
 * Formates the number to keep three decimal places.
 *
 * @author Mr. GodDavid
 * @since 7/16/2026
 */
public final class NumberFormatter {

    private static final String FORMATTING_PATTERN = "#.###";

    private NumberFormatter() throws IllegalAccessException {
        throw new IllegalAccessException("You cannot instantiate this class because \"NumberFormatter\" is an utility class!");
    }

    public static int format(int n) {
        return Integer.parseInt(new DecimalFormat(FORMATTING_PATTERN).format(n));
    }

    public static double format(double n) {
        return Double.parseDouble(new DecimalFormat(FORMATTING_PATTERN).format(n));
    }

    public static long format(long n) {
        return Long.parseLong(new DecimalFormat(FORMATTING_PATTERN).format(n));
    }

    public static float format(float n) {
        return Float.parseFloat(new DecimalFormat(FORMATTING_PATTERN).format(n));
    }
}
