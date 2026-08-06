package com.mrgoddavid.vector.immutable;

import com.mrgoddavid.matrix.Matrix3d;
import com.mrgoddavid.vector.Vector.ImmutableVector3;

import java.io.Serial;

/**
 * Three-dimensional vector. Each component of this vector is integer.
 *
 * @author Mr. GodDavid
 * @since 7/13/2026
 */
public class ImmutableVector3d implements ImmutableVector3<ImmutableVector3d> {

    /**
     * Zero vector of this class.
     */
    public static final ImmutableVector3d ZERO = new ImmutableVector3d();

    /**
     * Unit vector along x-axis. We define this unit vector as i.
     */
    public static final ImmutableVector3d UNIT_I = new ImmutableVector3d(1.0, 0.0, 0.0);

    /**
     * Unit vector along y-axis. We define this unit vector as j.
     */
    public static final ImmutableVector3d UNIT_J = new ImmutableVector3d(0.0, 1.0, 0.0);

    /**
     * Unit vector along z-axis. We define this unit vector as k.
     */
    public static final ImmutableVector3d UNIT_K = new ImmutableVector3d(0.0, 0.0, 1.0);

    @Serial
    private static final long serialVersionUID = -4489172891660242447L;

    /**
     * X coordinate of this vector.
     */
    private final double x;
    /**
     * Y coordinate of this vector.
     */
    private final double y;
    /**
     * Z coordinate of this vector.
     */
    private final double z;

    /**
     * Default constructor.
     */
    public ImmutableVector3d() {
        this(0, 0, 0);
    }

    /**
     * Constructs a three-dimensional vector from the given x, y, and z coordinates.
     *
     * @param x coordinate of the vector.
     * @param y coordinate of the vector.
     * @param z coordinate of the vector.
     */
    public ImmutableVector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs a three-dimensional vector from the parameter.
     *
     * @param vector that is not null.
     */
    public ImmutableVector3d(ImmutableVector3i vector) {
        this.x = vector.getX();
        this.y = vector.getY();
        this.z = vector.getZ();
    }

    /**
     * Calculate the cross product of two three-dimensional vectors.
     *
     * @param other three-dimensional vector that is not null.
     * @return the cross product of two three-dimensional vectors.
     */
    @Override
    public ImmutableVector3d crossProduct(ImmutableVector3d other) {
        Matrix3d matrix3VD = new Matrix3d(-999, -999, -999, this.x, this.y, this.z, other.x, other.y, other.z);
        return matrix3VD.determinantToVector();
    }

    /**
     * Calculates the cross product of two three-dimensional vectors. This method simplifies the result by dividing it
     * by the greatest common factor of three components.
     *
     * @param other    three-dimensional vector that is not null.
     * @param simplify a boolean key allows user to choose whether to simplify the cross product or not.
     * @return the simplified cross product if {@code simplify = true} and original cross product if {@code simplify = false}
     * @since 7/10/2026 added this method.
     */
    public ImmutableVector3d crossProduct(ImmutableVector3d other, boolean simplify) {
        ImmutableVector3d cross_product = this.crossProduct(other);
        if (simplify) {
            int gcf = findGCF((int) cross_product.x, (int) cross_product.y, (int) cross_product.z);
            cross_product = cross_product.scale(1d / gcf);
        }
        return cross_product;
    }

    /**
     * Calculates the greatest common factor (GCF) of three integers via Euclidean Algorithm. First calculate the GCF of
     * the first and second integer, then calculate the GCF of the first and second and third integer.
     *
     * @param a is the first integer.
     * @param b is the second integer.
     * @param c is the third integer.
     * @return the greatest common factor of a, b, and c.
     * @since 7/10/2026 added this method.
     */
    private int findGCF(int a, int b, int c) {
        return doFindGCF(doFindGCF(a, b), c);
    }

