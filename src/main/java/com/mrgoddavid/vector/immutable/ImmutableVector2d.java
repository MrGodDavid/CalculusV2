package com.mrgoddavid.vector.immutable;

import com.mrgoddavid.geometry.angle.Radian;
import com.mrgoddavid.matrix.FixedMatrix;
import com.mrgoddavid.transformation.rotation.RotationMatrix2x2;
import com.mrgoddavid.vector.Vector.ImmutableVector2;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Custom 2d vector class. Parameters are double variable.
 *
 * @author Mr. GodDavid
 * @since 3/16/2026
 */
public class ImmutableVector2d implements ImmutableVector2<ImmutableVector2d>, Comparable<ImmutableVector2d>, Comparator<ImmutableVector2d>, Serializable {

    /**
     * Zero vector of this class.
     */
    public static final ImmutableVector2d ZERO = new ImmutableVector2d();

    /**
     * Unit vector along x-axis. We define this unit vector as i.
     */
    public static final ImmutableVector2d UNIT_I = new ImmutableVector2d(1.0, 0.0);

    /**
     * Unit vector along y-axis. We define this unit vector as j.
     */
    public static final ImmutableVector2d UNIT_J = new ImmutableVector2d(0.0, 1.0);

    @Serial
    private static final long serialVersionUID = 5398093862957521446L;

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
    public ImmutableVector2d() {
        this.x = 0d;
        this.y = 0d;
    }

