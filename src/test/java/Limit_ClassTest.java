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
 * Holds all test suites of {@link com.mrgoddavid.function.Limit} class.
 *
 * @author Mr. GodDavid
 * @since 7/28/2026
 */
public class Limit_ClassTest extends TestSuites.LimitClassTestSuites {

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
}
