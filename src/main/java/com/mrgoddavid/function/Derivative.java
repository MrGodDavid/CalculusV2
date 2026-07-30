package com.mrgoddavid.function;

import com.mrgoddavid.utils.DavidMath;

/**
 * This class defines the derivative of {@link Function} class. Imagine {@link Function} is a smooth, continuous curve.
 * The derivative at a point {@code x} is the slope of the tangent line that passes that {@code x}.
 * <p>There are many ways to calculate the derivative of f(x) at given x. As you may have learned, there are many
 * derivative formulas. Unfortunately, in the world of Computer Science, we cannot directly use these formulas.
 * Computers are not smart enough to convert these complex formulas to code. Luckily, we can use the formal {@code
 * definition of derivative} to calculate derivatives.</p>
 * <p>The {@code definition of derivative} is defined as following, </p>
 * <pre>
 *               /  f'(x + h) - f'(x)   \
 * f'(x) = lim   | -------------------- |
 *        h -> 0 \          h           /
 * </pre>
 * We cannot directly substitute 0 to h because this would "explode" our computers. We can substitute very small value
 * of number to h to approximate the derivatives.
 *
 * @author Mr. GodDavid
 * @since 7/30/2026 Limit & Function Update part 2.
 */
final class Derivative {

    private static final double H = 1E-8;

    private final Expression function;

    /**
     * Constructs the derivative class for functions.
     *
     * @param function the expression of functions.
     */
    public Derivative(Expression function) {
        this.function = function;
    }

    public double first_derivativeAt(double x) {
        return general_forward_derivative(x, 1);
    }

    public double second_derivativeAt(double x) {
        return general_forward_derivative(x, 2);
    }

    private double general_forward_derivative(double x, int n) {
        double scale = 1.0 / Math.pow(H, n);
        double value = 0.0;
        for (int k = 0; k <= n; k++) {
            value += Math.pow(-1, n - k)
                    * DavidMath.binomial(n, k)
                    * function.value(x + k * H);
        }
        return scale * value;
    }

    public static double general_forward_derivative(Expression function, double x, int n) {
        double scale = 1.0 / Math.pow(H, n);
        double value = 0.0;
        for (int k = 0; k <= n; k++) {
            value += Math.pow(-1, n - k)
                    * DavidMath.binomial(n, k)
                    * function.value(x + k * H);
        }
        return scale * value;
    }
}
