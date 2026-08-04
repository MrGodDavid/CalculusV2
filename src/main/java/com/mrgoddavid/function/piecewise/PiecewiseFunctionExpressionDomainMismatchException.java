package com.mrgoddavid.function.piecewise;

import java.io.Serial;

/**
 * Throws this exception when user trying to instantiate {@link PiecewiseFunction} class but
 * failed to provide equal amount of function expressions and domain fields.
 */
public class PiecewiseFunctionExpressionDomainMismatchException extends PiecewiseFunctionException {

    @Serial
    private static final long serialVersionUID = -8595230358648173181L;

    /**
     * Constructs a PiecewiseFunctionExpressionDomainMismatchException.
     *
     * @param funcArgs   number of functions in piecewise function. Helps debug.
     * @param domainArgs number of domain fields in piecewise function. Helps debug.
     */
    public PiecewiseFunctionExpressionDomainMismatchException(int funcArgs, int domainArgs) {
        super("Failed to create piecewise function because number of function expression: " + funcArgs
                + "does not match with the number of domain field: " + domainArgs);
    }
}
