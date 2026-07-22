package com.mrgoddavid.vector;

import java.io.Serializable;

/**
 * Interface of custom vector class. Define the operation of two-dimensional vector.
 *
 * @param <T> Class type of the implementation class of this interface.
 * @author David Liu.
 * @since 3/16/2026
 */
public interface Vector<T> extends Serializable {

    /**
     * Comparison command.
     */
    enum ComparisonCommand {
        /**
         * Less-than-or-equal-to command.
         */
        LESS_THAN_OR_EQUALS_TO,
        /**
         * Less-than command.
         */
        LESS_THAN,
        /**
         * Equal command.
         */
        EQUALS,
        /**
         * Greater-than command.
         */
        GREATER_THAN,
        /**
         * Greater-than-or-equal-to command.
         */
        GREATER_THAN_OR_EQUALS_TO;
    }

    /**
     * Performs entry addition of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the sum of two vectors.</p>
     *
     * @param second vector that is not null.
     * @return the sum of two vectors.
     */
    T add(T second);

    /**
     * Performs entry subtraction of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the difference between two vectors.</p>
     *
     * @param second vector that is not null.
     * @return the difference between two vectors.
     */
    T subtract(T second);

    /**
     * Performs entry multiplication of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the product of two vectors.</p>
     *
     * @param second vector that is not null.
     * @return the product of two vectors.
     */
    T multiply(T second);

    /**
     * Performs entry division of two vectors.
     * <p>Precondition: second vector is not null and its component does not contain 0.</p>
     * <p>Postcondition: returns the quotient of two vectors.</p>
     *
     * @param second vector that is not null.
     * @return the quotient of two vectors.
     */
    T divide(T second);

    /**
     * Performs entry multiplication and then addition of a vector itself.
     * <p>Precondition: multiplier vector and adder vector are not null.</p>
     * <p>Postcondition: returns the vector that is  multiplied multiplier vector and by  of two vectors.</p>
     *
     * @param multiplier vector that is not null.
     * @param adder      vector that is not null.
     * @return the vector that is  multiplied multiplier vector and by  of two vectors.
     */
    T multiply_add(T multiplier, T adder);

    /**
     * Performs the cross product of this vector to the second vector.
     * <p>Precondition: second input vector is not null.</p>
     * <p>Postcondition: calculate the cross product of itself to the second input vector.</p>
     *
     * @param second vector that is not null.
     * @return the cross product of itself to the second input vector.
     */
    double cross_product(T second);

    /**
     * Project itself on the second vector.
     * <p>Precondition: second input vector in not null.</p>
     * <p>Postcondition: calculate the projection vector of the second vector.</p>
     *
     * @param second vector that is not null.
     * @return the projection vector of the second vector.
     */
    T project(T second);

    /**
     * Reflect itself around the normal of the second input vector.
     * <p>Precondition: second input vector is not null and itself does not need to be normalized.</p>
     * <p>Postcondition: calculate the reflected </p>
     *
     * @param second vector that is not null.
     * @return the reflected vector around the normal of the second vector.
     */
    T reflect(T second);

    /**
     * Orients a vector A (itself) to point away from a surface B as defined by its normal C.
     * <p>Precondition: incident vector and reference vector are not null.</p>
     * <p>Postcondition: calculate the orientation of vector.</p>
     *
     * @param incident  the vector being checked and itself is not null.
     * @param reference the surface normal used to determine the orientation and itself is not null.
     * @return the calculated vector that is either flipped or not.
     */
    T faceForward(T incident, T reference);

    /**
     * Calculate the dot product of two vectors.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: calculate the dot product of itself and the second vector.</p>
     *
     * @param second vector that is not null.
     * @return the dot product of itself and the second vector.
     */
    double dot_product(T second);

    /**
     * Calculate the distance between two points are each represented by a 2-d vector.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: calculate the distance between itself and the second vector.</p>
     *
     * @param second vector that is not null.
     * @return the distance between itself and the second vector.
     */
    double distance(T second);

    /**
     * Calculate the length/magnitude of the vector.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the length of itself.</p>
     *
     * @return the length of itself.
     */
    double length();

    /**
     * Entry scale each component by a scale factor.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the scaled vector.</p>
     *
     * @param scale scaling factor.
     * @return the result of multiplying itself by the scalar input <code>scale</code>.
     */
    T scale(double scale);