    /**
     * Constructs a two-dimensional vector with given x and y components.
     *
     * @param x component of this vector.
     * @param y component of this vector.
     */
    public ImmutableVector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a new two-dimensional vector from the given two-dimensional vector.
     *
     * @param v that is not null.
     */
    public ImmutableVector2d(ImmutableVector2d v) {
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
    public ImmutableVector2d add(ImmutableVector2d second) {
        return new ImmutableVector2d(x + second.x, y + second.y);
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
    public ImmutableVector2d subtract(ImmutableVector2d second) {
        return new ImmutableVector2d(x - second.x, y - second.y);
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
    public ImmutableVector2d multiply(ImmutableVector2d second) {
        return new ImmutableVector2d(x * second.x, y * second.y);
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
    public ImmutableVector2d divide(ImmutableVector2d second) {
        if (compNotContainsZero(second.getX(), second.getY())) {
            return new ImmutableVector2d(x / second.x, y / second.y);
        }
        return ImmutableVector2.NAN_2D;
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
    public ImmutableVector2d multiply_add(ImmutableVector2d multiplier, ImmutableVector2d adder) {
        double newX = x * multiplier.x + adder.x;
        double newY = y * multiplier.y + adder.y;
        return new ImmutableVector2d(newX, newY);
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
    public double cross_product(ImmutableVector2d second) {
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
    public ImmutableVector2d project(ImmutableVector2d second) {
        double length = second.length();
        if (length == 0) {
            return new ImmutableVector2d();
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
    public ImmutableVector2d reflect(ImmutableVector2d second) {
        if (second.length() == 0) return new ImmutableVector2d();
        ImmutableVector2d n = second.normalize();
        double dotProduct = dot_product(n);
        ImmutableVector2d a = second.scale(dotProduct * 2);
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
    public ImmutableVector2d faceForward(ImmutableVector2d incident, ImmutableVector2d reference) {
        return (incident.dot_product(reference) < 0) ? new ImmutableVector2d(this) : new ImmutableVector2d(this.scale(-1d));
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
    public double dot_product(ImmutableVector2d second) {
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
    public double distance(ImmutableVector2d second) {
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
    public ImmutableVector2d scale(double scale) {
        return new ImmutableVector2d(x * scale, y * scale);
    }

    /**
     * Calculate the vector that is the normalized version of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the normalized vector.</p>
     *
     * @return the normalized vector.
     */
    @Override
    public ImmutableVector2d normalize() {
        if (length() == 0) {
            return new ImmutableVector2d();
        }
        return new ImmutableVector2d(x / length(), y / length());
    }

    /**
     * The entrywise absolute value of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: The entrywise absolute value of itself.</p>
     *
     * @return a new vector2 that contains the entrywise absolute value of itself.
     */
    @Override
    public ImmutableVector2d absolute() {
        return new ImmutableVector2d(Math.abs(x), Math.abs(y));
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
    public ImmutableVector2d power(double exp) {
        return new ImmutableVector2d(Math.pow(x, exp), Math.pow(y, exp));
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
    public ImmutableVector2d sign() {
        double signX = x > 0 ? 1 : x == 0 ? 0 : -1;
        double signY = y > 0 ? 1 : y == 0 ? 0 : -1;
        return new ImmutableVector2d(signX, signY);
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
    public ImmutableVector2d minimum(ImmutableVector2d second) {
        return new ImmutableVector2d(Math.min(x, second.x), Math.min(y, second.y));
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
    public ImmutableVector2d maximum(ImmutableVector2d second) {
        return new ImmutableVector2d(Math.max(x, second.x), Math.max(y, second.y));
    }

    /**
     * Rounds itself entrywise down to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise down to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise down to the nearest integer.
     */
    @Override
    public ImmutableVector2d floor() {
        return new ImmutableVector2d(Math.floor(x), Math.floor(y));
    }

    /**
     * Rounds itself entrywise up to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise up to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise up to the nearest integer.
     */
    @Override
    public ImmutableVector2d ceil() {
        return new ImmutableVector2d(Math.ceil(x), Math.ceil(y));
    }

    /**
     * Returns the fractional part of the value entrywise.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns the fractional part of the value entrywise.</p>
     *
     * @return the fractional part of the value entrywise.
     */
    @Override
    public ImmutableVector2d fraction() {
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
    public ImmutableVector2d modulo(ImmutableVector2d second) {
        if (compNotContainsZero(x, y)) {
            return new ImmutableVector2d(
                    this.x - second.x * Math.floor(this.x / second.x),
                    this.y - second.y * Math.floor(this.y / second.y)
            );
        }
        return ImmutableVector2.NAN_2D;
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
    public ImmutableVector2d wrap(ImmutableVector2d minimum, ImmutableVector2d maximum) {
        ImmutableVector2d v1 = this.subtract(minimum);
        ImmutableVector2d range = maximum.subtract(minimum);
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
    public ImmutableVector2d snap(ImmutableVector2d second) {
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
    public ImmutableVector2d sine() {
        return new ImmutableVector2d(Math.sin(x), Math.sin(y));
    }

    /**
     * The entrywise of cosine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of cosine of its component</p>
     *
     * @return the entrywise of cosine of itself.
     */
    @Override
    public ImmutableVector2d cosine() {
        return new ImmutableVector2d(Math.cos(x), Math.cos(y));
    }

    /**
     * The entrywise of tangent of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of tangent of its component</p>
     *
     * @return the entrywise of tangent of itself.
     */
    @Override
    public ImmutableVector2d tangent() {
        return new ImmutableVector2d(Math.tan(x), Math.tan(y));
    }

    @Override
    public ImmutableVector2d getSelf() {
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
    public ImmutableVector2d copy() {
        return new ImmutableVector2d(x, y);
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
    public int compareTo(ImmutableVector2d o) {
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
    public int compare(ImmutableVector2d o1, ImmutableVector2d o2) {
        return o1.compareTo(o2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableVector2d vector2d = (ImmutableVector2d) o;
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

    /**
     * Convert two-dimensional vector to column vector.
     *
     * @return the column vector of this vector.
     */
    FixedMatrix.Matrix21d transpose() {
        return new FixedMatrix.Matrix21d(this.x, this.y);
    }

    /**
     * Rotate the vector in given angle around the origin.
     *
     * @param angle given angle in radians.
     * @return the rotated vector.
     * @since 7/24/2026 part of Transformation &amp; Circles Update.
     */
    @Override
    public ImmutableVector2d rotate(Radian angle) {
        return RotationMatrix2x2.getInstance().atAngle(angle).multiply(this.transpose()).transpose();
    }
}
