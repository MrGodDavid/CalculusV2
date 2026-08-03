package com.mrgoddavid.vector;

import com.mrgoddavid.geometry.angle.Radian;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Custom 2i vector class. Parameters are integer variable.
 *
 * @author Mr. GodDavid.
 * @since 3/30/2026
 */
@SuppressWarnings("ClassCanBeRecord")
public class Vector2i implements Vector2<Vector2i>, Comparable<Vector2i>, Comparator<Vector2i>, Serializable {

    /**
     * Zero vector of this class.
     */
    public static final Vector2i ZERO = new Vector2i();

    /**
     * Unit vector along x-axis. We define this unit vector as i.
     */
    public static final Vector2i UNIT_I = new Vector2i(1, 0);

    /**
     * Unit vector along y-axis. We define this unit vector as j.
     */
    public static final Vector2i UNIT_J = new Vector2i(0, 1);

    @Serial
    private static final long serialVersionUID = 2910385014691604552L;

    /**
     * X coordinate of this vector.
     */
    private final int x;
    /**
     * Y coordinate of this vector.
     */
    private final int y;

    /**
     * Default constructor.
     */
    public Vector2i() {
        this(0, 0);
    }

    /**
     * Constructs a 2d vector by the given parameters.
     *
     * @param x coordinate of this vector.
     * @param y coordinate of this vector.
     */
    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a 2d vector from the given in parameter.
     *
     * @param vector that is not null.
     */
    public Vector2i(Vector2i vector) {
        this(vector.x, vector.y);
    }

    /**
     * Performs entry addition of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the sum of two vectors.</p>
     *
     * @param second vector that is not null.
     * @return the sum of two vectors.
     */
    @Override
    public Vector2i add(Vector2i second) {
        return new Vector2i(x + second.x, y + second.y);
    }

    /**
     * Performs entry subtraction of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the difference between two vectors.</p>
     *
     * @param second vector that is not null.
     * @return the difference between two vectors.
     */
    @Override
    public Vector2i subtract(Vector2i second) {
        return new Vector2i(x - second.x, y - second.y);
    }

    /**
     * Performs entry multiplication of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the product of two vectors.</p>
     *
     * @param second vector that is not null.
     * @return the product of two vectors.
     */
    @Override
    public Vector2i multiply(Vector2i second) {
        return new Vector2i(x * second.x, y * second.y);
    }

    /**
     * Performs entry division of two vectors.
     * <p>Precondition: second vector is not null and its component does not contain 0.</p>
     * <p>Postcondition: returns the quotient of two vectors.</p>
     *
     * @param second vector that is not null.
     * @return the quotient of two vectors.
     */
    @Override
    public Vector2i divide(Vector2i second) {
        if (compNotContainsZero(second.x, second.y)) {
            return new Vector2i(x / second.x, y / second.y);
        }
        return Vector2.NAN_2I;
    }

    /**
     * Performs entry multiplication and then addition of a vector itself.
     * <p>Precondition: multiplier vector and adder vector are not null.</p>
     * <p>Postcondition: returns the vector that is  multiplied multiplier vector and by  of two vectors.</p>
     *
     * @param multiplier vector that is not null.
     * @param adder      vector that is not null.
     * @return the vector that is  multiplied multiplier vector and by  of two vectors.
     */
    @Override
    public Vector2i multiply_add(Vector2i multiplier, Vector2i adder) {
        int newX = x * multiplier.x + adder.x;
        int newY = y * multiplier.y + adder.y;
        return new Vector2i(newX, newY);
    }

    /**
     * Performs the cross product of this vector to the second vector.
     * <p>Precondition: second input vector is not null.</p>
     * <p>Postcondition: calculate the cross product of itself to the second input vector.</p>
     *
     * @param second vector that is not null.
     * @return the cross product of itself to the second input vector.
     */
    @Override
    public double cross_product(Vector2i second) {
        return x * second.y - y * second.x;
    }

    /**
     * Project itself on the second vector.
     * <p>Precondition: second input vector in not null.</p>
     * <p>Postcondition: calculate the projection vector of the second vector.</p>
     *
     * @param second vector that is not null.
     * @return the projection vector of the second vector.
     */
    @Override
    public Vector2i project(Vector2i second) {
        double length = second.length();
        if (length == 0) {
            return new Vector2i();
        }
        double dotProduct = dot_product(second);
        double scaleVector = dotProduct / (length * length);
        return second.scale(scaleVector);
    }

