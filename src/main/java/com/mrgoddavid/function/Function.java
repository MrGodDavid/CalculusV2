package com.mrgoddavid.function;

/**
 * Defines an one-variable function.
 *
 * @author Mr. GodDavid
 * @since 7/26/2026 part of Function Update.
 */
public class Function {

    private final FunctionExpression function;

    public Function(FunctionExpression function) {
        this.function = function;
    }

    public double output(double x) {
        return function.output(x);
    }


}
