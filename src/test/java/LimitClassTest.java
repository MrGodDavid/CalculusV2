/**
 * Testing {@link com.mrgoddavid.function.Limit} class.
 *
 * @author Mr. GodDavid
 * @since 7/28/2026
 */

import com.mrgoddavid.function.Function;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Holds all test suites of {@link com.mrgoddavid.function.limit.Limit} class.
 *
 * @author Mr. GodDavid
 * @since 7/28/2026
 */
public final class LimitClassTest extends TestSuites.LimitClassTestSuites {

    @ParameterizedTest
    @MethodSource("normalLimitTestProvider")
    void finiteLimitTest(Function function, double x, double expected, double tolerance) {
        double result = function.limitAt(x);
        assertEquals(expected, result, tolerance);
    }

    @ParameterizedTest
    @MethodSource("zero_over_zeroLimitTestProvider")
    void zero_over_zeroLimitTest(Function function, double x, double expected, double tolerance) {
        double result = function.limitAt(x);
        assertEquals(expected, result, tolerance);
    }

    @ParameterizedTest
    @MethodSource("infiniteLimitTestProvider")
    void infiniteLimitTest(Function function, double x, double expected, double tolerance) {
        double result = function.limitAt(x);
        assertEquals(expected, result, tolerance);
    }

    @ParameterizedTest
    @MethodSource("limitAtInfinityTestProvider")
    void limitAtInfinityTest(Function function, double x, double expected, double tolerance) {
        double result = function.limitAt(x);
        assertEquals(expected, result, tolerance);
    }

    @ParameterizedTest
    @MethodSource("leftLimitTestProvider")
    void leftLimitTest(Function function, double x, double expected, double tolerance) {
        double result = function.leftLimitAt(x);
        assertEquals(expected, result, tolerance);
    }

    @ParameterizedTest
    @MethodSource("rightLimitTestProvider")
    void rightLimitTest(Function function, double x, double expected, double tolerance) {
        double result = function.rightLimitAt(x);
        assertEquals(expected, result, tolerance);
    }
}
