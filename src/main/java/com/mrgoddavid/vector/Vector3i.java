package com.mrgoddavid.vector;

import com.mrgoddavid.matrix.Matrix3i;

/**
 * Three-dimensional vector. Each component of this vector is integer.
 *
 * @author Mr. GodDavid
 * @since 7/9/2026
 */
public class Vector3i implements Vector3<Vector3i> {

    /**
     * Zero vector of this class.
     */
    public static final Vector3i ZERO = new Vector3i();

    /**
     * Unit vector along x-axis. We define this unit vector as i.
     */
    public static final Vector3i UNIT_I = new Vector3i(1, 0, 0);

    /**
     * Unit vector along y-axis. We define this unit vector as j.
     */
    public static final Vector3i UNIT_J = new Vector3i(0, 1, 0);

    /**
     * Unit vector along z-axis. We define this unit vector as k.
     */
    public static final Vector3i UNIT_K = new Vector3i(0, 0, 1);

    /**
     * X coordinate of this vector.
     */
    private final int x;
    /**
     * Y coordinate of this vector.
     */
    private final int y;
    /**
     * Z coordinate of this vector.
     */
    private final int z;

    /**
     * Default constructor of this class.
     */
    public Vector3i() {
        this(0, 0, 0);
    }

    /**
     * Constructs a three-dimensional vector from the parameters.
     *
     * @param x coordinate of this vector.
     * @param y coordinate of this vector.
     * @param z coordinate of this vector.
     */
    public Vector3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs a three-dimensional vector from the vector given by the parameter.
     *
     * @param other vector that is not null.
     */
    public Vector3i(Vector3d other) {
        this.x = (int) other.getX();
        this.y = (int) other.getY();
        this.z = (int) other.getZ();
    }

    /**
     * Calculates the cross product of two three-dimensional vectors.
     *
     * @param other three-dimensional vector that is not null.
     * @return the cross product of two three-dimensional vectors.
     */
    @Override
    public Vector3i crossProduct(Vector3i other) {
        Matrix3i matrix3VI = new Matrix3i(-999, -999, -999, this.x, this.y, this.z, other.x, other.y, other.z);
        return matrix3VI.determinantToVector();
    }

    // =====================================> Cross Product Simplification Feature <=====================================
    // author: Mr. GodDavid
    // since 7/10/2026

