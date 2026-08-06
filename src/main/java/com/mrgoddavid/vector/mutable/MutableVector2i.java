package com.mrgoddavid.vector.mutable;

import com.mrgoddavid.vector.MutableVector;
import com.mrgoddavid.vector.immutable.ImmutableVector2i;

import java.io.Serial;

/**
 * Mutable two-dimensional vector that each component is an integer.
 *
 * @author Mr. GodDavid
 * @since 8/6/2026
 */
public class MutableVector2i implements MutableVector.MutableVector2ic<MutableVector2i> {

    @Serial
    private static final long serialVersionUID = -9003114925453526658L;

    /**
     * x component of this vector.
     */
    public int x;
    /**
     * y component of this vector.
     */
    public int y;

    /**
     * Default constructor. Create a new (0, 0) two-dimensional vector.
     */
    public MutableVector2i() {
        this(0, 0);
    }

    /**
     * Constructs a mutable two-dimensional vector which each component is an integer with the given x and y component.
     *
     * @param x the given x component of this vector.
     * @param y the given y component of this vector.
     */
    public MutableVector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Accessor of the x component of mutable Vector2i.
     *
     * @return the value of the x component of mutable Vector2i.
     */
    @Override
    public int x() {
        return x;
    }

    /**
     * Accessor of the y component of mutable Vector2i.
     *
     * @return the value of the y component of mutable Vector2i.
     */
    @Override
    public int y() {
        return y;
    }

    /**
     * Mutator of the x and y field of this vector.
     *
     * @param x new x.
     * @param y new y.
     */
    @Override
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Performs entry addition of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the sum of two vectors.</p>
     *
     * @param second vector that is not null.
     */
    @Override
    public void add(MutableVector2i second) {
        this.x += second.x;
        this.y += second.y;
    }

    /**
     * Performs entry subtraction of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the difference between two vectors.</p>
     *
     * @param second vector that is not null.
     */
    @Override
    public void subtract(MutableVector2i second) {
        this.x -= second.x;
        this.y -= second.y;
    }

    /**
     * Performs entry multiplication of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the product of two vectors.</p>
     *
     * @param second vector that is not null.
     */
    @Override
    public void multiply(MutableVector2i second) {
        this.x *= second.x;
        this.y *= second.y;
    }

    /**
     * Performs entry division of two vectors.
     * <p>Precondition: second vector is not null and its component does not contain 0.</p>
     * <p>Postcondition: returns the quotient of two vectors.</p>
     *
     * @param second vector that is not null.
     */
    @Override
    public void divide(MutableVector2i second) {
        if (second.x != 0) {
            this.x /= second.x;
            this.y /= second.y;
        }
    }

