package com.mrgoddavid.geometry.angle;

import java.io.Serializable;
import java.util.Comparator;

import static com.mrgoddavid.utils.Constants.PI;

/**
 * The angle in degrees.
 *
 * @author Mr. GodDavid
 * @since 7/22/2026 this is part of Angle Update feature.
 */
public final class Degree implements Angle<Degree>, Comparable<Degree>, Comparator<Degree>, Serializable {

    /**
     * Angle in degrees.
     */
    private final double degree;

    /**
     * Default constructor of {@code Degree} class.
     */
    public Degree() {
        this(0.0);
    }

    /**
     * Constructs an angle in degrees.
     *
     * @param degree the angle of this angle.
     */
    public Degree(double degree) {
        this.degree = degree;
    }

    /**
     * Adds two angles.
     *
     * @param other angle that is not null.
     * @return the sum of two angles.
     */
    @Override
    public Degree add(Degree other) {
        return new Degree(degree + other.val());
    }

    /**
     * Subtracts this angle from the given angle.
     *
     * @param other angle that is not null.
     * @return the difference between two angles.
     */
    @Override
    public Degree subtract(Degree other) {
        return new Degree(degree - other.val());
    }

    /**
     * Multiplies this angle by a scalar that is a double.
     *
     * @param other the scalar.
     * @return the scaled angle.
     */
    @Override
    public Degree scale(double other) {
        return new Degree(degree * other);
    }

    /**
     * Finds the half angle of this angle.
     *
     * @return the half angle of this angle.
     */
    @Override
    public Degree bisect() {
        return new Degree(degree / 2.0);
    }

    /**
     * Finds the one-third angle of this angle.
     *
     * @return the one-third angle of this angle.
     */
    @Override
    public Degree trisect() {
        return new Degree(degree / 3.0);
    }

    @Override
    public int compareTo(Degree degree) {
        return Double.compare(this.degree, degree.val());
    }

    @Override
    public int compare(Degree degree, Degree t1) {
        return degree.compareTo(t1);
    }

    /**
     * Accessor of the value of this angle in degrees.
     *
     * @return the value of this angle.
     */
    public double val() {
        return degree;
    }

    /**
     * Converts this angle to radians.
     *
     * @return the radians of this angle.
     */
    public Radian toRadians() {
        return new Radian(degree / 180.0 * PI);
    }

    @Override
    public String toString() {
        return "Angle: [" + degree + "] degrees.";
    }
}
