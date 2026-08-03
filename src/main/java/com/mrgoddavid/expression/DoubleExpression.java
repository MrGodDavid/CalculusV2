package com.mrgoddavid.expression;

/**
 * This interface holds only one method, which defines how value is calculated.
 *
 * @author Mr. GodDavid
 * @since 7/24/2026 part of Transformations &amp; Circles Update.
 */
@FunctionalInterface
public interface DoubleExpression {

    /**
     * Defines how {@code n} is calculated.
     *
     * @param n input number must be a double.
     * @return the calculated {@code n} based on the defined expression.
     */
    double calculate(double n);
}
