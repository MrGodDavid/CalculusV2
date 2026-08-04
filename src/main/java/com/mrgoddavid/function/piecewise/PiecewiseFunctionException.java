package com.mrgoddavid.function.piecewise;

import java.io.Serial;

/**
 * This is the root class for all exceptions thrown in {@link PiecewiseFunction}.
 *
 * @author Mr. GodDavid
 * @since 8/4/2026
 */
public class PiecewiseFunctionException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -4593078909629290884L;

    /**
     * Constructs the root class for all exceptions thrown in {@link PiecewiseFunction}.
     *
     * @param message reason of why throwing this exception.
     */
    public PiecewiseFunctionException(String message) {
        super(message);
    }
}
