import com.mrgoddavid.utils.Constants;
import com.mrgoddavid.vector.Vector3d;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * This is the root class of all test suites of this library.
 *
 * @author Mr. GodDavid
 * @since 7/20/2026
 */
public class TestSuites {

    protected static final double EPSILON = Constants.EPSILON;

    static Stream<Arguments> vector3dAdditionProvider() {
        return Stream.of(
                Arguments.of(new Vector3d(1.0, 1.0, 0.0), new Vector3d(1.0, 0.0, 1.0), new Vector3d(2.0, 1.0, 1.0)),
                Arguments.of(new Vector3d(2.0, -1.0, 0.0), new Vector3d(1.0, 0.0, 1.0), new Vector3d(3.0, -1.0, 1.0)),
                Arguments.of(new Vector3d(1.0, 2.0, -3.0), new Vector3d(-1.0, 0.0, -1.0), new Vector3d(0.0, 2.0, -4.0)),
                Arguments.of(new Vector3d(1.0, -10.0, -111.0), new Vector3d(99.0, -90.0, 111.0), new Vector3d(100.0, -100.0, 0.0)),
                Arguments.of(new Vector3d(-100.0, 101.0, 100.0), new Vector3d(100.0, -101.0, -100.0), new Vector3d())
        );
    }

    static Stream<Arguments> vector3dSubtractionProvider() {
        return Stream.of(
                Arguments.of(new Vector3d(3.7, -2.5, 8.4), new Vector3d(1.2, 4.8, -0.9), new Vector3d(2.5, -7.3, 9.3)),
                Arguments.of(new Vector3d(-6.8, 7.1, 3.6), new Vector3d(4.5, -2.9, 5.2), new Vector3d(-11.3, 10.0, -1.6)),
                Arguments.of(new Vector3d(10.5, 0.4, -7.8), new Vector3d(-3.6, 8.2, -4.1), new Vector3d(14.1, -7.8, -3.7)),
                Arguments.of(new Vector3d(2.9, -5.6, 9.3), new Vector3d(-7.4, -3.2, 4.8), new Vector3d(10.3, -2.4, 4.5)),
                Arguments.of(new Vector3d(4.8, -1.5, 6.7), new Vector3d(-2.3, 5.6, 1.4), new Vector3d(7.1, -7.1, 5.3))
        );
    }

    static Stream<Arguments> vector3dEntrywiseMultiplicationProvider() {
        return Stream.of(
                Arguments.of(new Vector3d(2.5, -3.2, 4.0), new Vector3d(1.6, 5.0, -2.5), new Vector3d(4.0, -16.0, -10.0)),
                Arguments.of(new Vector3d(3.0, -1.2, 0.5), new Vector3d(-6.4, 2.5, 7.8), new Vector3d(-19.2, -3.0, 3.9)),
                Arguments.of(new Vector3d(-2.0, 6.4, -3.2), new Vector3d(8.2, -4.5, 1.5), new Vector3d(-16.4, -28.8, -4.8)),
                Arguments.of(new Vector3d(-1.8, 9.5, -6.2), new Vector3d(4.5, -0.8, -1.5), new Vector3d(-8.1, -7.6, 9.3)),
                Arguments.of(new Vector3d(12.5, -3.6, 0.8), new Vector3d(0.4, 2.5, -7.5), new Vector3d(5.0, -9.0, -6.0))
        );
    }

    static Stream<Arguments> vector3dEntrywiseDivisionProvider() {
        return Stream.of(
                Arguments.of(new Vector3d(12.6, -18.0, 9.6), new Vector3d(4.2, 6.0, -3.2), new Vector3d(3.0, -3.0, -3.0)),
                Arguments.of(new Vector3d(-22.5, 14.4, -8.1), new Vector3d(4.5, -3.6, 2.7), new Vector3d(-5.0, -4.0, -3.0)),
                Arguments.of(new Vector3d(15.75, -21.6, 18.9), new Vector3d(5.25, -7.2, 6.3), new Vector3d(3.0, 3.0, 3.0)),
                Arguments.of(new Vector3d(-19.2, 24.5, -30.8), new Vector3d(6.4, -4.9, -7.7), new Vector3d(-3.0, -5.0, 4.0)),
                Arguments.of(new Vector3d(31.5, -16.8, 27.3), new Vector3d(10.5, -5.6, 9.1), new Vector3d(3.0, 3.0, 3.0))
        );
    }

