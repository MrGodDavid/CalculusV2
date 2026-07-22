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

    @ParameterizedTest
    @MethodSource("vector3dDotProductProvider")
    void dotProductTest(Vector3d a, Vector3d b, double expected) {
        double result = a.dot_product(b);
        assertEquals(expected, result, EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dCrossProductProvider")
    void crossProductTest(Vector3d a, Vector3d b, Vector3d expected) {
        Vector3d result = a.crossProduct(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dDistanceProvider")
    void distanceTest(Vector3d a, Vector3d b, double expected) {
        double result = a.distance(b);
        assertEquals(expected, result, EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dLengthProvider")
    void lengthTest(Vector3d a, double expected) {
        double result = a.length();
        assertEquals(expected, result, EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dScaleProvider")
    void scaleTest(Vector3d a,double scaler, Vector3d expected) {
        Vector3d result = a.scale(scaler);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dNormalizeProvider")
    void normalizeTest(Vector3d a, Vector3d expected) {
        Vector3d result = a.normalize();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dAbsoluteProvider")
    void absoluteTest(Vector3d a, Vector3d expected) {
        Vector3d result = a.absolute();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dPowerProvider")
    void powerTest(Vector3d a, double exp, Vector3d expected) {
        Vector3d result = a.power(exp);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dSignProvider")
    void signTest(Vector3d a, Vector3d expected) {
        Vector3d result = a.sign();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dMinimumProvider")
    void minTest(Vector3d a, Vector3d b, Vector3d expected) {
        Vector3d result = a.minimum(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dMaximumProvider")
    void maxTest(Vector3d a, Vector3d b, Vector3d expected) {
        Vector3d result = a.maximum(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dFloorProvider")
    void floorTest(Vector3d a, Vector3d expected) {
        Vector3d result = a.floor();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dCeilProvider")
    void ceilTest(Vector3d a, Vector3d expected) {
        Vector3d result = a.ceil();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dFractionProvider")
    void fractionTest(Vector3d a, Vector3d expected) {
        Vector3d result = a.fraction();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dModuloProvider")
    void moduloTest(Vector3d a, Vector3d b, Vector3d expected) {
        Vector3d result = a.modulo(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dSineProvider")
    void sineTest(Vector3d a, Vector3d expected) {
        Vector3d result = a.sine();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dCosineProvider")
    void cosineTest(Vector3d a, Vector3d expected) {
        Vector3d result = a.cosine();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dTangentProvider")
    void tangentTest(Vector3d a, Vector3d expected) {
        Vector3d result = a.tangent();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }
}
