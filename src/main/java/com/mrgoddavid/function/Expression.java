package com.mrgoddavid.function;

/**
 * This functional interface describes f(x). The data type of x is a double in this case.
 *
 * @author Mr. GodDavid
 * @since 7/26/2026 Function Update.
 */
@FunctionalInterface
public interface Expression {

    /**
     * This is the place where declaring the function with independent variable as x.
     *
     * @param x independent variable of this function.
     * @return the output of this function based on the input x.
     */
    double value(double x);

    default Expression add(Expression second) {
        return x -> this.value(x) + second.value(x);
    }

    default Expression subtract(Expression second) {
        return x -> this.value(x) - second.value(x);
    }

    default Expression multiply(Expression second) {
        return x -> this.value(x) * second.value(x);
    }

    default Expression divide(Expression denominator) {
        return x -> this.value(x) / denominator.value(x);
    }
}
