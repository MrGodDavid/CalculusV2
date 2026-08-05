import com.mrgoddavid.function.Function;
import com.mrgoddavid.function.rational.RationalFunction;
import com.mrgoddavid.geometry.angle.Radian;
import com.mrgoddavid.utils.Constants;
import com.mrgoddavid.utils.DavidMath;
import com.mrgoddavid.vector.immutable.ImmutableVector3d;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.mrgoddavid.utils.Constants.*;

/**
 * This is the root class of all test suites of this library.
 *
 * @author Mr. GodDavid
 * @since 7/20/2026
 */
public class TestSuites {

    protected static final double EPSILON = Constants.EPSILON;

    /**
     * Test suites for {@link ImmutableVector3d} class.
     *
     * @author Mr. GodDavid
     * @since 7/28/2026
     */
    static class Vector3dTestSuites extends TestSuites {

        static Stream<Arguments> vector3dAdditionProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(1.0, 1.0, 0.0), new ImmutableVector3d(1.0, 0.0, 1.0), new ImmutableVector3d(2.0, 1.0, 1.0)),
                    Arguments.of(new ImmutableVector3d(2.0, -1.0, 0.0), new ImmutableVector3d(1.0, 0.0, 1.0), new ImmutableVector3d(3.0, -1.0, 1.0)),
                    Arguments.of(new ImmutableVector3d(1.0, 2.0, -3.0), new ImmutableVector3d(-1.0, 0.0, -1.0), new ImmutableVector3d(0.0, 2.0, -4.0)),
                    Arguments.of(new ImmutableVector3d(1.0, -10.0, -111.0), new ImmutableVector3d(99.0, -90.0, 111.0), new ImmutableVector3d(100.0, -100.0, 0.0)),
                    Arguments.of(new ImmutableVector3d(-100.0, 101.0, 100.0), new ImmutableVector3d(100.0, -101.0, -100.0), new ImmutableVector3d())
            );
        }

        static Stream<Arguments> vector3dSubtractionProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(3.7, -2.5, 8.4), new ImmutableVector3d(1.2, 4.8, -0.9), new ImmutableVector3d(2.5, -7.3, 9.3)),
                    Arguments.of(new ImmutableVector3d(-6.8, 7.1, 3.6), new ImmutableVector3d(4.5, -2.9, 5.2), new ImmutableVector3d(-11.3, 10.0, -1.6)),
                    Arguments.of(new ImmutableVector3d(10.5, 0.4, -7.8), new ImmutableVector3d(-3.6, 8.2, -4.1), new ImmutableVector3d(14.1, -7.8, -3.7)),
                    Arguments.of(new ImmutableVector3d(2.9, -5.6, 9.3), new ImmutableVector3d(-7.4, -3.2, 4.8), new ImmutableVector3d(10.3, -2.4, 4.5)),
                    Arguments.of(new ImmutableVector3d(4.8, -1.5, 6.7), new ImmutableVector3d(-2.3, 5.6, 1.4), new ImmutableVector3d(7.1, -7.1, 5.3))
            );
        }

        static Stream<Arguments> vector3dEntrywiseMultiplicationProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(2.5, -3.2, 4.0), new ImmutableVector3d(1.6, 5.0, -2.5), new ImmutableVector3d(4.0, -16.0, -10.0)),
                    Arguments.of(new ImmutableVector3d(3.0, -1.2, 0.5), new ImmutableVector3d(-6.4, 2.5, 7.8), new ImmutableVector3d(-19.2, -3.0, 3.9)),
                    Arguments.of(new ImmutableVector3d(-2.0, 6.4, -3.2), new ImmutableVector3d(8.2, -4.5, 1.5), new ImmutableVector3d(-16.4, -28.8, -4.8)),
                    Arguments.of(new ImmutableVector3d(-1.8, 9.5, -6.2), new ImmutableVector3d(4.5, -0.8, -1.5), new ImmutableVector3d(-8.1, -7.6, 9.3)),
                    Arguments.of(new ImmutableVector3d(12.5, -3.6, 0.8), new ImmutableVector3d(0.4, 2.5, -7.5), new ImmutableVector3d(5.0, -9.0, -6.0))
            );
        }

        static Stream<Arguments> vector3dEntrywiseDivisionProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(12.6, -18.0, 9.6), new ImmutableVector3d(4.2, 6.0, -3.2), new ImmutableVector3d(3.0, -3.0, -3.0)),
                    Arguments.of(new ImmutableVector3d(-22.5, 14.4, -8.1), new ImmutableVector3d(4.5, -3.6, 2.7), new ImmutableVector3d(-5.0, -4.0, -3.0)),
                    Arguments.of(new ImmutableVector3d(15.75, -21.6, 18.9), new ImmutableVector3d(5.25, -7.2, 6.3), new ImmutableVector3d(3.0, 3.0, 3.0)),
                    Arguments.of(new ImmutableVector3d(-19.2, 24.5, -30.8), new ImmutableVector3d(6.4, -4.9, -7.7), new ImmutableVector3d(-3.0, -5.0, 4.0)),
                    Arguments.of(new ImmutableVector3d(31.5, -16.8, 27.3), new ImmutableVector3d(10.5, -5.6, 9.1), new ImmutableVector3d(3.0, 3.0, 3.0))
            );
        }

        static Stream<Arguments> vector3dMultiplyAddProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(2.5, -3.0, 4.0), new ImmutableVector3d(1.6, 5.0, -2.5), new ImmutableVector3d(1.0, 2.0, 3.0), new ImmutableVector3d(5.0, -13.0, -7.0)),
                    Arguments.of(new ImmutableVector3d(-6.4, 2.5, 7.8), new ImmutableVector3d(3.0, -1.2, 0.5), new ImmutableVector3d(4.0, -2.0, 1.5), new ImmutableVector3d(-15.2, -5.0, 5.4)),
                    Arguments.of(new ImmutableVector3d(8.2, -4.5, 1.5), new ImmutableVector3d(-2.0, 6.4, -3.2), new ImmutableVector3d(5.0, 1.0, -4.0), new ImmutableVector3d(-11.4, -27.8, -8.8)),
                    Arguments.of(new ImmutableVector3d(-1.8, 9.5, -6.2), new ImmutableVector3d(4.5, -0.8, -1.5), new ImmutableVector3d(2.0, 3.0, 4.0), new ImmutableVector3d(-6.1, -4.6, 13.3)),
                    Arguments.of(new ImmutableVector3d(12.5, -3.6, 0.8), new ImmutableVector3d(0.4, 2.5, -7.5), new ImmutableVector3d(-1.0, 6.0, 2.5), new ImmutableVector3d(4.0, -3.0, -3.5))
            );
        }

        static Stream<Arguments> vector3dDotProductProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(1.0, 2.0, 3.0), new ImmutableVector3d(4.0, 5.0, 6.0), 32.0),
                    Arguments.of(new ImmutableVector3d(2.5, -1.0, 4.0), new ImmutableVector3d(-3.0, 2.0, 1.5), -3.5),
                    Arguments.of(new ImmutableVector3d(0.0, 3.0, -2.0), new ImmutableVector3d(5.0, -1.0, 4.0), -11.0),
                    Arguments.of(new ImmutableVector3d(-2.0, 4.5, 1.0), new ImmutableVector3d(3.5, -2.0, 6.0), -10.0),
                    Arguments.of(new ImmutableVector3d(7.2, -3.6, 1.8), new ImmutableVector3d(-1.5, 4.0, 2.5), -20.7)
            );
        }

        static Stream<Arguments> vector3dCrossProductProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(1.0, 2.0, 3.0), new ImmutableVector3d(4.0, 5.0, 6.0), new ImmutableVector3d(-3.0, 6.0, -3.0)),
                    Arguments.of(new ImmutableVector3d(2.5, -1.0, 4.0), new ImmutableVector3d(-3.0, 2.0, 1.5), new ImmutableVector3d(-9.5, -15.75, 2.0)),
                    Arguments.of(new ImmutableVector3d(0.0, 3.0, -2.0), new ImmutableVector3d(5.0, -1.0, 4.0), new ImmutableVector3d(10.0, -10.0, -15.0)),
                    Arguments.of(new ImmutableVector3d(-2.0, 4.5, 1.0), new ImmutableVector3d(3.5, -2.0, 6.0), new ImmutableVector3d(29.0, 15.5, -11.75)),
                    Arguments.of(new ImmutableVector3d(7.2, -3.6, 1.8), new ImmutableVector3d(-1.5, 4.0, 2.5), new ImmutableVector3d(-16.2, -20.7, 23.4))
            );
        }

        static Stream<Arguments> vector3dDistanceProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(1.0, 2.0, 3.0), new ImmutableVector3d(4.0, 6.0, 3.0), 5.0),
                    Arguments.of(new ImmutableVector3d(-2.5, 1.0, 4.5), new ImmutableVector3d(0.5, -3.0, 1.5), Math.sqrt(34.0)),
                    Arguments.of(new ImmutableVector3d(7.2, -1.8, 5.4), new ImmutableVector3d(7.2, -1.8, 5.4), 0.0),
                    Arguments.of(new ImmutableVector3d(3.5, -2.5, 1.0), new ImmutableVector3d(-0.5, 1.5, -2.0), Math.sqrt(41.0)),
                    Arguments.of(new ImmutableVector3d(-4.2, 8.1, -6.3), new ImmutableVector3d(1.8, 0.1, -0.3), Math.sqrt(136.0))
            );
        }

        static Stream<Arguments> vector3dLengthProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(3.0, 4.0, 0.0), 5.0),
                    Arguments.of(new ImmutableVector3d(1.0, 2.0, 2.0), 3.0),
                    Arguments.of(new ImmutableVector3d(-6.0, 8.0, 0.0), 10.0),
                    Arguments.of(new ImmutableVector3d(0.0, 0.0, 0.0), 0.0),
                    Arguments.of(new ImmutableVector3d(2.0, 3.0, 6.0), 7.0)
            );
        }

        static Stream<Arguments> vector3dScaleProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(1.0, 2.0, 3.0), 2.0, new ImmutableVector3d(2.0, 4.0, 6.0)),
                    Arguments.of(new ImmutableVector3d(-4.0, 5.0, -6.0), -0.5, new ImmutableVector3d(2.0, -2.5, 3.0)),
                    Arguments.of(new ImmutableVector3d(2.5, -1.5, 4.0), 3.0, new ImmutableVector3d(7.5, -4.5, 12.0)),
                    Arguments.of(new ImmutableVector3d(8.0, 1.0, -2.0), 0.0, new ImmutableVector3d(0.0, 0.0, 0.0)),
                    Arguments.of(new ImmutableVector3d(-3.2, 6.4, 1.6), 0.5, new ImmutableVector3d(-1.6, 3.2, 0.8))
            );
        }

        static Stream<Arguments> vector3dNormalizeProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(3.0, 4.0, 0.0), new ImmutableVector3d(0.6, 0.8, 0.0)),
                    Arguments.of(new ImmutableVector3d(1.0, 2.0, 2.0), new ImmutableVector3d(1.0 / 3.0, 2.0 / 3.0, 2.0 / 3.0)),
                    Arguments.of(new ImmutableVector3d(-6.0, 8.0, 0.0), new ImmutableVector3d(-0.6, 0.8, 0.0)),
                    Arguments.of(new ImmutableVector3d(0.0, 5.0, 0.0), new ImmutableVector3d(0.0, 1.0, 0.0)),
                    Arguments.of(new ImmutableVector3d(0.0, 0.0, -2.0), new ImmutableVector3d(0.0, 0.0, -1.0))
            );
        }

        static Stream<Arguments> vector3dAbsoluteProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(-1.5, 2.0, -3.4), new ImmutableVector3d(1.5, 2.0, 3.4)),
                    Arguments.of(new ImmutableVector3d(0.0, -5.2, 4.8), new ImmutableVector3d(0.0, 5.2, 4.8)),
                    Arguments.of(new ImmutableVector3d(-7.0, -8.0, -9.0), new ImmutableVector3d(7.0, 8.0, 9.0)),
                    Arguments.of(new ImmutableVector3d(3.1, 4.2, 5.3), new ImmutableVector3d(3.1, 4.2, 5.3)),
                    Arguments.of(new ImmutableVector3d(-0.1, 0.2, -0.3), new ImmutableVector3d(0.1, 0.2, 0.3))
            );
        }

        static Stream<Arguments> vector3dPowerProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(2.0, 3.0, 4.0), 2.0, new ImmutableVector3d(4.0, 9.0, 16.0)),
                    Arguments.of(new ImmutableVector3d(9.0, 16.0, 25.0), 0.5, new ImmutableVector3d(3.0, 4.0, 5.0)),
                    Arguments.of(new ImmutableVector3d(5.0, 4.0, 2.1), 1.0, new ImmutableVector3d(5.0, 4.0, 2.1)),
                    Arguments.of(new ImmutableVector3d(4.0, 8.0, 27.0), 2.5, new ImmutableVector3d(32.0, 128 * SQRT_2, 2187 * SQRT_3)),
                    Arguments.of(new ImmutableVector3d(1000.0, 100.0, 10.0), 0.0, new ImmutableVector3d(1.0, 1.0, 1.0))
            );
        }

        static Stream<Arguments> HadamardVector3dPowerProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(2.0, 3.0, 4.0), new ImmutableVector3d(3.0, 2.0, 0.5), new ImmutableVector3d(8.0, 9.0, 2.0)),
                    Arguments.of(new ImmutableVector3d(9.0, 16.0, 25.0), new ImmutableVector3d(0.5, 0.5, 0.5), new ImmutableVector3d(3.0, 4.0, 5.0)),
                    Arguments.of(new ImmutableVector3d(5.0, 2.0, 10.0), new ImmutableVector3d(1.0, 3.0, 2.0), new ImmutableVector3d(5.0, 8.0, 100.0)),
                    Arguments.of(new ImmutableVector3d(4.0, 8.0, 27.0), new ImmutableVector3d(2.0, 1.0, 1.0 / 3.0), new ImmutableVector3d(16.0, 8.0, 3.0)),
                    Arguments.of(new ImmutableVector3d(1.0, 7.0, 9.0), new ImmutableVector3d(5.0, 0.0, 2.0), new ImmutableVector3d(1.0, 1.0, 81.0))
            );
        }

        static Stream<Arguments> vector3dSignProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(-2.5, 0.0, 3.6), new ImmutableVector3d(-1.0, 0.0, 1.0)),
                    Arguments.of(new ImmutableVector3d(5.0, -7.0, 0.0), new ImmutableVector3d(1.0, -1.0, 0.0)),
                    Arguments.of(new ImmutableVector3d(0.1, -0.2, 0.3), new ImmutableVector3d(1.0, -1.0, 1.0)),
                    Arguments.of(new ImmutableVector3d(0.0, 0.0, 0.0), new ImmutableVector3d(0.0, 0.0, 0.0)),
                    Arguments.of(new ImmutableVector3d(-8.0, 4.0, -6.0), new ImmutableVector3d(-1.0, 1.0, -1.0))
            );
        }

        static Stream<Arguments> vector3dMinimumProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(2.0, 8.0, -1.0), new ImmutableVector3d(-1.0, 0.0, 1.0), new ImmutableVector3d(-1.0, 0.0, -1.0)),
                    Arguments.of(new ImmutableVector3d(5.5, 3.3, 9.1), new ImmutableVector3d(-2.0, -2.0, -2.0), new ImmutableVector3d(-2.0, -2.0, -2.0)),
                    Arguments.of(new ImmutableVector3d(-4.0, -7.0, -2.0), new ImmutableVector3d(), new ImmutableVector3d(-4.0, -7.0, -2.0)),
                    Arguments.of(new ImmutableVector3d(0.0, 1.0, -5.0), new ImmutableVector3d(2.0, -10.3, -5.9), new ImmutableVector3d(0.0, -10.3, -5.9)),
                    Arguments.of(new ImmutableVector3d(6.0, 6.0, 6.0), new ImmutableVector3d(5.0, 7.0, -1.0), new ImmutableVector3d(5.0, 6.0, -1.0))
            );
        }

        static Stream<Arguments> vector3dMaximumProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(2.0, 8.0, -1.0), new ImmutableVector3d(), new ImmutableVector3d(2.0, 8.0, 0.0)),
                    Arguments.of(new ImmutableVector3d(5.5, 3.3, 9.1), new ImmutableVector3d(5.4, 3.4, 9.0), new ImmutableVector3d(5.5, 3.4, 9.1)),
                    Arguments.of(new ImmutableVector3d(-4.0, -7.0, -2.0), new ImmutableVector3d(), new ImmutableVector3d()),
                    Arguments.of(new ImmutableVector3d(0.0, 1.0, -5.0), new ImmutableVector3d(-10.0, 0.5, -4.3), new ImmutableVector3d(0.0, 1.0, -4.3)),
                    Arguments.of(new ImmutableVector3d(6.0, 6.0, 6.0), new ImmutableVector3d(), new ImmutableVector3d(6.0, 6.0, 6.0))
            );
        }

        static Stream<Arguments> vector3dFloorProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(2.9, -3.1, 4.0), new ImmutableVector3d(2.0, -4.0, 4.0)),
                    Arguments.of(new ImmutableVector3d(-1.2, 5.8, 0.5), new ImmutableVector3d(-2.0, 5.0, 0.0)),
                    Arguments.of(new ImmutableVector3d(7.0, 8.9, -6.4), new ImmutableVector3d(7.0, 8.0, -7.0)),
                    Arguments.of(new ImmutableVector3d(-0.1, -0.9, 2.3), new ImmutableVector3d(-1.0, -1.0, 2.0)),
                    Arguments.of(new ImmutableVector3d(9.99, 4.01, -8.99), new ImmutableVector3d(9.0, 4.0, -9.0))
            );
        }

        static Stream<Arguments> vector3dCeilProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(2.1, -3.1, 4.0), new ImmutableVector3d(3.0, -3.0, 4.0)),
                    Arguments.of(new ImmutableVector3d(-1.2, 5.8, 0.5), new ImmutableVector3d(-1.0, 6.0, 1.0)),
                    Arguments.of(new ImmutableVector3d(7.0, 8.1, -6.4), new ImmutableVector3d(7.0, 9.0, -6.0)),
                    Arguments.of(new ImmutableVector3d(-0.1, -0.9, 2.3), new ImmutableVector3d(0.0, 0.0, 3.0)),
                    Arguments.of(new ImmutableVector3d(9.01, 4.99, -8.01), new ImmutableVector3d(10.0, 5.0, -8.0))
            );
        }

        static Stream<Arguments> vector3dFractionProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(2.75, -3.25, 4.5), new ImmutableVector3d(0.75, 0.75, 0.5)),
                    Arguments.of(new ImmutableVector3d(-1.1, 5.9, 0.125), new ImmutableVector3d(0.9, 0.9, 0.125)),
                    Arguments.of(new ImmutableVector3d(7.0, 8.25, -6.75), new ImmutableVector3d(0.0, 0.25, 0.25)),
                    Arguments.of(new ImmutableVector3d(-0.5, -0.01, 2.99), new ImmutableVector3d(0.5, 0.99, 0.99)),
                    Arguments.of(new ImmutableVector3d(9.99, 4.01, -8.5), new ImmutableVector3d(0.99, 0.01, 0.5))
            );
        }

        static Stream<Arguments> vector3dModuloProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(5.5, 8.2, 10.7), new ImmutableVector3d(2.0, 3.0, 4.0), new ImmutableVector3d(1.5, 2.2, 2.7)),
                    Arguments.of(new ImmutableVector3d(9.0, 14.5, 20.0), new ImmutableVector3d(4.0, 5.0, 6.0), new ImmutableVector3d(1.0, 4.5, 2.0)),
                    Arguments.of(new ImmutableVector3d(12.75, 6.25, 3.5), new ImmutableVector3d(5.0, 2.0, 1.5), new ImmutableVector3d(2.75, 0.25, 0.5)),
                    Arguments.of(new ImmutableVector3d(7.2, 9.8, 11.4), new ImmutableVector3d(2.5, 4.0, 5.0), new ImmutableVector3d(2.2, 1.8, 1.4)),
                    Arguments.of(new ImmutableVector3d(15.0, 16.0, 17.0), new ImmutableVector3d(4.0, 7.0, 5.0), new ImmutableVector3d(3.0, 2.0, 2.0))
            );
        }

        static Stream<Arguments> vector3dSineProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(0.0, Math.PI / 2.0, Math.PI), new ImmutableVector3d(0.0, 1.0, 0.0)),
                    Arguments.of(new ImmutableVector3d(Math.PI / 6.0, Math.PI / 4.0, Math.PI / 3.0), new ImmutableVector3d(0.5, Math.sqrt(2.0) / 2.0, Math.sqrt(3.0) / 2.0)),
                    Arguments.of(new ImmutableVector3d(-Math.PI / 2.0, 0.0, Math.PI / 2.0), new ImmutableVector3d(-1.0, 0.0, 1.0)),
                    Arguments.of(new ImmutableVector3d(Math.PI, 2.0 * Math.PI, 3.0 * Math.PI / 2.0), new ImmutableVector3d(0.0, 0.0, -1.0)),
                    Arguments.of(new ImmutableVector3d(Math.PI / 4.0, -Math.PI / 4.0, 0.0), new ImmutableVector3d(Math.sqrt(2.0) / 2.0, -Math.sqrt(2.0) / 2.0, 0.0))
            );
        }

        static Stream<Arguments> vector3dCosineProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(0.0, Math.PI / 2.0, Math.PI), new ImmutableVector3d(1.0, 0.0, -1.0)),
                    Arguments.of(new ImmutableVector3d(Math.PI / 3.0, Math.PI / 4.0, Math.PI / 6.0), new ImmutableVector3d(0.5, Math.sqrt(2.0) / 2.0, Math.sqrt(3.0) / 2.0)),
                    Arguments.of(new ImmutableVector3d(-Math.PI / 2.0, 0.0, Math.PI / 2.0), new ImmutableVector3d(0.0, 1.0, 0.0)),
                    Arguments.of(new ImmutableVector3d(Math.PI, 2.0 * Math.PI, 3.0 * Math.PI / 2.0), new ImmutableVector3d(-1.0, 1.0, 0.0)),
                    Arguments.of(new ImmutableVector3d(Math.PI / 4.0, -Math.PI / 4.0, 0.0), new ImmutableVector3d(Math.sqrt(2.0) / 2.0, Math.sqrt(2.0) / 2.0, 1.0))
            );
        }

        static Stream<Arguments> vector3dTangentProvider() {
            return Stream.of(
                    Arguments.of(new ImmutableVector3d(0.0, Math.PI / 4.0, -Math.PI / 4.0), new ImmutableVector3d(0.0, 1.0, -1.0)),
                    Arguments.of(new ImmutableVector3d(Math.PI / 6.0, Math.PI / 3.0, 0.0), new ImmutableVector3d(Math.sqrt(3.0) / 3.0, Math.sqrt(3.0), 0.0)),
                    Arguments.of(new ImmutableVector3d(-Math.PI / 4.0, Math.PI, 2.0 * Math.PI), new ImmutableVector3d(-1.0, 0.0, 0.0)),
                    Arguments.of(new ImmutableVector3d(Math.PI / 8.0, -Math.PI / 8.0, Math.PI / 4.0), new ImmutableVector3d(Math.tan(Math.PI / 8.0), Math.tan(-Math.PI / 8.0), 1.0)),
                    Arguments.of(new ImmutableVector3d(0.1, -0.2, 0.3), new ImmutableVector3d(Math.tan(0.1), Math.tan(-0.2), Math.tan(0.3)))
            );
        }
    }

    /**
     * Test suites for {@link com.mrgoddavid.function.limit.Limit} class.
     *
     * @author Mr. GodDavid
     * @since 7/28/2026
     */
    static class LimitClassTestSuites extends TestSuites {

        static Stream<Arguments> normalLimitTestProvider() {
            return Stream.of(
                    Arguments.of(new Function(x -> 8.0 - 3.0 * x + 12.0 * x * x), 2.0, 50.0, EPSILON),
                    Arguments.of(new Function(x -> (6.0 + 4.0 * x) / (x * x + 1)), -3.0, -0.6, EPSILON),
                    Arguments.of(new Function(x -> 1 - 4.0 * x * x * x), -9.0, 2917.0, EPSILON),
                    Arguments.of(new Function(y -> 6.0 * y * y * y * y - 7 * y * y * y + 12.0 * y + 25.0), 1.0, 36.0, EPSILON),
                    Arguments.of(new Function(t -> (t * t + 6.0) / (t * t - 3.0)), 0.0, -2.0, EPSILON),
                    Arguments.of(new Function(z -> (6.0 * z) / (2.0 + 3.0 * z * z)), 4.0, 0.48, EPSILON)
            );
        }

        static Stream<Arguments> zero_over_zeroLimitTestProvider() {
            return Stream.of(
                    Arguments.of(new RationalFunction(x -> (x * x - 25.0), x -> (x * x + 2.0 * x - 15.0)), -5.0, 1.25, EPSILON),
                    Arguments.of(new RationalFunction(z -> (2.0 * z * z - 17.0 * z + 8.0), z -> (8.0 - z)), 8.0, -15.0, EPSILON),
                    Arguments.of(new RationalFunction(h -> ((6.0 + h) * (6.0 + h) - 36.0), h -> (h)), 0.0, 12.0, EPSILON),
                    Arguments.of(new RationalFunction(z -> (Math.sqrt(z) - 2.0), z -> (z - 4.0)), 4.0, 0.25, EPSILON),
                    Arguments.of(new RationalFunction(x -> (Math.sqrt(2.0 * x + 22.0) - 4.0), x -> (x + 3.0)), -3.0, 0.25, EPSILON),
                    Arguments.of(new RationalFunction(x -> (x), x -> (3.0 - Math.sqrt(x + 9.0))), 0.0, -6.0, EPSILON)
            );
        }

        static Stream<Arguments> infiniteLimitTestProvider() {
            return Stream.of(
                    Arguments.of(new Function(x -> (9.0) / (Math.pow((x - 3.0), (5)))), 3.0, Double.NaN, EPSILON),
                    Arguments.of(new Function(t -> (2.0 * t) / (6.0 + t)), -6.0, Double.NaN, EPSILON),
                    Arguments.of(new Function(z -> (z + 3.0) / ((z + 1.0) * (z + 1.0))), -1.0, Double.POSITIVE_INFINITY, EPSILON),
                    Arguments.of(new Function(x -> (x + 7.0) / (x * x - 4.0)), 2.0, Double.NaN, EPSILON),
                    Arguments.of(new Function(x -> Math.log(-x)), 0.0, Double.NaN, EPSILON),
                    Arguments.of(new Function(y -> DavidMath.tan(new Radian(y))), THREE_PI_OVER_TWO.val(), Double.NaN, EPSILON)
            );
        }

        static Stream<Arguments> limitAtInfinityTestProvider() {
            return Stream.of(
                    Arguments.of(new Function(x -> 4.0 * Math.pow(x, 7) - 18.0 * x * x * x + 9.0), Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, EPSILON),
                    Arguments.of(new Function(x -> 4.0 * Math.pow(x, 7) - 18.0 * x * x * x + 9.0), Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, EPSILON),
                    Arguments.of(new RationalFunction(x -> 6.0 * x, x -> x * x), Double.POSITIVE_INFINITY, 0.0, EPSILON),
                    Arguments.of(new RationalFunction((x -> 3.0 * x * x), (x -> 2.0 * x)), Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, EPSILON),
                    Arguments.of(new RationalFunction((x -> 6.0 * x * x), (x -> 7.0 * x * x)), Double.POSITIVE_INFINITY, 0.8571428571, EPSILON),
                    Arguments.of(new RationalFunction((x -> x + 8.0), (x -> Math.sqrt(2.0 * x * x + 3.0))), Double.NEGATIVE_INFINITY, -0.7071067812, EPSILON)
            );
        }
    }
}
