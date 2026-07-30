package com.mrgoddavid.format.exception;

import java.io.Serial;

/**
 * This is the subclass of {@link UnsupportedCalculationException}. Throws this exception when user tries to calculate
 * the factorial of numbers that exceeds 12.
 */
public class UnsupportedFactorialCalculationException extends UnsupportedOperationException {
    @Serial
    private static final long serialVersionUID = 1722695952821236318L;

    /**
     * Constructs an UnsupportedFactorialCalculationException. Throws this exception when user tries to calculate the
     * factorial of numbers that exceeds 12.
     *
     * @param n the number that users attempted to calculate the factorial of. Uses this number for printing exception
     *          message.
     */
    public UnsupportedFactorialCalculationException(int n) {
        super("Unsupported factorial calculation since trying to calculate " + n + "! where " + n + " > 12.");
    }
}
