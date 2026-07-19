import com.mrgoddavid.vector.Vector3d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector3dTest {

    private static final double EPS = 1e-9;

    @Test
    void testAddition() {
        Vector3d a = new Vector3d(1, 2, 3);
        Vector3d b = new Vector3d(4, 5, 6);

        Vector3d result = a.add(b);
        assertEquals(5, result.getX(), EPS);
        assertEquals(7, result.getY(), EPS);
        assertEquals(9, result.getZ(), EPS);
    }

    @Test
    void testSubtraction() {
        Vector3d a = new Vector3d(1, 2, 3);
        Vector3d b = new Vector3d(4, 5, 6);

        Vector3d result = a.subtract(b);
        assertEquals(-3, result.getX(), EPS);
        assertEquals(-3, result.getY(), EPS);
        assertEquals(-3, result.getZ(), EPS);
    }

    @Test
    void testScaling() {
        Vector3d v = new Vector3d(1, -2, 3);
        Vector3d result = v.scale(2);

        assertEquals(2, result.getX(), EPS);
        assertEquals(-4, result.getY(), EPS);
        assertEquals(6, result.getZ(), EPS);
    }

    @Test
    void testMagnitude() {
        Vector3d v = new Vector3d(3, 4, 12);

        assertEquals(13, v.length(), EPS);
    }

    @Test
    void testNormalization() {
        Vector3d v = new Vector3d(3, 4, 0);
        Vector3d u = v.normalize();

        assertEquals(1.0, u.length(), EPS);
        assertEquals(0.6, u.getX(), EPS);
        assertEquals(0.8, u.getY(), EPS);
    }

    @Test
    void testDotProduct() {
        Vector3d v = new Vector3d(1, 2, 3);
        Vector3d u = new Vector3d(4, -5, 6);

        assertEquals(12, v.dot_product(u), EPS);
    }

    @Test
    void testCrossProduct() {
        Vector3d v = new Vector3d(1, 2, 3);
    }

}
