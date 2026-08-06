package com.mrgoddavid.function.piecewise;

import com.mrgoddavid.function.FunctionInputOutOfDomainException;
import com.mrgoddavid.function.Function;
import com.mrgoddavid.function.rational.RationalFunction;
import com.mrgoddavid.function.derivative.Derivative;
import com.mrgoddavid.function.domain.Domain;
import com.mrgoddavid.function.limit.Limit;

import java.util.HashMap;
import java.util.Map;

/**
 * A piecewise function is a single function whose total domain is split into smaller, non-overlapping intervals, with a
 * different sub-formula or rule assigned to each individual interval.
 *
 * @author Mr. GodDavid
 * @since 8/2/2026
 */
public final class PiecewiseFunction {

    private final Map<Domain, Function> functionDomainMap;

    private final Limit[] limits;
    private final Derivative[] derivatives;

    /**
     * Constructs a new function class by the given expression of this function.
     *
     * @param f1     expression of this function that is not null.
     * @param domain domain of the function.
     */
    public PiecewiseFunction(Function f1, Domain domain) {
        domainValidity(new Domain[]{domain});
        functionDomainMap = new HashMap<>();
        functionDomainMap.put(domain, f1);


        this.limits = new Limit[]{f1.getLimit()};
        this.derivatives = new Derivative[]{f1.getDerivative()};
    }

    /**
     * Constructs a function with given numerator and denominator expression.
     *
     * @param f1     expression of the rational function.
     * @param domain domain of this rational function.
     */
    public PiecewiseFunction(RationalFunction f1, Domain domain) {
        domainValidity(new Domain[]{domain});
        functionDomainMap = new HashMap<>();
        functionDomainMap.put(domain, f1);

        this.limits = new Limit[]{f1.getLimit()};
        this.derivatives = new Derivative[]{f1.getDerivative()};
    }

    /**
     * Constructs a function with the given functions and the domain of each of those functions.
     *
     * @param f1 the expression of the first function.
     * @param d1 the domain of the first function.
     * @param f2 the expression of the second function.
     * @param d2 the domain of the second function.
     */
    public PiecewiseFunction(Function f1, Domain d1, Function f2, Domain d2) {
        domainValidity(new Domain[]{d1, d2});
        functionDomainMap = new HashMap<>();
        functionDomainMap.put(d1, f1);
        functionDomainMap.put(d2, f2);


        this.limits = new Limit[2];
        this.derivatives = new Derivative[2];

        this.limits[0] = f1.getLimit();
        this.derivatives[0] = f1.getDerivative();
        this.limits[1] = f2.getLimit();
        this.derivatives[1] = f2.getDerivative();
    }

    /**
     * Constructs a piecewise function with the given array of expression of function and array of domains for each of
     * the function.
     *
     * @param functions an array of functions that is not null.
     * @param domains   an array of domains that is not null.
     */
    public PiecewiseFunction(Function[] functions, Domain[] domains) {
        if (functions.length != domains.length) {
            throw new PiecewiseFunctionExpressionDomainMismatchException(functions.length, domains.length);
        }
        domainValidity(domains);

        functionDomainMap = new HashMap<>();


        int iteration = functions.length;
        this.limits = new Limit[iteration];
        this.derivatives = new Derivative[iteration];

        for (int i = 0; i < iteration; i++) {
            functionDomainMap.put(domains[i], functions[i]);
            this.limits[i] = functions[i].getLimit();
            this.derivatives[i] = functions[i].getDerivative();
        }
    }

    /**
     * Locates the domain where the x lands.
     *
     * @param x given x.
     * @return the domain that the given x lands.
     */
    private Domain findDomain(double x) {
        for (Domain domain : this.functionDomainMap.keySet()) {
            if (domain.inDomain(x)) {
                return domain;
            }
        }
        return null;
    }

    /**
     * Calculates the limit of the piecewise function at given x.
     *
     * @param x given x.
     * @return the value of the limit of this piecewise function at given x.
     */
    public double limitAt(double x) {
        Domain domain = findDomain(x);
        if (domain == null) {
            throw new FunctionInputOutOfDomainException("Could not find domain for " + x + "!");
        }
        return this.functionDomainMap.get(domain).limitAt(x);
    }

    /**
     * Checks the validity of the list of domains when constructing this class. If the domain is invalid, this class
     * throws {@link PiecewiseFunctionDomainOverlappingException} and terminates the program.
     *
     * @param domains list of domain that is not null.
     */
    private void domainValidity(Domain[] domains) {
        for (int i = 0; i < domains.length; i++) {
            for (int j = i + 1; j < domains.length; j++) {
                if (domains[i].overlaps(domains[j])) {
                    throw new PiecewiseFunctionDomainOverlappingException(domains[i], domains[j]);
                }
            }
        }
    }
}
