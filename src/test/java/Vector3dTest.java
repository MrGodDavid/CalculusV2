import com.mrgoddavid.vector.Vector3d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector3dTest {

    private static final double DELTA = 1e-9;

    @Test
    void testAddition() {
        // case 1
        Vector3d a = new Vector3d(1, 2, 3);
        Vector3d b = new Vector3d(4, 5, 6);
        Vector3d result = a.add(b);
        assertEquals(5d, result.getX(), DELTA);
        assertEquals(7d, result.getY(), DELTA);
        assertEquals(9d, result.getZ(), DELTA);


    }

    @Test
    void testSubtraction() {
        Vector3d a = new Vector3d(1, 2, 3);
        Vector3d b = new Vector3d(4, 5, 6);

        Vector3d result = a.subtract(b);
        assertEquals(-3d, result.getX(), DELTA);
        assertEquals(-3d, result.getY(), DELTA);
        assertEquals(-3d, result.getZ(), DELTA);
    }

    @Test
    void testScaling() {
        Vector3d v = new Vector3d(1, -2, 3);
        Vector3d result = v.scale(2);

        assertEquals(2d, result.getX(), DELTA);
        assertEquals(-4d, result.getY(), DELTA);
        assertEquals(6d, result.getZ(), DELTA);
    }

    @Test
    void testMagnitude() {
        Vector3d v = new Vector3d(3, 4, 12);

        assertEquals(13d, v.length(), DELTA);
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

        assertEquals(12d, v.dot_product(u), DELTA);
    }

    @Test
    void testCrossProduct() {
        Vector3d a = new Vector3d(2, 4, -1);
        Vector3d b = new Vector3d(10, 25, 20);

        Vector3d result = a.crossProduct(b, false);
        assertEquals(105d, result.getX(), DELTA);
        assertEquals(-50d, result.getY(), DELTA);
        assertEquals(10d, result.getZ(), DELTA);
    }

}
