package com.mrgoddavid.utils;

/**
 * Holds mathematics constants.
 *
 * @author Mr. GodDavid
 * @since 7/19/2026
 */
public final class Constants {

    public static final double EPSILON = 1E-10;

    /**
     * Private constructor.
     *
     * @throws IllegalAccessException because user cannot instantiate this class.
     */
    private Constants() throws IllegalAccessException {
        throw new IllegalAccessException("You cannot instantiate this class because this is an utility class.");
    }


}