    /**
     * Reflect itself around the normal of the second input vector.
     * <p>Precondition: second input vector is not null and itself does not need to be normalized.</p>
     * <p>Postcondition: calculate the reflected </p>
     *
     * @param second vector that is not null.
     * @return the reflected vector around the normal of the second vector.
     */
    @Override
    public Vector2i reflect(Vector2i second) {
        if (second.length() == 0) return new Vector2i();
        Vector2i n = second.normalize();
        double dotProduct = dot_product(n);
        Vector2i a = second.scale(dotProduct * 2);
        return this.subtract(a);
    }

    /**
     * Orients a vector A (itself) to point away from a surface B as defined by its normal C.
     * <p>Precondition: incident vector and reference vector are not null.</p>
     * <p>Postcondition: calculate the orientation of vector.</p>
     *
     * @param incident  the vector being checked and itself is not null.
     * @param reference the surface normal used to determine the orientation and itself is not null.
     * @return the calculated vector that is either flipped or not.
     */
    @Override
    public Vector2i faceForward(Vector2i incident, Vector2i reference) {
        return (incident.dot_product(reference) < 0) ? new Vector2i(this) : new Vector2i(this.scale(-1d));
    }

    /**
     * Calculate the dot product of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: calculate the dot product of itself and the second vector.</p>
     *
     * @param second vector that is not null.
     * @return the dot product of itself and the second vector.
     */
    @Override
    public double dot_product(Vector2i second) {
        return x * second.x + y * second.y;
    }