    /**
     * Calculate the vector that is the normalized version of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: calculate the normalized vector.</p>
     *
     * @return the normalized vector.
     */
    T normalize();

    /**
     * The entrywise absolute value of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: The entrywise absolute value of itself.</p>
     *
     * @return a new vector2 that contains the entrywise absolute value of itself.
     */
    T absolute();

    /**
     * The entrywise power operator where the Base raised to the power of Exponent.
     * <p>Precondition: none.</p>
     * <p>Postcondition: The entrywise power operator where the Base raised to the power of Exponent.</p>
     *
     * @param exp the power exponent.
     * @return a new vector2 that contains the entrywise power operator where the Base raised to the power of Exponent.
     */
    T power(double exp);

    /**
     * Extracts the sign of the input value. All positive numbers will output 1.0. All negative numbers will output
     * -1.0.
     * And 0.0 will output 0.0.
     * <p>Precondition: none.</p>
     * <p>Postcondition: Extract the sign of each component.</p>
     *
     * @return a new vector that represents the sign of each component value.
     */
    T sign();

    /**
     * The entrywise minimum of itself and the second vector.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: return a new vector that contains entrywise minimum of itself and the second vector.</p>
     *
     * @param second vector that is not null.
     * @return a new vector that contains entrywise minimum of itself and the second vector
     */
    T minimum(T second);

    /**
     * The entrywise maximum of itself and the second vector.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: return a new vector that contains entrywise maximum of itself and the second vector.</p>
     *
     * @param second vector that is not null.
     * @return a new vector that contains entrywise maximum of itself and the second vector
     */
    T maximum(T second);

    /**
     * Rounds itself entrywise down to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise down to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise down to the nearest integer.
     */
    T floor();

    /**
     * Rounds itself entrywise up to the nearest integer.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return a new vector with its each component entrywise up to the nearest integer. </p>
     *
     * @return a new vector with its each component entrywise up to the nearest integer.
     */
    T ceil();

    /**
     * Returns the fractional part of the value entrywise.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns the fractional part of the value entrywise.</p>
     *
     * @return the fractional part of the value entrywise.
     */
    T fraction();

    /**
     * The entrywise modulo of itself by the second vector.
     * <p>Precondition: second vector is not null.</p>
     * <p>Postcondition: returns the entrywise modulo of itself by the second vector.</p>
     *
     * @param second vector that is not null.
     * @return the entrywise modulo of itself by the second vector.
     */
    T modulo(T second);

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
    T wrap(T minimum, T maximum);

    /**
     * The result of rounding itself to the largest integer multiple of B less than or equal itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a new vector that is entrywise snapped for each its component.</p>
     *
     * @param second that is not null.
     * @return a new vector that is entrywise snapped for each its component.
     */
    T snap(T second);

    /**
     * The entrywise of sine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of sine of its component</p>
     *
     * @return the entrywise of sine of itself.
     */
    T sine();

    /**
     * The entrywise of cosine of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of cosine of its component</p>
     *
     * @return the entrywise of cosine of itself.
     */
    T cosine();

    /**
     * The entrywise of tangent of itself.
     * <p>Precondition: none</p>
     * <p>Postcondition: calculate the entrywise of tangent of its component</p>
     *
     * @return the entrywise of tangent of itself.
     */
    T tangent();

    /**
     * Copy itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a new reference of itself.</p>
     *
     * @return a new reference of itself.
     */
    T copy();

    /**
     * Return a reference of itself.
     * <p>Precondition: none.</p>
     * <p>Postcondition: returns a reference of itself.</p>
     *
     * @return Return a reference of itself.
     */
    T getSelf();

