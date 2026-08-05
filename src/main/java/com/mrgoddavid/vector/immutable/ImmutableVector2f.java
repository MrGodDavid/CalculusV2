package com.mrgoddavid.vector.immutable;

import com.mrgoddavid.geometry.angle.Radian;
import com.mrgoddavid.vector.ImmutableVector2;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

/**
 * This class defines a two-dimensional vector that each coordinate is a float number.
 *
 * @author Mr. GodDavid
 * @since 7/21/2026 added this class.
 */
@SuppressWarnings("ClassCanBeRecord")
public class ImmutableVector2f implements ImmutableVector2<ImmutableVector2f>, Comparator<ImmutableVector2f>, Comparable<ImmutableVector2f>, Serializable {

    /**
     * Zero vector of this class.
     */
    public static final ImmutableVector2f ZERO = new ImmutableVector2f();

    /**
     * Unit vector along x-axis. We define this unit vector as i.
     */
    public static final ImmutableVector2f UNIT_I = new ImmutableVector2f(1f, 0f);

    /**
     * Unit vector along y-axis. We define this unit vector as j.
     */
    public static final ImmutableVector2f UNIT_J = new ImmutableVector2f(0f, 1f);

    @Serial
    private static final long serialVersionUID = -8437451757794676567L;

    /**
     * X component of this vector.
     */
    private final float x;

    /**
     * Y component of this vector.
     */
    private final float y;

    /**
     * Default constructor of Vector2f.
     */
    public ImmutableVector2f() {
        this(0f, 0f);
    }

