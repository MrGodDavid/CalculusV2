import com.mrgoddavid.vector.immutable.ImmutableVector3d;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the root class of all test suites of three-dimensional vectors of this library
 *
 * @author Mr. GodDavid
 * @since 7/20/2026
 */
public class ImmutableVector3D_ClassTest extends TestSuites.Vector3dTestSuites {

    @ParameterizedTest
    @MethodSource("vector3dAdditionProvider")
    void executeTestSuites(ImmutableVector3d a, ImmutableVector3d b, ImmutableVector3d expected) {
        ImmutableVector3d result = a.add(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dSubtractionProvider")
    void subtractionTest(ImmutableVector3d a, ImmutableVector3d b, ImmutableVector3d expected) {
        ImmutableVector3d result = a.subtract(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dEntrywiseMultiplicationProvider")
    void entrywiseMultiplicationTest(ImmutableVector3d a, ImmutableVector3d b, ImmutableVector3d expected) {
        ImmutableVector3d result = a.multiply(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dEntrywiseDivisionProvider")
    void entrywiseDivisionTest(ImmutableVector3d a, ImmutableVector3d b, ImmutableVector3d expected) {
        ImmutableVector3d result = a.divide(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dMultiplyAddProvider")
    void multiplyAddTest(ImmutableVector3d a, ImmutableVector3d b, ImmutableVector3d c, ImmutableVector3d expected) {
        ImmutableVector3d result = a.multiply_add(b, c);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dDotProductProvider")
    void dotProductTest(ImmutableVector3d a, ImmutableVector3d b, double expected) {
        double result = a.dot_product(b);
        assertEquals(expected, result, EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dCrossProductProvider")
    void crossProductTest(ImmutableVector3d a, ImmutableVector3d b, ImmutableVector3d expected) {
        ImmutableVector3d result = a.crossProduct(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dDistanceProvider")
    void distanceTest(ImmutableVector3d a, ImmutableVector3d b, double expected) {
        double result = a.distance(b);
        assertEquals(expected, result, EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dLengthProvider")
    void lengthTest(ImmutableVector3d a, double expected) {
        double result = a.length();
        assertEquals(expected, result, EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dScaleProvider")
    void scaleTest(ImmutableVector3d a, double scaler, ImmutableVector3d expected) {
        ImmutableVector3d result = a.scale(scaler);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dNormalizeProvider")
    void normalizeTest(ImmutableVector3d a, ImmutableVector3d expected) {
        ImmutableVector3d result = a.normalize();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dAbsoluteProvider")
    void absoluteTest(ImmutableVector3d a, ImmutableVector3d expected) {
        ImmutableVector3d result = a.absolute();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dPowerProvider")
    void powerTest(ImmutableVector3d a, double exp, ImmutableVector3d expected) {
        ImmutableVector3d result = a.power(exp);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dSignProvider")
    void signTest(ImmutableVector3d a, ImmutableVector3d expected) {
        ImmutableVector3d result = a.sign();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dMinimumProvider")
    void minTest(ImmutableVector3d a, ImmutableVector3d b, ImmutableVector3d expected) {
        ImmutableVector3d result = a.minimum(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dMaximumProvider")
    void maxTest(ImmutableVector3d a, ImmutableVector3d b, ImmutableVector3d expected) {
        ImmutableVector3d result = a.maximum(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dFloorProvider")
    void floorTest(ImmutableVector3d a, ImmutableVector3d expected) {
        ImmutableVector3d result = a.floor();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dCeilProvider")
    void ceilTest(ImmutableVector3d a, ImmutableVector3d expected) {
        ImmutableVector3d result = a.ceil();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dFractionProvider")
    void fractionTest(ImmutableVector3d a, ImmutableVector3d expected) {
        ImmutableVector3d result = a.fraction();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dModuloProvider")
    void moduloTest(ImmutableVector3d a, ImmutableVector3d b, ImmutableVector3d expected) {
        ImmutableVector3d result = a.modulo(b);
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dSineProvider")
    void sineTest(ImmutableVector3d a, ImmutableVector3d expected) {
        ImmutableVector3d result = a.sine();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dCosineProvider")
    void cosineTest(ImmutableVector3d a, ImmutableVector3d expected) {
        ImmutableVector3d result = a.cosine();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }

    @ParameterizedTest
    @MethodSource("vector3dTangentProvider")
    void tangentTest(ImmutableVector3d a, ImmutableVector3d expected) {
        ImmutableVector3d result = a.tangent();
        assertEquals(expected.getX(), result.getX(), EPSILON);
        assertEquals(expected.getY(), result.getY(), EPSILON);
        assertEquals(expected.getZ(), result.getZ(), EPSILON);
    }
}
