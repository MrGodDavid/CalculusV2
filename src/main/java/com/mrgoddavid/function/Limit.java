package com.mrgoddavid.function;

import com.mrgoddavid.utils.ArrayUtils;

import java.util.Arrays;

import static com.mrgoddavid.utils.Constants.THRESHOLD;

/**
 * Calculates the limit of a one-variable function at x. Normally, the limit of the function equals the output of the
 * function at that x. We say the function is continuous at that x. Conversely, there are some places that the function
 * is not continuous, or discontinuous. That happens because the limit of the function does not exist or does not equal
 * to the value of the function.
 * <p>This class tries to find the limit of the function at x, if possible. Utilizing various method of finding the
 * limit.</p>
 *
 * @author Mr. GodDavid
 * @since 7/26/2026 part of Function Update.
 */
final class Limit {

    private static final double[] H_TABLE = new double[]{
            0.1,                                 // 10E-1
            0.01,                                // 10E-2
            0.001,                               // 10E-3
            0.0001,                              // 10E-4
            0.00001,                             // 10E-5
            0.000001,                            // 10E-6
            0.0000001,                           // 10E-7
            0.00000001,                          // 10E-8
            0.000000001,                         // 10E-9
            0.0000000001,                        // 10E-10
            0.00000000001,                       // 10E-11
            0.000000000001,                      // 10E-12
            0.0000000000001,                     // 10E-13
            0.00000000000001,                    // 10E-14
    };

    private static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    private static final double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    private static final double DOES_NOT_EXIST = Double.NaN;

    private final Expression function;
    private boolean debug;

    public Limit(Expression function) {
        this.function = function;
        this.debug = false;
    }

    private Expression numerator, denominator;