    /**
     * Constructs a two-dimensional vector with given x and y components.
     *
     * @param x component of this vector.
     * @param y component of this vector.
     */
    public ImmutableVector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a new two-dimensional vector from the given two-dimensional vector.
     *
     * @param vector that is not null.
     */
    public ImmutableVector2f(ImmutableVector2f vector) {
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
    public ImmutableVector2f add(ImmutableVector2f second) {
        return new ImmutableVector2f(this.x + second.x, this.y + second.y);
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
    public ImmutableVector2f subtract(ImmutableVector2f second) {
        return new ImmutableVector2f(this.x - second.x, this.y - second.y);
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
    public ImmutableVector2f multiply(ImmutableVector2f second) {
        return new ImmutableVector2f(this.x * second.x, this.y * second.y);
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
    public ImmutableVector2f divide(ImmutableVector2f second) {
        if (compNotContainsZero(x, y)) {
            return new ImmutableVector2f(this.x / second.x, this.y / second.y);
        }
        return ImmutableVector2.NAN_2F;
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
    public ImmutableVector2f multiply_add(ImmutableVector2f multiplier, ImmutableVector2f adder) {
        return new ImmutableVector2f(
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
    public double cross_product(ImmutableVector2f second) {
        return this.x * second.y - this.y * second.x;
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
    public ImmutableVector2f project(ImmutableVector2f second) {
        double length = second.length();
        if (length == 0) {
            return new ImmutableVector2f();
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
    public ImmutableVector2f reflect(ImmutableVector2f second) {
        if (second.length() == 0) return new ImmutableVector2f();
        ImmutableVector2f n = second.normalize();
        double dotProduct = dot_product(n);
        ImmutableVector2f a = second.scale(dotProduct * 2);
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
    public ImmutableVector2f faceForward(ImmutableVector2f incident, ImmutableVector2f reference) {
        return (incident.dot_product(reference) < 0) ? new ImmutableVector2f(this) : new ImmutableVector2f(this.scale(-1d));
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
    public double dot_product(ImmutableVector2f second) {
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
    public double distance(ImmutableVector2f second) {
        double dx = this.x - second.x;
        double dy = this.y - second.y;
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
    public ImmutableVector2f scale(double scale) {
        return new ImmutableVector2f((float) (this.x * scale), (float) (this.y * scale));
    }

    /**
     * Calculate the vector that is the normalized version of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the normalized vector.</p>
     *
     * @return the normalized vector.
     */
    @Override
    public ImmutableVector2f normalize() {
        if (this.length() == 0) {
            return new ImmutableVector2f();
        }
        return new ImmutableVector2f((float) (this.x / this.length()), (float) (this.y / this.length()));
    }

    /**
     * The entrywise absolute value of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: The entrywise absolute value of itself.</p>
     *
     * @return a new vector2 that contains the entrywise absolute value of itself.
     */
    @Override
    public ImmutableVector2f absolute() {
        return new ImmutableVector2f(Math.abs(this.x), Math.abs(this.y));
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
    public ImmutableVector2f power(double exp) {
        return new ImmutableVector2f((float) Math.pow(this.x, exp), (float) Math.pow(this.y, exp));
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
    public ImmutableVector2f sign() {
        float signX = this.x < 0f ? 1 : this.x == 0f ? 0 : -1;
        float signY = this.y < 0f ? 1 : this.y == 0f ? 0 : -1;
        return new ImmutableVector2f(signX, signY);
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
    public ImmutableVector2f minimum(ImmutableVector2f second) {
        return new ImmutableVector2f(Math.min(this.x, second.x), Math.min(this.y, second.y));
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
    public ImmutableVector2f maximum(ImmutableVector2f second) {
        return new ImmutableVector2f(Math.max(this.x, second.x), Math.max(this.y, second.y));
    }

    /**
     * Rounds itself entrywise down to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise down to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise down to the nearest integer.
     */
    @Override
    public ImmutableVector2f floor() {
        return new ImmutableVector2f((float) Math.floor(this.x), (float) Math.floor(this.y));
    }

    /**
     * Rounds itself entrywise up to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise up to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise up to the nearest integer.
     */
    @Override
    public ImmutableVector2f ceil() {
        return new ImmutableVector2f((float) Math.ceil(this.x), (float) Math.ceil(this.y));
    }

    /**
     * Returns the fractional part of the value entrywise.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns the fractional part of the value entrywise.</p>
     *
     * @return the fractional part of the value entrywise.
     */
    @Override
    public ImmutableVector2f fraction() {
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
    public ImmutableVector2f modulo(ImmutableVector2f second) {
        if (compNotContainsZero(x, y)) {
            return new ImmutableVector2f(
                    (float) (this.x - second.x * Math.floor(this.x / second.x)),
                    (float) (this.y - second.y * Math.floor(this.y / second.y))
            );
        }
        return ImmutableVector2.NAN_2F;
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
    public ImmutableVector2f wrap(ImmutableVector2f minimum, ImmutableVector2f maximum) {
        ImmutableVector2f v1 = this.subtract(minimum);
        ImmutableVector2f range = maximum.subtract(minimum);
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
    public ImmutableVector2f snap(ImmutableVector2f second) {
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
    public ImmutableVector2f sine() {
        return new ImmutableVector2f((float) Math.sin(this.y), (float) Math.cos(this.y));
    }

    /**
     * The entrywise of cosine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of cosine of its component</p>
     *
     * @return the entrywise of cosine of itself.
     */
    @Override
    public ImmutableVector2f cosine() {
        return new ImmutableVector2f((float) Math.cos(this.y), (float) Math.sin(this.y));
    }

    /**
     * The entrywise of tangent of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of tangent of its component</p>
     *
     * @return the entrywise of tangent of itself.
     */
    @Override
    public ImmutableVector2f tangent() {
        return new ImmutableVector2f((float) Math.tan(this.y), (float) Math.tan(this.y));
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
    public ImmutableVector2f copy() {
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
    public ImmutableVector2f getSelf() {
        return new ImmutableVector2f(this.x, this.y);
    }

    @Override
    public int compareTo(ImmutableVector2f o) {
        if (this.x != o.getX()) {
            return Float.compare(this.x, o.getX());
        }
        if (this.y != o.getY()) {
            return Float.compare(this.y, o.getY());
        }
        return (this.getX() == o.getX())
                ? 0
                : Double.compare(this.length(), o.length());
    }

    @Override
    public int compare(ImmutableVector2f vector2f, ImmutableVector2f t1) {
        return vector2f.compareTo(t1);
    }

    /**
     * Accessor of the x component.
     *
     * @return the value of x component.
     */
    public float getX() {
        return x;
    }

    /**
     * Accessor of the y component.
     *
     * @return the value of y component.
     */
    public float getY() {
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
     * @since 7/24/2026 part of Transformation &amp; Circles Update.
     */
    @Deprecated
    @Override
    public ImmutableVector2f rotate(Radian angle) {
        return null;
    }
}