    /**
     * Calculates the cross product of two three-dimensional vectors. This method simplifies the result by dividing it
     * by the greatest common factor of three components.
     *
     * @param other    three-dimensional vector that is not null.
     * @param simplify a boolean key allows user to choose whether to simplify the cross product or not.
     * @return the simplified cross product if {@code simplify = true} and original cross product if {@code simplify = false}
     * @since 7/10/2026 added this method.
     */
    public Vector3i crossProduct(Vector3i other, boolean simplify) {
        Vector3i cross_product = this.crossProduct(other);
        if (simplify) {
            int gcf = findGCF(cross_product.x, cross_product.y, cross_product.z);
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
     * Performs entry addition of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the sum of two vectors.</p>
     *
     * @param second vector that is not null.
     * @return the sum of two vectors.
     */
    @Override
    public Vector3i add(Vector3i second) {
        return new Vector3i(this.x + second.x, this.y + second.y, this.z + second.z);
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
    public Vector3i subtract(Vector3i second) {
        return new Vector3i(this.x - second.x, this.y - second.y, this.z - second.z);
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
    public Vector3i multiply(Vector3i second) {
        return new Vector3i(this.x * second.x, this.y * second.y, this.z * second.z);
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
    public Vector3i divide(Vector3i second) {
        if (containsZero(second)) {
            System.err.println("Vector3i" + second + "contains zero!");
            return new Vector3i(0, 0, 0);
        }
        return new Vector3i(x / second.x, y / second.y, z / second.z);
    }

    private boolean containsZero(Vector3i vector) {
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
    public Vector3i multiply_add(Vector3i multiplier, Vector3i adder) {
        int x = multiplier.x * this.x + adder.x;
        int y = multiplier.y * this.y + adder.y;
        int z = multiplier.z * this.z + adder.z;
        return new Vector3i(x, y, z);
    }

    /**
     * Performs the cross product of this vector to the second vector.
     * <p>Precondition: second input vector is not null.</p>
     * <p>Postcondition: calculate the cross product of itself to the second input vector.</p>
     *
     * @param second vector that is not null.
     * @return the cross product of itself to the second input vector.
     * @deprecated this method is not suitable for calculating the cross product of two three-dimensional vectors.
     */
    @Deprecated
    @Override
    public double cross_product(Vector3i second) {
        return -999;
    }

    /**
     * Find the length of the shadow of itself on the second three-dimensional vector.
     *
     * @param second three-dimensional vector that is not null.
     * @return the scalar projection of itself on the second vector.
     * @since 7/10/2026 added this method.
     */
    public double scalar_projection(Vector3i second) {
        double dot_product = this.dot_product(second);
        return dot_product / second.length();
    }

    /**
     * Project itself on the second vector.
     * <p>Precondition: second input vector in not null.</p>
     * <p>Postcondition: calculate the projection vector of the second vector.</p>
     *
     * @param second vector that is not null.
     * @return the projection vector of the second vector.
     * @deprecated Implementation of this method is working in progress.
     *
     */
    @Deprecated
    @Override
    public Vector3i project(Vector3i second) {
        double mag = second.length();
        double length = this.dot_product(second) / mag / mag;
        return this.scale(length);
    }

    /**
     * Reflect itself around the normal of the second input vector.
     * <p>Precondition: second input vector is not null and itself does not need to be normalized.</p>
     * <p>Postcondition: calculate the reflected </p>
     *
     * @param second vector that is not null.
     * @return the reflected vector around the normal of the second vector.
     * @deprecated Implementation of this method is working in progress.
     */
    @Deprecated
    @Override
    public Vector3i reflect(Vector3i second) {
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
     * @deprecated Implementation of this method is working in progress.
     */
    @Override
    @Deprecated
    public Vector3i faceForward(Vector3i incident, Vector3i reference) {
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
    public double dot_product(Vector3i second) {
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
    public double distance(Vector3i second) {
        int dx = Math.abs(this.x - second.x);
        int dy = Math.abs(this.y - second.y);
        int dz = Math.abs(this.z - second.z);
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
    public Vector3i scale(double scale) {
        return new Vector3i((int) (this.x * scale), (int) (this.y * scale), (int) (this.z * scale));
    }

    /**
     * Calculate the vector that is the normalized version of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the normalized vector.</p>
     *
     * @return the normalized vector.
     */
    @Override
    public Vector3i normalize() {
        return length() == 0 ? new Vector3i(0, 0, 0) : new Vector3i(
                (int) (this.x / length()), (int) (this.y / length()), (int) (this.z / length())
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
    public Vector3i absolute() {
        return new Vector3i(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
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
    public Vector3i power(double exp) {
        return new Vector3i((int) Math.pow(this.x, exp), (int) Math.pow(this.y, exp), (int) Math.pow(this.z, exp));
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
    public Vector3i sign() {
        int signX = this.x < 0 ? -1 : this.x == 0 ? 0 : 1;
        int signY = this.y < 0 ? -1 : this.y == 0 ? 0 : 1;
        int signZ = this.z < 0 ? -1 : this.z == 0 ? 0 : 1;
        return new Vector3i(signX, signY, signZ);
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
    public Vector3i minimum(Vector3i second) {
        return new Vector3i(Math.min(this.x, second.x), Math.min(this.y, second.y), Math.min(this.z, second.z));
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
    public Vector3i maximum(Vector3i second) {
        return new Vector3i(Math.max(this.x, second.x), Math.max(this.y, second.y), Math.max(this.z, second.z));
    }

    /**
     * Rounds itself entrywise down to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise down to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise down to the nearest integer.
     */
    @Override
    public Vector3i floor() {
        return getSelf();
    }

    /**
     * Rounds itself entrywise up to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise up to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise up to the nearest integer.
     */
    @Override
    public Vector3i ceil() {
        return getSelf();
    }

    /**
     * Returns the fractional part of the value entrywise.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns the fractional part of the value entrywise.</p>
     *
     * @return the fractional part of the value entrywise.
     */
    @Override
    public Vector3i fraction() {
        return new Vector3i();
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
    public Vector3i modulo(Vector3i second) {
        if (compNotContainsZero(x, y, z)) {
            return new Vector3i(this.x % second.x, this.y % second.y, this.z % second.z);
        }
        return Vector3.NAN_3I;
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
    @Deprecated
    @Override
    public Vector3i wrap(Vector3i minimum, Vector3i maximum) {
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
    @Deprecated
    @Override
    public Vector3i snap(Vector3i second) {
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
    public Vector3i sine() {
        return new Vector3i((int) Math.sin(x), (int) Math.sin(y), (int) Math.sin(z));
    }

    /**
     * The entrywise of cosine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of cosine of its component</p>
     *
     * @return the entrywise of cosine of itself.
     */
    @Override
    public Vector3i cosine() {
        return new Vector3i((int) Math.cos(x), (int) Math.cos(y), (int) Math.cos(z));
    }

    /**
     * The entrywise of tangent of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of tangent of its component</p>
     *
     * @return the entrywise of tangent of itself.
     */
    @Override
    public Vector3i tangent() {
        return new Vector3i((int) Math.tan(x), (int) Math.tan(y), (int) Math.tan(z));
    }

    /**
     * Copy itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a new reference of itself.</p>
     *
     * @return a new reference of itself. See {@link Vector3i#getSelf()}.
     * @since 6/9/2026
     */
    @Deprecated
    @Override
    public Vector3i copy() {
        return new Vector3i(this.x, this.y, this.z);
    }

    /**
     * Return a reference of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a reference of itself.</p>
     *
     * @return Return a reference of itself.
     */
    @Override
    public Vector3i getSelf() {
        return new Vector3i(this.x, this.y, this.z);
    }

    @Override
    public String toString() {
        return "<" + x + ", " + y + ", " + z + ">";
    }

    /**
     * Accessor of x coordinate.
     *
     * @return the x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Accessor of y coordinate.
     *
     * @return the y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Accessor of z coordinate.
     *
     * @return the z coordinate.
     */
    public int getZ() {
        return z;
    }
}
