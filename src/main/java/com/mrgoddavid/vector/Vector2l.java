package com.mrgoddavid.vector;

import com.mrgoddavid.geometry.angle.Radian;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

/**
 * This class defines a two-dimensional vector that each coordinate is a long number.
 *
 * @author Mr. GodDavid
 * @since 7/21/2026 added this class.
 */
public class Vector2l implements Vector2<Vector2l>, Comparable<Vector2l>, Comparator<Vector2l>, Serializable {

    /**
     * Zero vector of this class.
     */
    public static final Vector2l ZERO = new Vector2l();

    /**
     * Unit vector along x-axis. We define this unit vector as i.
     */
    public static final Vector2l UNIT_I = new Vector2l(1L, 0L);

    /**
     * Unit vector along y-axis. We define this unit vector as j.
     */
    public static final Vector2l UNIT_J = new Vector2l(0L, 1L);

    @Serial
    private static final long serialVersionUID = -6221019907535906584L;

    /**
     * x component of this vector.
     */
    private final long x;

    /**
     * y component of this vector.
     */
    private final long y;

    /**
     * Default constructor of this vector. Constructs a (0L, 0L).
     */
    public Vector2l() {
        this(0L, 0L);
    }

    /**
     * Constructs a two-dimensional vector with given x and y components.
     *
     * @param x x component of this vector.
     * @param y y component of this vector.
     */
    public Vector2l(long x, long y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a new two-dimensional vector from the given two-dimensional vector.
     *
     * @param v that is not null.
     */
    public Vector2l(Vector2l v) {
        this.x = v.x;
        this.y = v.y;
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
    public Vector2l add(Vector2l second) {
        return new Vector2l(this.x + second.x, this.y + second.y);
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
    public Vector2l subtract(Vector2l second) {
        return new Vector2l(this.x - second.x, this.y - second.y);
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
    public Vector2l multiply(Vector2l second) {
        return new Vector2l(this.x * second.x, this.y * second.y);
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
    public Vector2l divide(Vector2l second) {
        if (compNotContainsZero(second.getX(), second.getY())) {
            return new Vector2l(this.x / second.getX(), this.y / second.getY());
        }
        return Vector2.NAN_2L;
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
    public Vector2l multiply_add(Vector2l multiplier, Vector2l adder) {
        return new Vector2l(
                this.x * multiplier.getX() + adder.getX(),
                this.y * multiplier.getY() + adder.getY()
        );
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
    public double cross_product(Vector2l second) {
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
    public Vector2l project(Vector2l second) {
        double length = second.length();
        if (length == 0) {
            return new Vector2l();
        }
        double dotProduct = dot_product(second);
        double scaleFactor = dotProduct / (length * length);
        return second.scale(scaleFactor);
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
    public Vector2l reflect(Vector2l second) {
        if (second.length() == 0) return new Vector2l();
        Vector2l n = second.normalize();
        double dotProduct = dot_product(n);
        Vector2l a = second.scale(dotProduct * 2);
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
    public Vector2l faceForward(Vector2l incident, Vector2l reference) {
        return (incident.dot_product(reference) < 0) ? new Vector2l(this) : new Vector2l(this.scale(-1d));
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
    public double dot_product(Vector2l second) {
        return this.x * second.x + this.y * second.y;
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
    public double distance(Vector2l second) {
        long dx = this.x - second.x;
        long dy = this.y - second.y;
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
        return Math.sqrt(this.x * this.x + this.y * this.y);
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
    public Vector2l scale(double scale) {
        return new Vector2l((long) (x * scale), (long) (y * scale));
    }

    /**
     * Calculate the vector that is the normalized version of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the normalized vector.</p>
     *
     * @return the normalized vector.
     */
    @Override
    public Vector2l normalize() {
        if (this.length() == 0) {
            return new Vector2l();
        }
        return new Vector2l((long) (x / length()), (long) (y / length()));
    }

    /**
     * The entrywise absolute value of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: The entrywise absolute value of itself.</p>
     *
     * @return a new vector2 that contains the entrywise absolute value of itself.
     */
    @Override
    public Vector2l absolute() {
        return new Vector2l(Math.abs(this.x), Math.abs(this.y));
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
    public Vector2l power(double exp) {
        return new Vector2l((long) Math.pow(x, exp), (long) Math.pow(y, exp));
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
    public Vector2l sign() {
        long signX = this.x < 0 ? -1 : x == 0 ? 0 : 1;
        long signY = this.y < 0 ? -1 : y == 0 ? 0 : 1;
        return new Vector2l(signX, signY);
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
    public Vector2l minimum(Vector2l second) {
        return new Vector2l(Math.min(this.x, second.x), Math.min(this.y, second.y));
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
    public Vector2l maximum(Vector2l second) {
        return new Vector2l(Math.max(this.x, second.x), Math.max(this.y, second.y));
    }

    /**
     * Rounds itself entrywise down to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise down to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise down to the nearest integer.
     */
    @Override
    public Vector2l floor() {
        return new Vector2l((long) Math.floor(x), (long) Math.floor(y));
    }

    /**
     * Rounds itself entrywise up to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise up to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise up to the nearest integer.
     */
    @Override
    public Vector2l ceil() {
        return new Vector2l((long) Math.ceil(x), (long) Math.ceil(y));
    }

    /**
     * Returns the fractional part of the value entrywise.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns the fractional part of the value entrywise.</p>
     *
     * @return the fractional part of the value entrywise.
     */
    @Override
    public Vector2l fraction() {
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
    public Vector2l modulo(Vector2l second) {
        if (compNotContainsZero(x, y)) {
            return new Vector2l(
                    (long) (this.x - second.x * Math.floor((double) this.x / second.x)),
                    (long) (this.y - second.y * Math.floor((double) this.y / second.y))
            );
        }
        return Vector2.NAN_2L;
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
    public Vector2l wrap(Vector2l minimum, Vector2l maximum) {
        Vector2l v1 = this.subtract(minimum);
        Vector2l range = maximum.subtract(minimum);
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
    public Vector2l snap(Vector2l second) {
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
    public Vector2l sine() {
        return new Vector2l((long) Math.sin(x), (long) Math.cos(y));
    }

    /**
     * The entrywise of cosine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of cosine of its component</p>
     *
     * @return the entrywise of cosine of itself.
     */
    @Override
    public Vector2l cosine() {
        return new Vector2l((long) Math.cos(x), (long) Math.sin(y));
    }

    /**
     * The entrywise of tangent of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of tangent of its component</p>
     *
     * @return the entrywise of tangent of itself.
     */
    @Override
    public Vector2l tangent() {
        return new Vector2l((long) Math.tan(x), (long) Math.tan(y));
    }

    /**
     * Copy itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a new reference of itself.</p>
     *
     * @return a new reference of itself.
     * @deprecated since 7/21/2026. The constructor of this class already handled copying reference of the instance.
     */
    @Deprecated
    @Override
    public Vector2l copy() {
        return null;
    }

    /**
     * Return a reference of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a reference of itself.</p>
     *
     * @return Return a reference of itself.
     */
    @Override
    public Vector2l getSelf() {
        return new Vector2l(this.x, this.y);
    }

    @Override
    public int compareTo(Vector2l vector2l) {
        if (this.x != vector2l.getX()) {
            return Long.compare(this.x, vector2l.getX());
        }
        if (this.y != vector2l.getY()) {
            return Long.compare(this.y, vector2l.getY());
        }
        return (this.getX() == vector2l.getX())
                ? 0
                : Double.compare(this.length(), vector2l.length());
    }

    @Override
    public int compare(Vector2l vector2l, Vector2l t1) {
        return vector2l.compareTo(t1);
    }

    /**
     * Accessor of the x component.
     *
     * @return the value of x component.
     */
    public long getX() {
        return x;
    }

    /**
     * Accessor of the y component.
     *
     * @return the value of y component.
     */
    public long getY() {
        return y;
    }

    @Override
    public String toString() {
        return "<" + x + ", " + y + ">";
    }

    /**
     * Rotate the vector in given angle around the origin.
     *
     * @param angle given angle in radians.
     * @return the rotated vector.
     * @since 7/24/2026 part of Transformation & Circles Update.
     */
    @Deprecated
    @Override
    public Vector2l rotate(Radian angle) {
        return null;
    }
}