    /**
     * Calculate the distance between two points are each represented by a 2-d vector.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: calculate the distance between itself and the second vector.</p>
     *
     * @param second vector that is not null.
     * @return the distance between itself and the second vector.
     */
    @Override
    public double distance(Vector2i second) {
        int dx = x - second.x;
        int dy = y - second.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Calculate the length/magnitude of the vector.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the length of itself.</p>
     *
     * @return the length of itself.
     */
    @Override
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Entry scale each component by a scale factor.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the scaled vector.</p>
     *
     * @param scale scaling factor.
     * @return the result of multiplying itself by the scalar input <code>scale</code>.
     */
    @Override
    public Vector2i scale(double scale) {
        return new Vector2i(x * (int) scale, y * (int) scale);
    }

    /**
     * Calculate the vector that is the normalized version of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the normalized vector.</p>
     *
     * @return the normalized vector.
     */
    @Override
    public Vector2i normalize() {
        if (length() == 0) {
            return new Vector2i();
        }
        return new Vector2i((int) (x / length()), (int) (y / length()));
    }

    /**
     * The entrywise absolute value of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: The entrywise absolute value of itself.</p>
     *
     * @return a new vector2 that contains the entrywise absolute value of itself.
     */
    @Override
    public Vector2i absolute() {
        return new Vector2i(Math.abs(x), Math.abs(y));
    }

    /**
     * The entrywise power operator where the Base raised to the power of Exponent.
     * <p>Precondition: none.</p>
     * <p>Postcondition: The entrywise power operator where the Base raised to the power of Exponent.</p>
     *
     * @param exp the power exponent.
     * @return a new vector2 that contains the entrywise power operator where the Base raised to the power of Exponent.
     */
    @Override
    public Vector2i power(double exp) {
        return new Vector2i((int) Math.pow(x, exp), (int) Math.pow(x, exp));
    }

    /**
     * Extracts the sign of the input value. All positive numbers will output 1.0. All negative numbers will output
     * -1.0.
     * And 0.0 will output 0.0.
     * <p>Precondition: none.</p>
     * <p>Postcondition: Extract the sign of each component.</p>
     *
     * @return a new vector that represents the sign of each component value.
     */
    @Override
    public Vector2i sign() {
        int signX = x > 0 ? 1 : x == 0 ? 0 : -1;
        int signY = y > 0 ? 1 : y == 0 ? 0 : -1;
        return new Vector2i(signX, signY);
    }

    /**
     * The entrywise minimum of itself and the second vector.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: return a new vector that contains entrywise minimum of itself and the second vector.</p>
     *
     * @param second vector that is not null.
     * @return a new vector that contains entrywise minimum of itself and the second vector
     */
    @Override
    public Vector2i minimum(Vector2i second) {
        return new Vector2i(Math.min(x, second.x), Math.min(y, second.y));
    }

    /**
     * The entrywise maximum of itself and the second vector.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: return a new vector that contains entrywise maximum of itself and the second vector.</p>
     *
     * @param second vector that is not null.
     * @return a new vector that contains entrywise maximum of itself and the second vector
     */
    @Override
    public Vector2i maximum(Vector2i second) {
        return new Vector2i(Math.max(x, second.x), Math.max(y, second.y));
    }

    /**
     * Rounds itself entrywise down to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise down to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise down to the nearest integer.
     */
    @Override
    public Vector2i floor() {
        return new Vector2i((int) Math.floor(x), (int) Math.floor(y));
    }

    /**
     * Rounds itself entrywise up to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise up to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise up to the nearest integer.
     */
    @Override
    public Vector2i ceil() {
        return new Vector2i((int) Math.ceil(x), (int) Math.ceil(y));
    }

    /**
     * Returns the fractional part of the value entrywise.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns the fractional part of the value entrywise.</p>
     *
     * @return the fractional part of the value entrywise.
     */
    @Override
    public Vector2i fraction() {
        return this.subtract(this.floor());
    }

    /**
     * The entrywise modulo of itself by the second vector.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the entrywise modulo of itself by the second vector.</p>
     *
     * @param second vector that is not null.
     * @return the entrywise modulo of itself by the second vector.
     */
    @Override
    public Vector2i modulo(Vector2i second) {
        if (compNotContainsZero(x, y)) {
            return new Vector2i(x % second.x, y % second.y);
        }
        return Vector2.NAN_2I;
    }

    /**
     * The entrywise output of a value between Min and Max based on the absolute difference between the input value
     * and the nearest integer multiple of Max less than the value.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a new vector that is entrywise wrapped for each its component.</p>
     *
     * @param minimum minimum threshold.
     * @param maximum : maximum threshold.
     * @return a new vector that is entrywise wrapped for each its component.
     */
    @Override
    public Vector2i wrap(Vector2i minimum, Vector2i maximum) {
        Vector2i v1 = this.subtract(minimum);
        Vector2i range = maximum.subtract(minimum);
        return this.subtract(range.multiply(v1.divide(range)).floor());
    }

    /**
     * The result of rounding itself to the largest integer multiple of B less than or equal itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a new vector that is entrywise snapped for each its component.</p>
     *
     * @param second that is not null.
     * @return a new vector that is entrywise snapped for each its component.
     */
    @Override
    public Vector2i snap(Vector2i second) {
        return this.divide(second).floor().multiply(second);
    }

    /**
     * The entrywise of sine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of sine of its component</p>
     *
     * @return the entrywise of sine of itself.
     */
    @Override
    public Vector2i sine() {
        return new Vector2i((int) Math.sin(x), (int) Math.sin(y));
    }

    /**
     * The entrywise of cosine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of cosine of its component</p>
     *
     * @return the entrywise of cosine of itself.
     */
    @Override
    public Vector2i cosine() {
        return new Vector2i((int) Math.cos(x), (int) Math.cos(y));
    }

    /**
     * The entrywise of tangent of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of tangent of its component</p>
     *
     * @return the entrywise of tangent of itself.
     */
    @Override
    public Vector2i tangent() {
        return new Vector2i((int) Math.tan(x), (int) Math.tan(y));
    }

    /**
     * Copy itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a new reference of itself.</p>
     *
     * @return a new reference of itself.
     */
    @Override
    public Vector2i copy() {
        return new Vector2i(this.x, this.y);
    }

    /**
     * Return a reference of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a reference of itself.</p>
     *
     * @return Return a reference of itself.
     */
    @Override
    public Vector2i getSelf() {
        return this;
    }

    @Override
    public int compareTo(Vector2i o) {
        if (this.x != o.getX()) {
            return Integer.compare(x, o.getX());
        }
        if (this.y != o.getY()) {
            return Integer.compare(this.y, o.getY());
        }
        return (this.x == o.getX() && this.y == o.getY())
                ? 0
                : Integer.compare((int) this.length(), (int) o.length());
    }

    @Override
    public int compare(Vector2i o1, Vector2i o2) {
        return o1.compareTo(o2);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vector2i vector2i = (Vector2i) o;
        return x == vector2i.x && y == vector2i.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Accessor of the x coordinate.
     *
     * @return the value of x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Accessor of the y coordinate.
     *
     * @return the value of y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Rotate the vector in given angle around the origin.
     *
     * @param angle given angle in radians.
     * @return the rotated vector.
     * @since 7/24/2026 part of Transformation &amp; Circles Update.
     */
    @Deprecated
    @Override
    public Vector2i rotate(Radian angle) {
        return null;
    }
}
