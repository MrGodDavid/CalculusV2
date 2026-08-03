package com.mrgoddavid.utils;

import com.mrgoddavid.format.exception.UnsupportedFactorialCalculationException;
import com.mrgoddavid.format.exception.UninstantiableClassInstantiationException;
import com.mrgoddavid.geometry.angle.Radian;

/**
 * Math.
 *
 * @author Mr. GodDavid
 * @since 7/29/2026
 */
public final class DavidMath {

    /**
     * Table of precalculated values of sine (angle).
     */
    private static final TRIG_ANGLE_PAIR[] SIN_RADIANS_VALUE_TABLE = new TRIG_ANGLE_PAIR[]{
            new TRIG_ANGLE_PAIR(Constants.ZERO, 0.00000000000000),
            new TRIG_ANGLE_PAIR(Constants.PI_OVER_SIXTEEN, 0.19509032201613),
            new TRIG_ANGLE_PAIR(Constants.TWO_PI_OVER_SIXTEEN, 0.38268343236509),
            new TRIG_ANGLE_PAIR(Constants.THREE_PI_OVER_SIXTEEN, 0.55557023301960),
            new TRIG_ANGLE_PAIR(Constants.FOUR_PI_OVER_SIXTEEN, 0.70710678118655),
            new TRIG_ANGLE_PAIR(Constants.FIVE_PI_OVER_SIXTEEN, 0.83146961230255),
            new TRIG_ANGLE_PAIR(Constants.SIX_PI_OVER_SIXTEEN, 0.92387953251129),
            new TRIG_ANGLE_PAIR(Constants.SEVEN_PI_OVER_SIXTEEN, 0.98078528040323),
            new TRIG_ANGLE_PAIR(Constants.PI_OVER_TWO, 1.00000000000000),
            new TRIG_ANGLE_PAIR(Constants.NINE_PI_OVER_SIXTEEN, 0.98078528040323),
            new TRIG_ANGLE_PAIR(Constants.TEN_PI_OVER_SIXTEEN, 0.92387953251129),
            new TRIG_ANGLE_PAIR(Constants.ELEVEN_PI_OVER_SIXTEEN, 0.83146961230255),
            new TRIG_ANGLE_PAIR(Constants.TWELVE_PI_OVER_SIXTEEN, 0.70710678118655),
            new TRIG_ANGLE_PAIR(Constants.THIRTEEN_PI_OVER_SIXTEEN, 0.55557023301960),
            new TRIG_ANGLE_PAIR(Constants.FOURTEEN_PI_OVER_SIXTEEN, 0.38268343236509),
            new TRIG_ANGLE_PAIR(Constants.FIFTEEN_PI_OVER_SIXTEEN, 0.19509032201613),
            new TRIG_ANGLE_PAIR(Constants.PI, 0.00000000000000),
            new TRIG_ANGLE_PAIR(Constants.SEVENTEEN_PI_OVER_SIXTEEN, -0.19509032201613),
            new TRIG_ANGLE_PAIR(Constants.EIGHTEEN_PI_OVER_SIXTEEN, -0.38268343236509),
            new TRIG_ANGLE_PAIR(Constants.NINETEEN_PI_OVER_SIXTEEN, -0.55557023301960),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_PI_OVER_SIXTEEN, -0.70710678118655),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_ONE_PI_OVER_SIXTEEN, -0.83146961230255),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_TWO_PI_OVER_SIXTEEN, -0.92387953251129),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_THREE_PI_OVER_SIXTEEN, -0.98078528040323),
            new TRIG_ANGLE_PAIR(Constants.THREE_PI_OVER_TWO, -1.00000000000000),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_FIVE_PI_OVER_SIXTEEN, -0.98078528040323),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_SIX_PI_OVER_SIXTEEN, -0.92387953251129),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_SEVEN_PI_OVER_SIXTEEN, -0.83146961230255),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_EIGHT_PI_OVER_SIXTEEN, -0.70710678118655),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_NINE_PI_OVER_SIXTEEN, -0.55557023301960),
            new TRIG_ANGLE_PAIR(Constants.THIRTY_PI_OVER_SIXTEEN, -0.38268343236509),
            new TRIG_ANGLE_PAIR(Constants.THIRTY_ONE_PI_OVER_SIXTEEN, -0.19509032201613),
            new TRIG_ANGLE_PAIR(Constants.TWO_PI, 0.00000000000000),
    };

    /**
     * Table of precalculated values of cosine (angle).
     */
    private static final TRIG_ANGLE_PAIR[] COS_RADIANS_VALUE_TABLE = new TRIG_ANGLE_PAIR[]{
            new TRIG_ANGLE_PAIR(Constants.ZERO, 1.00000000000000),
            new TRIG_ANGLE_PAIR(Constants.PI_OVER_SIXTEEN, 0.98078528040323),
            new TRIG_ANGLE_PAIR(Constants.TWO_PI_OVER_SIXTEEN, 0.92387953251129),
            new TRIG_ANGLE_PAIR(Constants.THREE_PI_OVER_SIXTEEN, 0.83146961230255),
            new TRIG_ANGLE_PAIR(Constants.FOUR_PI_OVER_SIXTEEN, 0.70710678118655),
            new TRIG_ANGLE_PAIR(Constants.FIVE_PI_OVER_SIXTEEN, 0.55557023301960),
            new TRIG_ANGLE_PAIR(Constants.SIX_PI_OVER_SIXTEEN, 0.38268343236509),
            new TRIG_ANGLE_PAIR(Constants.SEVEN_PI_OVER_SIXTEEN, 0.19509032201613),
            new TRIG_ANGLE_PAIR(Constants.PI_OVER_TWO, 0.00000000000000),
            new TRIG_ANGLE_PAIR(Constants.NINE_PI_OVER_SIXTEEN, -0.19509032201613),
            new TRIG_ANGLE_PAIR(Constants.TEN_PI_OVER_SIXTEEN, -0.38268343236509),
            new TRIG_ANGLE_PAIR(Constants.ELEVEN_PI_OVER_SIXTEEN, -0.55557023301960),
            new TRIG_ANGLE_PAIR(Constants.TWELVE_PI_OVER_SIXTEEN, -0.70710678118655),
            new TRIG_ANGLE_PAIR(Constants.THIRTEEN_PI_OVER_SIXTEEN, -0.83146961230255),
            new TRIG_ANGLE_PAIR(Constants.FOURTEEN_PI_OVER_SIXTEEN, -0.92387953251129),
            new TRIG_ANGLE_PAIR(Constants.FIFTEEN_PI_OVER_SIXTEEN, -0.98078528040323),
            new TRIG_ANGLE_PAIR(Constants.PI, -1.00000000000000),
            new TRIG_ANGLE_PAIR(Constants.SEVENTEEN_PI_OVER_SIXTEEN, -0.98078528040323),
            new TRIG_ANGLE_PAIR(Constants.EIGHTEEN_PI_OVER_SIXTEEN, -0.92387953251129),
            new TRIG_ANGLE_PAIR(Constants.NINETEEN_PI_OVER_SIXTEEN, -0.83146961230255),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_PI_OVER_SIXTEEN, -0.70710678118655),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_ONE_PI_OVER_SIXTEEN, -0.55557023301960),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_TWO_PI_OVER_SIXTEEN, -0.38268343236509),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_THREE_PI_OVER_SIXTEEN, -0.19509032201613),
            new TRIG_ANGLE_PAIR(Constants.THREE_PI_OVER_TWO, 0.00000000000000),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_FIVE_PI_OVER_SIXTEEN, 0.19509032201613),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_SIX_PI_OVER_SIXTEEN, 0.38268343236509),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_SEVEN_PI_OVER_SIXTEEN, 0.55557023301960),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_EIGHT_PI_OVER_SIXTEEN, 0.70710678118655),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_NINE_PI_OVER_SIXTEEN, 0.83146961230255),
            new TRIG_ANGLE_PAIR(Constants.THIRTY_PI_OVER_SIXTEEN, 0.92387953251129),
            new TRIG_ANGLE_PAIR(Constants.THIRTY_ONE_PI_OVER_SIXTEEN, 0.98078528040323),
            new TRIG_ANGLE_PAIR(Constants.TWO_PI, 1.00000000000000),
    };

    /**
     * Table of precalculated values of tangent (angle).
     */
    private static final TRIG_ANGLE_PAIR[] TAN_RADIANS_VALUE_TABLE = new TRIG_ANGLE_PAIR[]{
            new TRIG_ANGLE_PAIR(Constants.ZERO, 0.0),
            new TRIG_ANGLE_PAIR(Constants.PI_OVER_SIXTEEN, 0.19891236737965),
            new TRIG_ANGLE_PAIR(Constants.TWO_PI_OVER_SIXTEEN, 0.41421356237309),
            new TRIG_ANGLE_PAIR(Constants.THREE_PI_OVER_SIXTEEN, 0.66817863791929),
            new TRIG_ANGLE_PAIR(Constants.FOUR_PI_OVER_SIXTEEN, 1.0),
            new TRIG_ANGLE_PAIR(Constants.FIVE_PI_OVER_SIXTEEN, 1.49660576266548),
            new TRIG_ANGLE_PAIR(Constants.SIX_PI_OVER_SIXTEEN, 2.41421356237309),
            new TRIG_ANGLE_PAIR(Constants.SEVEN_PI_OVER_SIXTEEN, 5.02733949212584),
            new TRIG_ANGLE_PAIR(Constants.PI_OVER_TWO, Double.NaN),
            new TRIG_ANGLE_PAIR(Constants.NINE_PI_OVER_SIXTEEN, -5.02733949212584),
            new TRIG_ANGLE_PAIR(Constants.TEN_PI_OVER_SIXTEEN, -2.41421356237309),
            new TRIG_ANGLE_PAIR(Constants.ELEVEN_PI_OVER_SIXTEEN, -1.49660576266548),
            new TRIG_ANGLE_PAIR(Constants.TWELVE_PI_OVER_SIXTEEN, -1.0),
            new TRIG_ANGLE_PAIR(Constants.THIRTEEN_PI_OVER_SIXTEEN, -0.66817863791929),
            new TRIG_ANGLE_PAIR(Constants.FOURTEEN_PI_OVER_SIXTEEN, -0.41421356237309),
            new TRIG_ANGLE_PAIR(Constants.FIFTEEN_PI_OVER_SIXTEEN, -0.19891236737965),
            new TRIG_ANGLE_PAIR(Constants.PI, 0.0),
            new TRIG_ANGLE_PAIR(Constants.SEVENTEEN_PI_OVER_SIXTEEN, 0.19891236737965),
            new TRIG_ANGLE_PAIR(Constants.EIGHTEEN_PI_OVER_SIXTEEN, 0.41421356237309),
            new TRIG_ANGLE_PAIR(Constants.NINETEEN_PI_OVER_SIXTEEN, 0.66817863791929),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_PI_OVER_SIXTEEN, 1.0),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_ONE_PI_OVER_SIXTEEN, 1.49660576266548),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_TWO_PI_OVER_SIXTEEN, 2.41421356237309),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_THREE_PI_OVER_SIXTEEN, 5.02733949212584),
            new TRIG_ANGLE_PAIR(Constants.THREE_PI_OVER_TWO, Double.NaN),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_FIVE_PI_OVER_SIXTEEN, -5.02733949212584),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_SIX_PI_OVER_SIXTEEN, -2.41421356237309),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_SEVEN_PI_OVER_SIXTEEN, -1.49660576266548),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_EIGHT_PI_OVER_SIXTEEN, -1.0),
            new TRIG_ANGLE_PAIR(Constants.TWENTY_NINE_PI_OVER_SIXTEEN, -0.66817863791929),
            new TRIG_ANGLE_PAIR(Constants.THIRTY_PI_OVER_SIXTEEN, -0.41421356237309),
            new TRIG_ANGLE_PAIR(Constants.THIRTY_ONE_PI_OVER_SIXTEEN, -0.19891236737965),
            new TRIG_ANGLE_PAIR(Constants.PI, 0.0),
    };

    /**
     * Predefined factorial table.
     */
    private static final int[] FACTORIAL_TABLE = new int[]{
            1,              // 0!
            1,              // 1!
            2,              // 2!
            6,              // 3!
            24,             // 4!
            120,            // 5!
            720,            // 6!
            5040,           // 7!
            40320,          // 8!
            362880,         // 9!
            3628800,        // 10!
            39916800,       // 11!
            479001600,      // 12!
    };

    /**
     * Angle-value pair.
     *
     * @param angle in radians.
     * @param value after the trig operations.
     */
    private record TRIG_ANGLE_PAIR(Radian angle, double value) {
    }

    /**
     * Private constructor.
     *
     * @throws UninstantiableClassInstantiationException because user cannot instantiate this utility class.
     */
    private DavidMath() throws UninstantiableClassInstantiationException {
        throw new UninstantiableClassInstantiationException();
    }

    /**
     * Custom calculation of sin(angle) via defined sine table.
     *
     * @param angle in radians.
     * @return the value of sin(angle).
     */
    public static double sin(Radian angle) {
        for (TRIG_ANGLE_PAIR sinAnglePair : SIN_RADIANS_VALUE_TABLE) {
            if (angle.equals(sinAnglePair.angle)) {
                return sinAnglePair.value;
            }
        }
        return Math.sin(angle.val());
    }

    /**
     * Custom calculation of cos(angle) via defined cosine table.
     *
     * @param angle in radians.
     * @return the value of cos(angle).
     */
    public static double cos(Radian angle) {
        for (TRIG_ANGLE_PAIR cosAnglePair : COS_RADIANS_VALUE_TABLE) {
            if (angle.equals(cosAnglePair.angle)) {
                return cosAnglePair.value;
            }
        }
        return Math.cos(angle.val());
    }

    /**
     * Custom calculation of tan(angle) via defined tangent table.
     *
     * @param angle in radians.
     * @return the value of tan(angle).
     */
    public static double tan(Radian angle) {
        for (TRIG_ANGLE_PAIR tanAnglePair : TAN_RADIANS_VALUE_TABLE) {
            if (angle.equals(tanAnglePair.angle)) {
                return tanAnglePair.value;
            }
        }
        return Math.sin(angle.val()) / Math.cos(angle.val());
    }

    /**
     * Calculates the factorial of n.
     *
     * @param n n that is less than 13.
     * @return (n!).
     */
    public static int factorial(int n) {
        if (n >= 13) {
            throw new UnsupportedFactorialCalculationException(n);
        }
        return FACTORIAL_TABLE[n];
    }

    /**
     * Calculates the binormal coefficient (n, k).
     *
     * @param n n.
     * @param k k.
     * @return the result of the binormal coefficient (n, k).
     */
    public static int binomial(int n, int k) {
        return DavidMath.factorial(n) / (DavidMath.factorial(k) * DavidMath.factorial(n - k));
    }
}
