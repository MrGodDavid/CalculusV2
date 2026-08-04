package com.mrgoddavid.function.piecewise;

import com.mrgoddavid.function.domain.Domain;

import java.io.Serial;

/**
 * Throws this exception when user instantiate piecewise functions with overlapped domain.
 *
 * @author Mr. GodDavid
 * @since 8/4/2026
 */
public class PiecewiseFunctionDomainOverlappingException extends PiecewiseFunctionException {
    @Serial
    private static final long serialVersionUID = -5915714889444168368L;

    /**
     * Throws this exception when user instantiate piecewise functions with overlapped domain.
     *
     * @param first       the first domain.
     * @param second      the second domain.
     */
    public PiecewiseFunctionDomainOverlappingException(Domain first, Domain second) {
        super("Piecewise function has overlapped " + first.toString() +  " and " + second.toString());
    }
}
