package com.mrgoddavid.utils;

import com.mrgoddavid.format.exception.UninstantiableClassInstantiationException;
import com.mrgoddavid.geometry.angle.Radian;

/**
 * Holds mathematics constants.
 *
 * @author Mr. GodDavid
 * @since 7/19/2026
 */
public final class Constants {

    /**
     * The tolerance of the difference between left and right value of limit.
     */
    public static final double THRESHOLD = 1E-2;

    /**
     * Threshold of the float-point comparison of two numbers. Use this in Test classes.
     */
    public static final double EPSILON = 1E-3;

    /**
     * 14 decimal places of the square root of 2.
     */
    public static final double SQRT_2 = 1.41421356237310;

    /**
     * 14 decimal places of the square root of 3.
     */
    public static final double SQRT_3 = 1.73205080756888;

    /**
     * ================================
     * PI family, yippee!!!
     * ================================
     */
    public static final Radian ZERO = new Radian(0.00000000000000);
    public static final Radian PI_OVER_SIXTEEN = new Radian(0.19634954084936);
    public static final Radian PI_OVER_EIGHT = new Radian(0.39269908169872);
    public static final Radian TWO_PI_OVER_SIXTEEN = new Radian(PI_OVER_EIGHT.val());
    public static final Radian THREE_PI_OVER_SIXTEEN = new Radian(0.58904862254809);
    public static final Radian PI_OVER_FOUR = new Radian(0.78539816339745);
    public static final Radian FOUR_PI_OVER_SIXTEEN = new Radian(PI_OVER_FOUR.val());
    public static final Radian FIVE_PI_OVER_SIXTEEN = new Radian(0.98174770424681);
    public static final Radian THREE_PI_OVER_EIGHT = new Radian(1.17809724509617);
    public static final Radian SIX_PI_OVER_SIXTEEN = new Radian(THREE_PI_OVER_EIGHT.val());
    public static final Radian SEVEN_PI_OVER_SIXTEEN = new Radian(1.37444678594553);
    public static final Radian PI_OVER_TWO = new Radian(1.57079632679490);
    public static final Radian EIGHT_PI_OVER_SIXTEEN = new Radian(PI_OVER_TWO.val());
    public static final Radian NINE_PI_OVER_SIXTEEN = new Radian(1.76714586764426);
    public static final Radian FIVE_PI_OVER_EIGHT = new Radian(1.96349540849362);
    public static final Radian TEN_PI_OVER_SIXTEEN = new Radian(FIVE_PI_OVER_EIGHT.val());
    public static final Radian ELEVEN_PI_OVER_SIXTEEN = new Radian(2.15984494934298);
    public static final Radian THREE_PI_OVER_FOUR = new Radian(2.35619449019234);
    public static final Radian TWELVE_PI_OVER_SIXTEEN = new Radian(THREE_PI_OVER_FOUR.val());
    public static final Radian THIRTEEN_PI_OVER_SIXTEEN = new Radian(2.55254403104171);
    public static final Radian SEVEN_PI_OVER_EIGHT = new Radian(2.74889357189107);
    public static final Radian FOURTEEN_PI_OVER_SIXTEEN = new Radian(SEVEN_PI_OVER_EIGHT.val());
    public static final Radian FIFTEEN_PI_OVER_SIXTEEN = new Radian(2.94524311274043);
    public static final Radian PI = new Radian(3.14159265358979);
    public static final Radian SIXTEEN_PI_OVER_SIXTEEN = new Radian(PI.val());
    public static final Radian SEVENTEEN_PI_OVER_SIXTEEN = new Radian(3.33794219443916);
    public static final Radian NINE_PI_OVER_EIGHT = new Radian(3.53429173528852);
    public static final Radian EIGHTEEN_PI_OVER_SIXTEEN = new Radian(NINE_PI_OVER_EIGHT.val());
    public static final Radian NINETEEN_PI_OVER_SIXTEEN = new Radian(3.73064127613788);
    public static final Radian FIVE_PI_OVER_FOUR = new Radian(3.92699081698724);
    public static final Radian TWENTY_PI_OVER_SIXTEEN = new Radian(FIVE_PI_OVER_FOUR.val());
    public static final Radian TWENTY_ONE_PI_OVER_SIXTEEN = new Radian(4.12334035783660);
    public static final Radian ELEVEN_PI_OVER_EIGHT = new Radian(4.31968989868597);
    public static final Radian TWENTY_TWO_PI_OVER_SIXTEEN = new Radian(ELEVEN_PI_OVER_EIGHT.val());
    public static final Radian TWENTY_THREE_PI_OVER_SIXTEEN = new Radian(4.51603943953533);
    public static final Radian THREE_PI_OVER_TWO = new Radian(4.71238898038469);
    public static final Radian TWENTY_FOUR_PI_OVER_SIXTEEN = new Radian(THREE_PI_OVER_TWO.val());
    public static final Radian TWENTY_FIVE_PI_OVER_SIXTEEN = new Radian(4.90873852123405);
    public static final Radian THIRTEEN_PI_OVER_EIGHT = new Radian(5.10508806208341);
    public static final Radian TWENTY_SIX_PI_OVER_SIXTEEN = new Radian(THIRTEEN_PI_OVER_EIGHT.val());
    public static final Radian TWENTY_SEVEN_PI_OVER_SIXTEEN = new Radian(5.30143760293278);
    public static final Radian SEVEN_PI_OVER_FOUR = new Radian(5.49778714378214);
    public static final Radian TWENTY_EIGHT_PI_OVER_SIXTEEN = new Radian(SEVEN_PI_OVER_FOUR.val());
    public static final Radian TWENTY_NINE_PI_OVER_SIXTEEN = new Radian(5.69413668463150);
    public static final Radian FIFTEEN_PI_OVER_EIGHT = new Radian(5.89048622548086);
    public static final Radian THIRTY_PI_OVER_SIXTEEN = new Radian(FIFTEEN_PI_OVER_EIGHT.val());
    public static final Radian THIRTY_ONE_PI_OVER_SIXTEEN = new Radian(6.08683576633022);
    public static final Radian TWO_PI = new Radian(6.28318530717959);
    public static final Radian THIRTY_TWO_PI_OVER_SIXTEEN = new Radian(TWO_PI.val());

    /**
     * e.
     */
    public static final double E = 2.718281828459045;

    /**
     * Private constructor.
     *
     * @throws IllegalAccessException because user cannot instantiate this class.
     */
    private Constants() throws IllegalAccessException {
        throw new UninstantiableClassInstantiationException();
    }
}
