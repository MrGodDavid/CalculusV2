package com.mrgoddavid.function.domain;

import com.mrgoddavid.function.FunctionDomainMinLagerThanMaxException;

/**
 * Defines the domain of functions. Domain has minimum number and maximum number. The minimum number can negative
 * infinity or any real number, and the maximum number can be positive infinity or ny real number. Intuitively, the
 * maximum value must be greater than the minimum value.
 *
 * @author Mr. GodDavid
 * @since 8/3/2026
 */
public final class Domain {

    /**
     * Minimum of domain.
     */
    private final double minDomain;
    /**
     * Maximum of domain.
     */
    private final double maxDomain;

    /**
     * True if minimum value is inclusive.
     */
    private final boolean leftInclusive;

    /**
     * True if maximum value is inclusive.
     */
    private final boolean rightInclusive;

    /**
     * Constructs a domain with the given minimum and maximum number.
     *
     * @param minDomain      the minimum of the domain.
     * @param maxDomain      the maximum of the domain.
     * @param leftInclusive  true if minimum value is inclusive.
     * @param rightInclusive true if maximum value is inclusive.
     */
    public Domain(double minDomain, double maxDomain, boolean leftInclusive, boolean rightInclusive) {
        if (minDomain > maxDomain) {
            throw new FunctionDomainMinLagerThanMaxException();
        }
        this.minDomain = minDomain;
        this.maxDomain = maxDomain;
        this.leftInclusive = leftInclusive;
        this.rightInclusive = rightInclusive;
    }

    public boolean overlaps(Domain second) {
        if (this.min() == second.max() && !(this.leftInclusive() && second.rightInclusive())) {
            return false;
        }
        if (this.max() == second.min() && !(this.rightInclusive() && second.leftInclusive())) {
            return false;
        }
        return Math.max(this.min(), second.min()) <= Math.min(this.max(), second.max());
    }

    public double max() {
        return maxDomain;
    }

    public double min() {
        return minDomain;
    }

    public boolean leftInclusive() {
        return leftInclusive;
    }

    public boolean leftExclusive() {
        return !leftInclusive;
    }

    public boolean rightInclusive() {
        return rightInclusive;
    }

    public boolean rightExclusive() {
        return !rightInclusive;
    }

    public boolean inDomain(double x) {
        if (leftInclusive() && rightInclusive()) {
            return x >= minDomain && x <= maxDomain;
        }
        if (leftInclusive() && rightExclusive()) {
            return x >= minDomain && x < maxDomain;
        }
        if (leftExclusive() && rightInclusive()) {
            return x > minDomain && x <= maxDomain;
        }
        if (leftExclusive() && rightExclusive()) {
            return x > minDomain && x < maxDomain;
        }
        return false;
    }

    @Override
    public String toString() {
        char left = leftInclusive ? '[' : '(';
        char right = rightInclusive ? ']' : ')';
        return "Domain: " + left + "" + minDomain + ", " + maxDomain + "" + right;
    }
}
