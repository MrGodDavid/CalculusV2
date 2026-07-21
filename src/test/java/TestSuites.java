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
}
