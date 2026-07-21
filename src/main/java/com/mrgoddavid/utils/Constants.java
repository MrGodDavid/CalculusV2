package com.mrgoddavid.utils;

import com.mrgoddavid.format.exception.UninstantiableClassInstantiationException;

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
        throw new UninstantiableClassInstantiationException();
    }
}