    /**
     * Performs entrywise comparison of vector itself and the second vector. The comparison is specified in the
     * enum of {@code Vector}.
     * <p>Precondition: second input vector is not null.</p>
     * <p>Postcondition: return a boolean value that the first vector pass/fail the comparison test to the second
     * vector.</p>
     *
     * @param second  vector that is not null.
     * @param command specifies the comparison operation between the current vector and the second input vector.
     * @return true if the current vector passes the comparison test to the second input vector and false otherwise.
     */
    default boolean compareWith(T second, ComparisonCommand command) {
        if (!(second instanceof Vector)) return false;
        boolean result = false;
        T self = getSelf();
        switch (command) {
            case LESS_THAN_OR_EQUALS_TO -> {
                if (second instanceof Vector2i second_v2i) {
                    Vector2i self_v2i = (Vector2i) self;
                    result = (self_v2i.getX() <= second_v2i.getX()) && (self_v2i.getY() <= second_v2i.getY());
                } else if (second instanceof Vector2d second_v2d) {
                    Vector2d self_v2d = (Vector2d) self;
                    result = (self_v2d.getX() <= second_v2d.getX()) && (self_v2d.getY() <= second_v2d.getY());
                } else if (second instanceof Vector3i second_v3i) {
                    Vector3i self_v3d = (Vector3i) self;
                    result = (self_v3d.getX() <= second_v3i.getX()) && (self_v3d.getY() <= second_v3i.getY()) && (self_v3d.getZ() <= second_v3i.getZ());
                } else if (second instanceof Vector3d second_v3d) {
                    Vector3d self_v3d = (Vector3d) self;
                    result = (self_v3d.getX() <= second_v3d.getX()) && (self_v3d.getY() <= second_v3d.getY()) && (self_v3d.getZ() <= second_v3d.getZ());
                }
            }
            case LESS_THAN -> {
                if (second instanceof Vector2i second_v2i) {
                    Vector2i self_v2i = (Vector2i) self;
                    result = (self_v2i.getX() < second_v2i.getX()) && (self_v2i.getY() < second_v2i.getY());
                } else if (second instanceof Vector2d second_v2d) {
                    Vector2d self_v2d = (Vector2d) self;
                    result = (self_v2d.getX() < second_v2d.getX()) && (self_v2d.getY() < second_v2d.getY());
                } else if (second instanceof Vector3i second_v3i) {
                    Vector3i self_v3d = (Vector3i) self;
                    result = (self_v3d.getX() < second_v3i.getX()) && (self_v3d.getY() < second_v3i.getY()) && (self_v3d.getZ() < second_v3i.getZ());
                } else if (second instanceof Vector3d second_v3d) {
                    Vector3d self_v3d = (Vector3d) self;
                    result = (self_v3d.getX() < second_v3d.getX()) && (self_v3d.getY() < second_v3d.getY()) && (self_v3d.getZ() < second_v3d.getZ());
                }
            }
            case EQUALS -> {
                if (second instanceof Vector2i second_v2i) {
                    Vector2i self_v2i = (Vector2i) self;
                    result = (self_v2i.getX() == second_v2i.getX()) && (self_v2i.getY() == second_v2i.getY());
                } else if (second instanceof Vector2d second_v2d) {
                    Vector2d self_v2d = (Vector2d) self;
                    result = (self_v2d.getX() == second_v2d.getX()) && (self_v2d.getY() == second_v2d.getY());
                } else if (second instanceof Vector3i second_v3i) {
                    Vector3i self_v3d = (Vector3i) self;
                    result = (self_v3d.getX() == second_v3i.getX()) && (self_v3d.getY() == second_v3i.getY()) && (self_v3d.getZ() == second_v3i.getZ());
                } else if (second instanceof Vector3d second_v3d) {
                    Vector3d self_v3d = (Vector3d) self;
                    result = (self_v3d.getX() == second_v3d.getX()) && (self_v3d.getY() == second_v3d.getY()) && (self_v3d.getZ() == second_v3d.getZ());
                }
            }
            case GREATER_THAN -> {
                if (second instanceof Vector2i second_v2i) {
                    Vector2i self_v2i = (Vector2i) self;
                    result = (self_v2i.getX() > second_v2i.getX()) && (self_v2i.getY() > second_v2i.getY());
                } else if (second instanceof Vector2d second_v2d) {
                    Vector2d self_v2d = (Vector2d) self;
                    result = (self_v2d.getX() > second_v2d.getX()) && (self_v2d.getY() > second_v2d.getY());
                } else if (second instanceof Vector3i second_v3i) {
                    Vector3i self_v3d = (Vector3i) self;
                    result = (self_v3d.getX() == second_v3i.getX()) && (self_v3d.getY() == second_v3i.getY()) && (self_v3d.getZ() == second_v3i.getZ());
                } else if (second instanceof Vector3d second_v3d) {
                    Vector3d self_v3d = (Vector3d) self;
                    result = (self_v3d.getX() > second_v3d.getX()) && (self_v3d.getY() > second_v3d.getY()) && (self_v3d.getZ() > second_v3d.getZ());
                }
            }
            case GREATER_THAN_OR_EQUALS_TO -> {
                if (second instanceof Vector2i second_v2i) {
                    Vector2i self_v2i = (Vector2i) self;
                    result = (self_v2i.getX() >= second_v2i.getX()) && (self_v2i.getY() >= second_v2i.getY());
                } else if (second instanceof Vector2d second_v2d) {
                    Vector2d self_v2d = (Vector2d) self;
                    result = (self_v2d.getX() >= second_v2d.getX()) && (self_v2d.getY() >= second_v2d.getY());
                } else if (second instanceof Vector3i second_v3i) {
                    Vector3i self_v3d = (Vector3i) self;
                    result = (self_v3d.getX() >= second_v3i.getX()) && (self_v3d.getY() >= second_v3i.getY()) && (self_v3d.getZ() >= second_v3i.getZ());
                } else if (second instanceof Vector3d second_v3d) {
                    Vector3d self_v3d = (Vector3d) self;
                    result = (self_v3d.getX() >= second_v3d.getX()) && (self_v3d.getY() >= second_v3d.getY()) && (self_v3d.getZ() >= second_v3d.getZ());
                }
            }
            default -> {
            }
        }
        return result;
    }