    static Stream<Arguments> vector3dMultiplyAddProvider() {
        return Stream.of(
                Arguments.of(new Vector3d(2.5, -3.0, 4.0), new Vector3d(1.6, 5.0, -2.5), new Vector3d(1.0, 2.0, 3.0), new Vector3d(5.0, -13.0, -7.0)),
                Arguments.of(new Vector3d(-6.4, 2.5, 7.8), new Vector3d(3.0, -1.2, 0.5), new Vector3d(4.0, -2.0, 1.5), new Vector3d(-15.2, -5.0, 5.4)),
                Arguments.of(new Vector3d(8.2, -4.5, 1.5), new Vector3d(-2.0, 6.4, -3.2), new Vector3d(5.0, 1.0, -4.0), new Vector3d(-11.4, -27.8, -8.8)),
                Arguments.of(new Vector3d(-1.8, 9.5, -6.2), new Vector3d(4.5, -0.8, -1.5), new Vector3d(2.0, 3.0, 4.0), new Vector3d(-6.1, -4.6, 13.3)),
                Arguments.of(new Vector3d(12.5, -3.6, 0.8), new Vector3d(0.4, 2.5, -7.5), new Vector3d(-1.0, 6.0, 2.5), new Vector3d(4.0, -3.0, -3.5))
        );
    }

    static Stream<Arguments> vector3dDotProductProvider() {
        return Stream.of(
                Arguments.of(new Vector3d(1.0, 2.0, 3.0), new Vector3d(4.0, 5.0, 6.0), 32.0),
                Arguments.of(new Vector3d(2.5, -1.0, 4.0), new Vector3d(-3.0, 2.0, 1.5), -3.5),
                Arguments.of(new Vector3d(0.0, 3.0, -2.0), new Vector3d(5.0, -1.0, 4.0), -11.0),
                Arguments.of(new Vector3d(-2.0, 4.5, 1.0), new Vector3d(3.5, -2.0, 6.0), -10.0),
                Arguments.of(new Vector3d(7.2, -3.6, 1.8), new Vector3d(-1.5, 4.0, 2.5), -20.7)
        );
    }

    static Stream<Arguments> vector3dCrossProductProvider() {
        return Stream.of(
                Arguments.of(new Vector3d(1.0, 2.0, 3.0), new Vector3d(4.0, 5.0, 6.0), new Vector3d(-3.0, 6.0, -3.0)),
                Arguments.of(new Vector3d(2.5, -1.0, 4.0), new Vector3d(-3.0, 2.0, 1.5), new Vector3d(-9.5, -15.75, 2.0)),
                Arguments.of(new Vector3d(0.0, 3.0, -2.0), new Vector3d(5.0, -1.0, 4.0), new Vector3d(10.0, -10.0, -15.0)),
                Arguments.of(new Vector3d(-2.0, 4.5, 1.0), new Vector3d(3.5, -2.0, 6.0), new Vector3d(29.0, 15.5, -11.75)),
                Arguments.of(new Vector3d(7.2, -3.6, 1.8), new Vector3d(-1.5, 4.0, 2.5), new Vector3d(-16.2, -20.7, 23.4))
        );
    }

    static Stream<Arguments> vector3dDistanceProvider() {
        return Stream.of(
                Arguments.of(new Vector3d(1.0, 2.0, 3.0), new Vector3d(4.0, 6.0, 3.0), 5.0),
                Arguments.of(new Vector3d(-2.5, 1.0, 4.5), new Vector3d(0.5, -3.0, 1.5), Math.sqrt(34.0)),
                Arguments.of(new Vector3d(7.2, -1.8, 5.4), new Vector3d(7.2, -1.8, 5.4), 0.0),
                Arguments.of(new Vector3d(3.5, -2.5, 1.0), new Vector3d(-0.5, 1.5, -2.0), Math.sqrt(41.0)),
                Arguments.of(new Vector3d(-4.2, 8.1, -6.3), new Vector3d(1.8, 0.1, -0.3), Math.sqrt(136.0))
        );
    }
}