    public Limit(Expression function, Expression numerator, Expression denominator) {
        this.function = function;
        this.debug = false;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * The first step of finding a limit of a function at {@code x} is directly substituting the {@code x} into the
     * function expression. If the direct substitution results NaN or something else, we need to use more advanced
     * algorithm to figure out the limit.
     *
     * @param x defines where to find the limit on the function.
     * @return the limit of the function at {@code x}.
     */
    public double limitAt(double x) {
        double result = function.value(x);
        if (Double.isFinite(result)) {
            return result;
        } else {
            return approachesAt(x);
        }
    }

    /**
     * Determines whether the limit exists or not.
     *
     * @param x given x.
     * @return true if the limit exists.
     */
    public boolean hasLimitAt(double x) {
        return !Double.isNaN(limitAt(x));
    }

    private double approachesAt(double x) {
        double[] leftTable = generateLeftTable(x);
        double[] rightTable = generateRightTable(x);
        if (debug) {
            System.out.println("Left table: " + Arrays.toString(leftTable));
            System.out.println("Right table: " + Arrays.toString((rightTable)));
        }

        // Determines whether the left limit approaches to positive infinity and whether the right limit approaches positive infinity.
        boolean leftTableToPositiveInfinity = tableApproachesPositiveInfinite(leftTable) || tableApproachesPositiveInfinite(ArrayUtils.reverse(leftTable));
        boolean rightTableToPositiveInfinity = tableApproachesPositiveInfinite(rightTable) || tableApproachesPositiveInfinite(ArrayUtils.reverse(rightTable));
        if (debug) {
            System.out.println("Left table to positive infinity: " + leftTableToPositiveInfinity);
            System.out.println("Right table to positive infinity: " + (rightTableToPositiveInfinity));
        }

        // Determines whether the left limit approaches to negative infinity and whether the right limit approaches negative infinity.
        boolean leftTableToNegativeInfinity = tableApproachesNegativeInfinity(leftTable) || tableApproachesNegativeInfinity(ArrayUtils.reverse(leftTable));
        boolean rightTableToNegativeInfinity = tableApproachesNegativeInfinity(rightTable) || tableApproachesNegativeInfinity(ArrayUtils.reverse(rightTable));
        if (debug) {
            System.out.println("Left table to negative infinity: " + leftTableToNegativeInfinity);
            System.out.println("Right table to negative infinity: " + rightTableToNegativeInfinity);
        }

        // If both the left limit and right limit approaches to positive infinity, the limit is positive infinity.
        if (leftTableToPositiveInfinity && rightTableToPositiveInfinity) {
            return POSITIVE_INFINITY;
        }
        // If both the left limit and right limit approaches to negative infinity, the limit is negative infinity.
        else if (leftTableToNegativeInfinity && rightTableToNegativeInfinity) {
            return NEGATIVE_INFINITY;
        }
        // If the left limit approaches to positive infinity, and right limit approaches to negative infinity, and the left limit
        // approaches to negative infinity, and right limit approaches to positive infinity, the limit is DOES_NOT_EXIST.
        else if (
                (leftTableToPositiveInfinity && rightTableToNegativeInfinity)
                        || (leftTableToNegativeInfinity && rightTableToPositiveInfinity)
        ) {
            return DOES_NOT_EXIST;
        }
        // If the left limit approaches to a finite number, and the right limit also approaches to a finite number
        else {
            double leftNumber = leftTable[0];
            double rightNumber = rightTable[0];
            double difference = Math.abs(leftNumber - rightNumber);

            // If the difference between the number that the left limit approaches to and the number that right the limit approaches to
            // passes the threshold test, which means the difference is within a very small number, the limit is approximately the
            // average of the number that the left limit approaches and the number that the right limit approaches.
            if (difference < THRESHOLD) {
                return (leftNumber + rightNumber) / 2.0;
            }
            // If the limit fails the threshold test, we then say that the limit does not exist.
            else {
                return LHopitals_Rule(x);
            }
        }
    }

    /**
     * Utilizes LHopital's Rule to calculate the limit of the function at x under the form 0/0 after direct
     * substitution.
     *
     * @param x given x.
     * @return the value of the helper method {@link Limit#doLHopitals_Rule(double, int)}.
     */
    private double LHopitals_Rule(double x) {
        return doLHopitals_Rule(x, 1);
    }

    /**
     * Helper method of {@link Limit#LHopitals_Rule(double)}. This method recursively tries LHopital's Rule until the
     * degree of derivative exceeds 13. For each degree of derivative calculation, this method calls
     * {@link Derivative#general_forward_derivative(Expression, double, int)}.
     *
     * @param x                  the given x.
     * @param degreeOfDerivative the degree of derivative of the numerator and the denominator of the expression of the
     *                           function.
     * @return either a value calculated by this method or {@link Limit#DOES_NOT_EXIST}.
     */
    private double doLHopitals_Rule(double x, int degreeOfDerivative) {
        if (degreeOfDerivative >= 13) {
            if (debug) {
                System.err.println("[WARNING] Cannot do LHoptals_Rule at " + x);
            }
            return DOES_NOT_EXIST;
        }
        double numerator = Derivative.general_forward_derivative(this.numerator, x, 1);
        double denominator = Derivative.general_forward_derivative(this.denominator, x, 1);
        if (debug) {
            System.out.println("LHopitals_Rule: " + numerator + " / " + denominator);
        }
        if (Math.abs(numerator) < THRESHOLD && Math.abs(denominator) < THRESHOLD) {
            return doLHopitals_Rule(x, degreeOfDerivative + 1);
        }
        return numerator / denominator;
    }

    /**
     * Checks if the table approaches to negative infinity.
     *
     * @param table given table of values that is not null/empty.
     * @return true of the values approaches to negative infinity.
     */
    private boolean tableApproachesNegativeInfinity(double[] table) {
        double prev = Double.MAX_VALUE;
        for (int i = 1; i < table.length; i++) {
            double decrease = table[i] - table[i - 1];
            if (decrease > prev) {
                return false;
            }
            prev = decrease;
        }
        return true;
    }

    /**
     * Checks if the table approaches to positive infinity.
     *
     * @param table given table of values that is not null/empty.
     * @return true of the values approaches to positive infinity.
     */
    private boolean tableApproachesPositiveInfinite(double[] table) {
        double prev = Double.MIN_VALUE;
        for (int i = 1; i < H_TABLE.length; i++) {
            double increase = table[i] - table[i - 1];
            if (increase < prev) {
                return false;
            }
            prev = increase;
        }
        return true;
    }

    /**
     * Generate a table of function's values when inputs are the difference of x and each value of
     * {@link Limit#H_TABLE}.
     *
     * @param x given x.
     * @return the table of values that approaches to the limit of the function from left side of x.
     */
    private double[] generateLeftTable(double x) {
        double[] leftTable = new double[H_TABLE.length];
        for (int i = 0; i < H_TABLE.length; i++) {
            leftTable[i] = function.value(x - H_TABLE[i]);
        }
        return leftTable;
    }

    /**
     * Generate a table of function's values when inputs are the sum of x and each value of {@link Limit#H_TABLE}.
     *
     * @param x given x.
     * @return the table of values that approaches to the limit of the function from right side of x.
     */
    private double[] generateRightTable(double x) {
        double[] rightTable = new double[H_TABLE.length];
        for (int i = 0; i < H_TABLE.length; i++) {
            rightTable[i] = function.value(x + H_TABLE[i]);
        }
        return rightTable;
    }

    /**
     * Enables debug features.
     */
    void debug() {
        this.debug = true;
    }

    /**
     * Disables debug features.
     */
    void endDebug() {
        this.debug = false;
    }
}
