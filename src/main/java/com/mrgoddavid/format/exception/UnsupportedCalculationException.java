package com.mrgoddavid.format.exception;

import java.io.Serial;

/**
 * Throws this exception when the user "explodes" the calculation of this library.
 *
 * @author Mr. GodDavid
 * @since 7/30/2026
 */
public class UnsupportedCalculationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -1963642319636544005L;

    /**
     * Constructs the UnsupportedCalculationException.
     *
     * @param message reason why the program threw this exception.
     */
    public UnsupportedCalculationException(String message) {
        super(message);
    }
}
