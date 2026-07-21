import com.mrgoddavid.vector.Vector3d;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the root class of all test suites of three-dimensional vectors of this library
 *
 * @author Mr. GodDavid
 * @since 7/20/2026
 */
public class Vector3dTestSuites extends TestSuites {

    @ParameterizedTest
    @MethodSource("vector3dAdditionProvider")
    void executeTestSuites(Vector3d a, Vector3d b, Vector3d expected) {
        Vector3d result = a.add(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dSubtractionProvider")
    void subtractionTest(Vector3d a, Vector3d b, Vector3d expected) {
        Vector3d result = a.subtract(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dEntrywiseMultiplicationProvider")
    void entrywiseMultiplicationTest(Vector3d a, Vector3d b, Vector3d expected) {
        Vector3d result = a.multiply(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dEntrywiseDivisionProvider")
    void entrywiseDivisionTest(Vector3d a, Vector3d b, Vector3d expected) {
        Vector3d result = a.divide(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dMultiplyAddProvider")
    void multiplyAddTest(Vector3d a, Vector3d b, Vector3d c, Vector3d expected) {
        Vector3d result = a.multiply_add(b, c);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }
}