    /**
     * Calculates the greatest common factor (GCF) of three integers via Euclidean Algorithm.
     *
     * @param a is the first integer.
     * @param b is the second integer.
     * @return the GCF of a and b.
     */
    private int doFindGCF(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return doFindGCF(b, a % b);
        }
    }

    /**
     * Find the length of the shadow of itself on the second three-dimensional vector.
     *
     * @param second three-dimensional vector that is not null.
     * @return the scalar projection of itself on the second vector.
     * @since 7/10/2026 added this method.
     */
    @Override
    public double scalar_projection(ImmutableVector3d second) {
        return this.dot_product(second) / second.length();
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
    public ImmutableVector3d add(ImmutableVector3d second) {
        return new ImmutableVector3d(this.x + second.x, this.y + second.y, this.z + second.z);
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
    public ImmutableVector3d subtract(ImmutableVector3d second) {
        return new ImmutableVector3d(this.x - second.x, this.y - second.y, this.z - second.z);
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
    public ImmutableVector3d multiply(ImmutableVector3d second) {
        return new ImmutableVector3d(this.x * second.x, this.y * second.y, this.z * second.z);
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
    public ImmutableVector3d divide(ImmutableVector3d second) {
        if (containsZero(second)) {
            System.err.println("Vector3i" + second + "contains zero!");
            return new ImmutableVector3d(0, 0, 0);
        }
        return new ImmutableVector3d(x / second.x, y / second.y, z / second.z);
    }

    private boolean containsZero(ImmutableVector3d vector) {
        return vector.x == 0 || vector.y == 0 || vector.z == 0;
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
    public ImmutableVector3d multiply_add(ImmutableVector3d multiplier, ImmutableVector3d adder) {
        double x = this.x * multiplier.x + adder.x;
        double y = this.y * multiplier.y + adder.y;
        double z = this.z * multiplier.z + adder.z;
        return new ImmutableVector3d(x, y, z);
    }

    /**
     * Performs the cross product of this vector to the second vector.
     * <p>Precondition: second input vector is not null.</p>
     * <p>Postcondition: calculate the cross product of itself to the second input vector.</p>
     *
     * @param second vector that is not null.
     * @return the cross product of itself to the second input vector.
     */
    @Deprecated
    @Override
    public double cross_product(ImmutableVector3d second) {
        return -999;
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
    public ImmutableVector3d project(ImmutableVector3d second) {
        return null;
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
    public ImmutableVector3d reflect(ImmutableVector3d second) {
        return null;
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
    public ImmutableVector3d faceForward(ImmutableVector3d incident, ImmutableVector3d reference) {
        return null;
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
    public double dot_product(ImmutableVector3d second) {
        return second.x * this.x + second.y * this.y + second.z * this.z;
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
    public double distance(ImmutableVector3d second) {
        double dx = Math.abs(second.x - this.x);
        double dy = Math.abs(second.y - this.y);
        double dz = Math.abs(second.z - this.z);
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
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
        return Math.sqrt(x * x + y * y + z * z);
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
    public ImmutableVector3d scale(double scale) {
        return new ImmutableVector3d(x * scale, y * scale, z * scale);
    }

    /**
     * Calculate the vector that is the normalized version of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the normalized vector.</p>
     *
     * @return the normalized vector.
     */
    @Override
    public ImmutableVector3d normalize() {
        return length() == 0 ? new ImmutableVector3d(0, 0, 0) : new ImmutableVector3d(
                this.x / length(), this.y / length(), this.z / length()
        );
    }

    /**
     * The entrywise absolute value of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: The entrywise absolute value of itself.</p>
     *
     * @return a new vector2 that contains the entrywise absolute value of itself.
     */
    @Override
    public ImmutableVector3d absolute() {
        return new ImmutableVector3d(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
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
    public ImmutableVector3d power(double exp) {
        return new ImmutableVector3d(Math.pow(this.x, exp), Math.pow(this.y, exp), Math.pow(this.z, exp));

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
    public ImmutableVector3d sign() {
        int signX = this.x < 0 ? -1 : this.x == 0 ? 0 : 1;
        int signY = this.y < 0 ? -1 : this.y == 0 ? 0 : 1;
        int signZ = this.z < 0 ? -1 : this.z == 0 ? 0 : 1;
        return new ImmutableVector3d(signX, signY, signZ);
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
    public ImmutableVector3d minimum(ImmutableVector3d second) {
        return new ImmutableVector3d(Math.min(this.x, second.x), Math.min(this.y, second.y), Math.min(this.z, second.z));
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
    public ImmutableVector3d maximum(ImmutableVector3d second) {
        return new ImmutableVector3d(Math.max(this.x, second.x), Math.max(this.y, second.y), Math.max(this.z, second.z));
    }

    /**
     * Rounds itself entrywise down to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise down to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise down to the nearest integer.
     */
    @Override
    public ImmutableVector3d floor() {
        return new ImmutableVector3d(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
    }

    /**
     * Rounds itself entrywise up to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise up to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise up to the nearest integer.
     */
    @Override
    public ImmutableVector3d ceil() {
        return new ImmutableVector3d(Math.ceil(this.x), Math.ceil(this.y), Math.ceil(this.z));
    }

    /**
     * Returns the fractional part of the value entrywise.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns the fractional part of the value entrywise.</p>
     *
     * @return the fractional part of the value entrywise.
     */
    @Override
    public ImmutableVector3d fraction() {
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
    public ImmutableVector3d modulo(ImmutableVector3d second) {
        if (compNotContainsZero(x, y, z)) {
            return new ImmutableVector3d(
                    this.x - second.x * Math.floor(this.x / second.x),
                    this.y - second.y * Math.floor(this.y / second.y),
                    this.z - second.z * Math.floor(this.z / second.z)
            );
        }
        return ImmutableVector3.NAN_3D;
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
    public ImmutableVector3d wrap(ImmutableVector3d minimum, ImmutableVector3d maximum) {
        return null;
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
    public ImmutableVector3d snap(ImmutableVector3d second) {
        return null;
    }

    /**
     * The entrywise of sine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of sine of its component</p>
     *
     * @return the entrywise of sine of itself.
     */
    @Override
    public ImmutableVector3d sine() {
        return new ImmutableVector3d(Math.sin(this.x), Math.sin(this.y), Math.sin(this.z));
    }

    /**
     * The entrywise of cosine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of cosine of its component</p>
     *
     * @return the entrywise of cosine of itself.
     */
    @Override
    public ImmutableVector3d cosine() {
        return new ImmutableVector3d(Math.cos(this.x), Math.cos(this.y), Math.cos(this.z));
    }

    /**
     * The entrywise of tangent of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of tangent of its component</p>
     *
     * @return the entrywise of tangent of itself.
     */
    @Override
    public ImmutableVector3d tangent() {
        return new ImmutableVector3d(Math.tan(this.x), Math.tan(this.y), Math.tan(this.z));
    }

    /**
     * Copy itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a new reference of itself.</p>
     *
     * @return a new reference of itself.
     */
    @Deprecated
    @Override
    public ImmutableVector3d copy() {
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
    public ImmutableVector3d getSelf() {
        return new ImmutableVector3d(this.x, this.y, this.z);
    }

    @Override
    public String toString() {
        return "<" + x + ", " + y + ", " + z + ">";
    }

    /**
     * Accessor of the x coordinate.
     *
     * @return the value of x coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Accessor of the y coordinate.
     *
     * @return the value of y coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Accessor of the z coordinate.
     *
     * @return the value of z coordinate.
     */
    public double getZ() {
        return z;
    }
}
