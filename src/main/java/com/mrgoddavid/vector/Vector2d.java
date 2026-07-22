package com.mrgoddavid.vector;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Custom 2d vector class. Parameters are double variable.
 *
 * @author Mr. GodDavid
 * @since 3/16/2026
 */
public class Vector2d implements Vector2<Vector2d>, Comparable<Vector2d>, Comparator<Vector2d>, Serializable {

    /**
     * X component of this vector.
     */
    private double x;
    /**
     * Y component of this vector.
     */
    private double y;

    /**
     * Default constructor of Vector2d.
     */
    public Vector2d() {
        this.x = 0d;
        this.y = 0d;
    }

    /**
     * Constructs a two-dimensional vector with given x and y components.
     *
     * @param x component of this vector.
     * @param y component of this vector.
     */
    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a new two-dimensional vector from the given two-dimensional vector.
     *
     * @param v that is not null.
     */
    public Vector2d(Vector2d v) {
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
    public Vector2d add(Vector2d second) {
        return new Vector2d(x + second.x, y + second.y);
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
    public Vector2d subtract(Vector2d second) {
        return new Vector2d(x - second.x, y - second.y);
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
    public Vector2d multiply(Vector2d second) {
        return new Vector2d(x * second.x, y * second.y);
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
    public Vector2d divide(Vector2d second) {
        if (compNotContainsZero(second.getX(), second.getY())) {
            return new Vector2d(x / second.x, y / second.y);
        }
        return Vector2.NAN_2D;
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
    public Vector2d multiply_add(Vector2d multiplier, Vector2d adder) {
        double newX = x * multiplier.x + adder.x;
        double newY = y * multiplier.y + adder.y;
        return new Vector2d(newX, newY);
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
    public double cross_product(Vector2d second) {
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
    public Vector2d project(Vector2d second) {
        double length = second.length();
        if (length == 0) {
            return new Vector2d();
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
    public Vector2d reflect(Vector2d second) {
        if (second.length() == 0) return new Vector2d();
        Vector2d n = second.normalize();
        double dotProduct = dot_product(n);
        Vector2d a = second.scale(dotProduct * 2);
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
    public Vector2d faceForward(Vector2d incident, Vector2d reference) {
        return (incident.dot_product(reference) < 0) ? new Vector2d(this) : new Vector2d(this.scale(-1d));
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
    public double dot_product(Vector2d second) {
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
    public double distance(Vector2d second) {
        double dx = x - second.x;
        double dy = y - second.y;
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
    public Vector2d scale(double scale) {
        return new Vector2d(x * scale, y * scale);
    }

    /**
     * Calculate the vector that is the normalized version of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the normalized vector.</p>
     *
     * @return the normalized vector.
     */
    @Override
    public Vector2d normalize() {
        if (length() == 0) {
            return new Vector2d();
        }
        return new Vector2d(x / length(), y / length());
    }

    /**
     * The entrywise absolute value of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: The entrywise absolute value of itself.</p>
     *
     * @return a new vector2 that contains the entrywise absolute value of itself.
     */
    @Override
    public Vector2d absolute() {
        return new Vector2d(Math.abs(x), Math.abs(y));
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
    public Vector2d power(double exp) {
        return new Vector2d(Math.pow(x, exp), Math.pow(y, exp));
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
    public Vector2d sign() {
        double signX = x > 0 ? 1 : x == 0 ? 0 : -1;
        double signY = y > 0 ? 1 : y == 0 ? 0 : -1;
        return new Vector2d(signX, signY);
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
    public Vector2d minimum(Vector2d second) {
        return new Vector2d(Math.min(x, second.x), Math.min(y, second.y));
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
    public Vector2d maximum(Vector2d second) {
        return new Vector2d(Math.max(x, second.x), Math.max(y, second.y));
    }

    /**
     * Rounds itself entrywise down to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise down to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise down to the nearest integer.
     */
    @Override
    public Vector2d floor() {
        return new Vector2d(Math.floor(x), Math.floor(y));
    }

    /**
     * Rounds itself entrywise up to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise up to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise up to the nearest integer.
     */
    @Override
    public Vector2d ceil() {
        return new Vector2d(Math.ceil(x), Math.ceil(y));
    }

    /**
     * Returns the fractional part of the value entrywise.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns the fractional part of the value entrywise.</p>
     *
     * @return the fractional part of the value entrywise.
     */
    @Override
    public Vector2d fraction() {
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
    public Vector2d modulo(Vector2d second) {
        return new Vector2d(
                this.x - second.x * Math.floor(this.x / second.x),
                this.y - second.y * Math.floor(this.y / second.y)
        );
    }

    /**
     * The entrywise output of a value between Min and Max based on the absolute difference between the input value
     * and the nearest integer multiple of Max less than the value.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a new vector that is entrywise wrapped for each its component.</p>
     *
     * @param minimum  minimum threshold.
     * @param maximum: maximum threshold.
     * @return a new vector that is entrywise wrapped for each its component.
     */
    @Override
    public Vector2d wrap(Vector2d minimum, Vector2d maximum) {
        Vector2d v1 = this.subtract(minimum);
        Vector2d range = maximum.subtract(minimum);
        return this.subtract(range.multiply(v1.divide(range)).floor());
    }

    /**
     * The result of rounding itself to the largest integer multiple of B less than or equal itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a new vector that is entrywise snapped for each its component.</p>
     *
     * @return a new vector that is entrywise snapped for each its component.
     */
    @Override
    public Vector2d snap(Vector2d second) {
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
    public Vector2d sine() {
        return new Vector2d(Math.sin(x), Math.sin(y));
    }

    /**
     * The entrywise of cosine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of cosine of its component</p>
     *
     * @return the entrywise of cosine of itself.
     */
    @Override
    public Vector2d cosine() {
        return new Vector2d(Math.cos(x), Math.cos(y));
    }

    /**
     * The entrywise of tangent of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of tangent of its component</p>
     *
     * @return the entrywise of tangent of itself.
     */
    @Override
    public Vector2d tangent() {
        return new Vector2d(Math.tan(x), Math.tan(y));
    }

    @Override
    public Vector2d getSelf() {
        return this;
    }

    /**
     * Copy itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a new reference of itself.</p>
     *
     * @return a new reference of itself.
     */
    @Override
    public Vector2d copy() {
        return new Vector2d(x, y);
    }

    @Override
    public String toString() {
        return "<" + x + ", " + y + ">";
    }

    /**
     * Accessor of the x component.
     *
     * @return the value of x component.
     */
    public double getX() {
        return x;
    }

    /**
     * Accessor of the y component.
     *
     * @return the value of y component.
     */
    public double getY() {
        return y;
    }

    @Override
    public int compareTo(Vector2d o) {
        if (this.x != o.getX()) {
            return Double.compare(x, o.getX());
        }
        if (this.y != o.getY()) {
            return Double.compare(this.y, o.getY());
        }
        return (this.x == o.getX() && this.y == o.getY())
                ? 0
                : Double.compare(this.length(), o.length());
    }

    @Override
    public int compare(Vector2d o1, Vector2d o2) {
        return o1.compareTo(o2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Mutator of this class. Changes x and y values of this class.
     *
     * @param x component of two-dimensional vector.
     * @param y component of two-dimensional vector.
     * @deprecated since 7/14/2026 enhancing encapsulation of this class.
     */
    @Deprecated
    public void setValues(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
