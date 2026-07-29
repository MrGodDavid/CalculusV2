package com.mrgoddavid.function;

/**
 * Defines an one-variable function.
 *
 * @author Mr. GodDavid
 * @since 7/26/2026 part of Function Update.
 */
public class Function {

    /**
     * Expression of the raw function.
     */
    private final FunctionExpression function;

    private final Limit limit;

    /**
     * Constructs a new function class by the given expression of this function.
     *
     * @param function expression of this function that is not null.
     */
    public Function(FunctionExpression function) {
        this.function = function;
        this.limit = new Limit(function);
    }

    /**
     * Calculates the output of the function by the given x value.
     *
     * @param x given independent value of this function.
     * @return the output of the function.
     */
    public double output(double x) {
        return function.value(x);
    }

    public double limitAt(double x) {
        return limit.limitAt(x);
    }

    public boolean inDomain(double x) {
        double result = function.value(x);
        return !Double.isNaN(result);
    }

    public void debug() {
        this.limit.debug();
    }

    public void endDebug() {
        this.limit.endDebug();
    }
}
