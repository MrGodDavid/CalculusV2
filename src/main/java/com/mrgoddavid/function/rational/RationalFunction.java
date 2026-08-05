package com.mrgoddavid.function.rational;

import com.mrgoddavid.function.Expression;
import com.mrgoddavid.function.Function;

/**
 * Defines a rational function. A rational function is a special type of function that is in the form of fraction. It
 * has numerator and denominator. There is no limiting type of what is in its numerator or denominator.
 *
 * @author Mr. GodDavid
 * @since 8/3/2026
 */
public final class RationalFunction extends Function {

    private final Expression numerator;
    private final Expression denominator;

    /**
     * Constructs a function with given numerator and denominator expression.
     *
     * @param numerator   the expression of the numerator of this function.
     * @param denominator the expression of the denominator of this function.
     */
    public RationalFunction(Expression numerator, Expression denominator) {
        super(numerator, denominator);
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Accessor of the expression of the denominator of this rational function.
     *
     * @return the expression of the denominator of this rational function.
     */
    public Expression getDenominator() {
        return denominator;
    }

    /**
     * Accessor of the expression of the numerator of this rational function.
     *
     * @return the expression of the numerator of this rational function.
     */
    public Expression getNumerator() {
        return numerator;
    }
}