    /**
     * Performs entry multiplication and then addition of a vector itself.
     * <p>Precondition: multiplier vector and adder vector are not null.</p>
     * <p>Postcondition: returns the vector that is  multiplied multiplier vector and by  of two vectors.</p>
     *
     * @param multiplier vector that is not null.
     * @param adder      vector that is not null.
     */
    @Override
    public void multiply_add(MutableVector2i multiplier, MutableVector2i adder) {
        this.x = multiplier.x * this.x + adder.x;
        this.y = multiplier.y * this.y + adder.y;
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
    public double cross_product(MutableVector2i second) {
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
    public MutableVector2i project(MutableVector2i second) {
        ImmutableVector2i result = enhance().project(second.enhance());
        return new MutableVector2i(result.getX(), result.getY());
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
    public MutableVector2i reflect(MutableVector2i second) {
        ImmutableVector2i reflected = enhance().reflect(second.enhance());
        return new MutableVector2i(reflected.getX(), reflected.getY());
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
    public MutableVector2i faceForward(MutableVector2i incident, MutableVector2i reference) {
        ImmutableVector2i immutableVector2i = enhance().faceForward(incident.enhance(), reference.enhance());
        return new MutableVector2i(immutableVector2i.getX(), immutableVector2i.getY());
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
    public double dot_product(MutableVector2i second) {
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
    public double distance(MutableVector2i second) {
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
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Entry scale each component by a scale factor.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the scaled vector.</p>
     *
     * @param scale scaling factor.
     */
    @Override
    public void scale(double scale) {
        this.x *= scale;
        this.y *= scale;
    }

    /**
     * Calculate the vector that is the normalized version of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the normalized vector.</p>
     *
     */
    @Override
    public MutableVector2i normalize() {
        ImmutableVector2i v = enhance().normalize();
        return new MutableVector2i(v.getX(), v.getY());
    }

    /**
     * The entrywise absolute value of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: The entrywise absolute value of itself.</p>
     *
     */
    @Override
    public void absolute() {
        this.x = Math.abs(x);
        this.y = Math.abs(y);
    }

    /**
     * The entrywise power operator where the Base raised to the power of Exponent.
     * <p>Precondition: none.</p>
     * <p>Postcondition: The entrywise power operator where the Base raised to the power of Exponent.</p>
     *
     * @param exp the power exponent.
     */
    @Override
    public void power(double exp) {
        this.x = (int) Math.pow(x, exp);
        this.y = (int) Math.pow(x, exp);
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
    public MutableVector2i sign() {
        int signX = this.x < 0 ? -1 : 1;
        int signY = this.y < 0 ? -1 : 1;
        return new MutableVector2i(signX, signY);
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
    public MutableVector2i minimum(MutableVector2i second) {
        return new MutableVector2i(
                Math.min(x, second.x()),
                Math.min(y, second.y())
        );
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
    public MutableVector2i maximum(MutableVector2i second) {
        return new MutableVector2i(
                Math.max(x, second.x()),
                Math.max(y, second.y())
        );
    }

    /**
     * Rounds itself entrywise down to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise down to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise down to the nearest integer.
     */
    @Override
    public MutableVector2i floor() {
        return new MutableVector2i(x, y);
    }

    /**
     * Rounds itself entrywise up to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise up to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise up to the nearest integer.
     */
    @Override
    public MutableVector2i ceil() {
        return new MutableVector2i(x, y);
    }

    /**
     * Returns the fractional part of the value entrywise.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns the fractional part of the value entrywise.</p>
     *
     * @return the fractional part of the value entrywise.
     */
    @Override
    public MutableVector2i fraction() {
        return new MutableVector2i();
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
    public MutableVector2i modulo(MutableVector2i second) {
        return new MutableVector2i(x % second.x, y % second.y);
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
    public MutableVector2i wrap(MutableVector2i minimum, MutableVector2i maximum) {
        ImmutableVector2i v = enhance().wrap(minimum.enhance(), maximum.enhance());
        return new MutableVector2i(v.getX(), v.getY());
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
    public MutableVector2i snap(MutableVector2i second) {
        ImmutableVector2i v = enhance().snap(second.enhance());
        return new MutableVector2i(v.getX(), v.getY());
    }

    /**
     * The entrywise of sine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of sine of its component</p>
     *
     */
    @Override
    public void sine() {
        this.x = (int) Math.sin(x);
        this.y = (int) Math.sin(x);
    }

    /**
     * The entrywise of cosine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of cosine of its component</p>
     *
     */
    @Override
    public void cosine() {
        this.x = (int) Math.cos(x);
        this.y = (int) Math.cos(x);
    }

    /**
     * The entrywise of tangent of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of tangent of its component</p>
     *
     */
    @Override
    public void tangent() {
        this.x = (int) Math.tan(x);
        this.y = (int) Math.tan(x);
    }

    /**
     * Return a reference of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a reference of itself.</p>
     *
     * @return Return a reference of itself.
     */
    @Override
    public MutableVector2i getSelf() {
        return new MutableVector2i(x, y);
    }
}
