import com.mrgoddavid.vector.Vector3d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector3dTest {

    private static final double DELTA = 1e-9;

    @Test
    void testAddition() {
        Vector3d a = new Vector3d(1, 2, 3);
        Vector3d b = new Vector3d(4, 5, 6);

        Vector3d result = a.add(b);
        assertEquals(5, result.getX(), DELTA);
        assertEquals(7, result.getY(), DELTA);
        assertEquals(9, result.getZ(), DELTA);
    }

    @Test
    void testSubtraction() {
        Vector3d a = new Vector3d(1, 2, 3);
        Vector3d b = new Vector3d(4, 5, 6);

        Vector3d result = a.subtract(b);
        assertEquals(-3, result.getX(), DELTA);
        assertEquals(-3, result.getY(), DELTA);
        assertEquals(-3, result.getZ(), DELTA);
    }

    @Test
    void testScaling() {
        Vector3d v = new Vector3d(1, -2, 3);
        Vector3d result = v.scale(2);

        assertEquals(2, result.getX(), DELTA);
        assertEquals(-4, result.getY(), DELTA);
        assertEquals(6, result.getZ(), DELTA);
    }

    @Test
    void testMagnitude() {
        Vector3d v = new Vector3d(3, 4, 12);

        assertEquals(13, v.length(), DELTA);
    }

    @Test
    void testNormalization() {
        Vector3d v = new Vector3d(3, 4, 0);
        Vector3d u = v.normalize();

        assertEquals(1.0, u.length(), DELTA);
        assertEquals(0.6, u.getX(), DELTA);
        assertEquals(0.8, u.getY(), DELTA);
    }

    @Test
    void testDotProduct() {
        Vector3d v = new Vector3d(1, 2, 3);
        Vector3d u = new Vector3d(4, -5, 6);

        assertEquals(12, v.dot_product(u), DELTA);
    }

    @Test
    void testCrossProduct() {
        Vector3d a = new Vector3d(2, 4, -1);
        Vector3d b = new Vector3d(10, 25, 20);

        Vector3d result = a.crossProduct(b, false);
        assertEquals(105, result.getX(), DELTA);
        assertEquals(-50, result.getY(), DELTA);
        assertEquals(10, result.getZ(), DELTA);
    }

}
