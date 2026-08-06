package com.mrgoddavid.function;

import com.mrgoddavid.function.derivative.Derivative;
import com.mrgoddavid.function.limit.Limit;
import com.mrgoddavid.function.rational.RationalFunction;
import com.mrgoddavid.utils.DavidMath;

import java.util.Optional;

/**
 * Defines an one-variable function.
 *
 * @author Mr. GodDavid
 * @since 7/26/2026 part of Function Update.
 */
public class Function {

    /**
     * Undefined.
     */
    protected static final double UNDEFINED = Double.NaN;

    /**
     * Expression of the raw function.
     */
    private Expression expression;
    /**
     * Limit of the function.
     */
    private Limit limit;
    /**
     * Derivative of the function.
     */
    private Derivative derivative;

    private final Optional<String> representation;

    /**
     * Constructs a new function class by the given expression of this function.
     *
     * @param expression expression of this function that is not null.
     */
    public Function(Expression expression) {
        this.expression = expression;
        this.limit = new Limit(expression);
        this.derivative = new Derivative(expression);
        this.representation = Optional.empty();
    }

    /**
     * Constructs a function with given numerator and denominator expression.
     *
     * @param numerator   the expression of the numerator of this function.
     * @param denominator the expression of the denominator of this function.
     */
    public Function(Expression numerator, Expression denominator) {
        this.expression = numerator.divide(denominator);
        this.limit = new Limit(expression, numerator, denominator);
        this.derivative = new Derivative(expression);
        this.representation = Optional.empty();
    }

    /**
     * Constructs a new function class by the given expression of this function.
     *
     * @param expression     expression of this function that is not null.
     * @param representation the string representation for this function.
     */
    public Function(Expression expression, String representation) {
        this.expression = expression;
        this.limit = new Limit(expression);
        this.derivative = new Derivative(expression);
        this.representation = Optional.of(representation);
    }

    /**
     * Constructs a function with given numerator and denominator expression.
     *
     * @param numerator      the expression of the numerator of this function.
     * @param denominator    the expression of the denominator of this function.
     * @param representation the string representation for this function.
     */
    public Function(Expression numerator, Expression denominator, String representation) {
        this.expression = numerator.divide(denominator);
        this.limit = new Limit(expression, numerator, denominator);
        this.derivative = new Derivative(expression);
        this.representation = Optional.of(representation);
    }

    /**
     * Determines whether the function is continuous at given point. There are three requirements to say a function is
     * continuous at given x. The given x is defined on the function; the function has limit at given x; the limit
     * equals to the function's value.
     *
     * @param x given x.
     * @return true if the function meets all three requirements and false if it fails any of them.
     */
    public final boolean continuousAt(double x) {
        if (!hasLimitAt(x)) {
            return false;
        }
        return DavidMath.strict_compare(this.value(x), this.limitAt(x));
    }

    /**
     * Calculates the first derivative of this function at x by calling {@link Derivative#first_derivativeAt(double)}.
     * If the function is not continuous at x, this method returns {@link Function#UNDEFINED}.
     *
     * @param x given x.
     * @return the result of {@link Derivative#first_derivativeAt(double)} or {@link Function#UNDEFINED} if the function
     * is not continuous at x.
     */
    public final double first_derivativeAt(double x) {
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
    public final double value(double x) {
        return expression.value(x);
    }

    /**
     * Calculates the limit of function at given x.
     *
     * @param x given x.
     * @return the result of {@link Limit#limitAt(double)}.
     */
    public final double limitAt(double x) {
        return limit.limitAt(x);
    }

    /**
     * Calculates the value of left-side limit of this function.
     *
     * @param x where to find the limit.
     * @return the left-side limit of function at x.
     */
    public final double leftLimitAt(double x) {
        return limit.leftLimitAt(x);
    }

    /**
     * Calculates the value of right-side limit of this function.
     *
     * @param x where to find the limit.
     * @return the right-side limit of function at x.
     */
    public final double rightLimitAt(double x) {
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
    public final boolean inDomain(double x) {
        double result = expression.value(x);
        return !Double.isNaN(result);
    }

    /**
     * Enables debug features.
     */
    public final void debug() {
        this.limit.debug();
    }

    /**
     * Disables debug features.
     */
    public final void endDebug() {
        this.limit.endDebug();
    }

    /**
     * Accessor of the expression of this function.
     *
     * @return the expression of this function.
     */
    public final Expression getExpression() {
        return expression;
    }

    /**
     * Mutator of the expression of this function.
     *
     * @param expression the new non-null expression of this function
     */
    public final void updateExpression(Function expression) {
        this.expression = expression.getExpression();
        if (expression instanceof RationalFunction rationalFunction) {
            this.limit = new Limit(this.expression, rationalFunction.getNumerator(), rationalFunction.getDenominator());
            this.derivative = new Derivative(this.expression);
            return;
        }
        this.limit = new Limit(this.expression);
        this.derivative = new Derivative(this.expression);
    }

    /**
     * Accessor of the instance field {@code limit}.
     *
     * @return the instance of {@code Limit}.
     */
    public final Limit getLimit() {
        return limit;
    }

    /**
     * Accessor of the instance field {@code derivative}.
     *
     * @return the instance of {@code Derivative}.
     */
    public final Derivative getDerivative() {
        return derivative;
    }

    @Override
    public String toString() {
        return "Function = {" + this.representation.orElse("User didn't input representation") + "}";
    }
}
