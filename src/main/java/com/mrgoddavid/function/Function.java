package com.mrgoddavid.function;

import com.mrgoddavid.utils.Constants;

/**
 * Defines an one-variable function.
 *
 * @author Mr. GodDavid
 * @since 7/26/2026 part of Function Update.
 */
public class Function {

    private static final double UNDEFINED = Double.NaN;

    /**
     * Expression of the raw function.
     */
    private final Expression function;
    private final Limit limit;
    private final Derivative derivative;

    /**
     * Constructs a new function class by the given expression of this function.
     *
     * @param function expression of this function that is not null.
     */
    public Function(Expression function) {
        this.function = function;
        this.limit = new Limit(function);
        this.derivative = new Derivative(function);
    }

    public Function(Expression numerator, Expression denominator) {
        this.function = numerator.divide(denominator);
        this.limit = new Limit(function, numerator, denominator);
        this.derivative = new Derivative(function);
    }

    /**
     * Determines whether the function is continuous at given point. There are three requirements to say a function is
     * continuous at given x. The given x is defined on the function; the function has limit at given x; the limit
     * equals to the function's value.
     *
     * @param x given x.
     * @return true if the function meets all three requirements and false if it fails any of them.
     */
    public boolean continuousAt(double x) {
        if (!hasLimitAt(x)) {
            return false;
        }
        return Math.abs(x - limitAt(x)) < Constants.THRESHOLD;
    }

    /**
     * Calculates the first derivative of this function at x by calling {@link Derivative#first_derivativeAt(double)}.
     * If the function is not continuous at x, this method returns {@link Function#UNDEFINED}.
     *
     * @param x given x.
     * @return the result of {@link Derivative#first_derivativeAt(double)} or {@link Function#UNDEFINED} if the function
     * is not continuous at x.
     */
    public double first_derivativeAt(double x) {
        if (!continuousAt(x)) {
            return UNDEFINED;
        }
        return derivative.first_derivativeAt(x);
    }

    /**
     * Calculates the value of the function by the given x value.
     *
     * @param x given independent value of this function.
     * @return the output of the function.
     */
    public double value(double x) {
        return function.value(x);
    }

    /**
     * Calculates the limit of function at given x.
     *
     * @param x given x.
     * @return the result of {@link Limit#limitAt(double)}.
     */
    public double limitAt(double x) {
        return limit.limitAt(x);
    }

    public double leftLimitAt(double x) {
        return limit.leftLimitAt(x);
    }

    public double rightLimitAt(double x) {
        return limit.rightLimitAt(x);
    }

    /**
     * Determines the function has limit at the given x.
     *
     * @param x given x.
     * @return true if the function has limit at given x.
     */
    private boolean hasLimitAt(double x) {
        return limit.hasLimitAt(x);
    }

    /**
     * Determines whether the given x is in the domain of the function.
     *
     * @param x given x.
     * @return true if the given x is in the domain of the function.
     */
    public boolean inDomain(double x) {
        double result = function.value(x);
        return !Double.isNaN(result);
    }

    /**
     * Enables debug features.
     */
    public void debug() {
        this.limit.debug();
    }

    /**
     * Disables debug features.
     */
    public void endDebug() {
        this.limit.endDebug();
    }
}
