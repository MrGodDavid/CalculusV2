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

    /**
     * Combines two numerical lambda expressions via adding.
     *
     * @param second the lambda expression that is not null.
     * @return the result after addition of these two expressions.
     */
    default Expression add(Expression second) {
        return x -> this.value(x) + second.value(x);
    }

    /**
     * Combines two numerical lambda expressions via subtracting.
     *
     * @param second the lambda expression that is not null.
     * @return the result after subtraction of these two expressions.
     */
    default Expression subtract(Expression second) {
        return x -> this.value(x) - second.value(x);
    }

    /**
     * Combines two numerical lambda expressions via multiplying.
     *
     * @param second the lambda expression that is not null.
     * @return the result after multiplication of these two expressions.
     */
    default Expression multiply(Expression second) {
        return x -> this.value(x) * second.value(x);
    }

    /**
     * Combines two numerical lambda expressions via dividing.
     *
     * @param denominator the lambda expression that is not null.
     * @return the result after division of these two expressions.
     */
    default Expression divide(Expression denominator) {
        return x -> this.value(x) / denominator.value(x);
    }
}