    /**
     * Check if any component of {@code Vector} is zero.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return true if none of the components of {@code Vector} is zero.</p>
     *
     * @param x x integer component of {@code Vector}.
     * @param y y integer component of {@code Vector}.
     * @return true if none of the components of {@code Vector} is zero.
     */
    default boolean compContainsZero(int x, int y) {
        return x != 0 && y != 0;
    }

    /**
     * Check if any component of {@code Vector} is zero.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return true if none of the components of {@code Vector} is zero.</p>
     *
     * @param x x double component of {@code Vector}.
     * @param y y double component of {@code Vector}.
     * @return true if none of the components of {@code Vector} is zero.
     */
    default boolean compContainsZero(double x, double y) {
        return x != 0d && y != 0d;
    }

    /**
     * Check if any component of {@code Vector} is zero.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return true if none of the components of {@code Vector} is zero.</p>
     *
     * @param x x float component of {@code Vector}.
     * @param y y float component of {@code Vector}.
     * @return true if none of the components of {@code Vector} is zero.
     */
    default boolean compContainsZero(float x, float y) {
        return x != 0f && y != 0f;
    }

    /**
     * Check if any component of {@code Vector} is zero.
     * <p>Precondition: none.</p>
     * <p>Postcondition: return true if none of the components of {@code Vector} is zero.</p>
     *
     * @param x x long component of {@code Vector}.
     * @param y y long component of {@code Vector}.
     * @return true if none of the components of {@code Vector} is zero.
     */
    default boolean compContainsZero(long x, long y) {
        return x != 0L && y != 0L;
    }
}

/**
 * Interface for operations of three-dimensional vectors. This interface extends {@link Vector}.
 *
 * @param <T> type parameter. Class type of implementation of this interface.
 * @author Mr. GodDavid
 * @since 6/9/2026
 */
interface Vector3<T> extends Vector<T> {

    /**
     * Zero three-dimensional vector. Each component of this vector is an integer.
     */
    Vector3i ZERO_VECTOR3I = new Vector3i();

    /**
     * Zero three-dimensional vector. Each component of this vector is a double.
     */
    Vector3d ZERO_VECTOR3D = new Vector3d();

    /**
     * Calculate the cross product of two three-dimensional vectors.
     *
     * @param other three-dimensional vector that is not null.
     * @return the cross product of two three-dimensional vectors.
     */
    T crossProduct(T other);

    /**
     * Find the length of the shadow of itself on the second three-dimensional vector.
     *
     * @param second three-dimensional vector that is not null.
     * @return the scalar projection of itself on the second vector.
     * @since 7/10/2026 added this method.
     */
    double scalar_projection(T second);
}

