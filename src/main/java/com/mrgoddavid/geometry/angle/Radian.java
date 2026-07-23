package com.mrgoddavid.geometry.angle;

import java.io.Serializable;
import java.util.Comparator;

import static com.mrgoddavid.utils.Constants.PI;

/**
 * The angle in radians.
 *
 * @author Mr. GodDavid
 * @since 7/23/2026 part of Angle Update feature,
 */
public final class Radian implements Angle<Radian>, Comparable<Radian>, Comparator<Radian>, Serializable {

    /**
     * Numerical value of this angle. The unit is radians.
     */
    private final double radians;

    /**
     * Default constructor of this class. Constructs a angle with zero radians.
     */
    public Radian() {
        this(0.0);
    }

    /**
     * Constructs an angle in radians.
     *
     * @param radians given angle of this angle.
     */
    public Radian(double radians) {
        this.radians = radians;
    }

    /**
     * Accessor of the numerical value of this angle.
     *
     * @return the numerical value of this angle.
     */
    public double val() {
        return radians;
    }

    /**
     * Converts this angle to degrees.
     *
     * @return the degrees of this angle.
     */
    public Degree toDegree() {
        return new Degree(radians * 180.0 / PI);
    }

    /**
     * Adds two angles.
     *
     * @param other angle that is not null.
     * @return the sum of two angles.
     */
    @Override
    public Radian add(Radian other) {
        return new Radian(radians + other.val());
    }

    /**
     * Subtracts this angle from the given angle.
     *
     * @param other angle that is not null.
     * @return the difference between two angles.
     */
    @Override
    public Radian subtract(Radian other) {
        return new Radian(radians - other.val());
    }

    /**
     * Multiplies this angle by a scalar that is a double.
     *
     * @param other the scalar.
     * @return the scaled angle.
     */
    @Override
    public Radian scale(double other) {
        return new Radian(radians * other);
    }

    /**
     * Finds the half angle of this angle.
     *
     * @return the half angle of this angle.
     */
    @Override
    public Radian bisect() {
        return new Radian(radians / 2d);
    }

    /**
     * Finds the one-third angle of this angle.
     *
     * @return the one-third angle of this angle.
     */
    @Override
    public Radian trisect() {
        return new Radian(radians / 3d);
    }

    @Override
    public int compareTo(Radian radian) {
        return Double.compare(this.val(), radian.val());
    }

    @Override
    public int compare(Radian radian, Radian t1) {
        return radian.compareTo(t1);
    }

    @Override
    public String toString() {
        return "Angle: [" + radians + "] radians.";
    }
}
