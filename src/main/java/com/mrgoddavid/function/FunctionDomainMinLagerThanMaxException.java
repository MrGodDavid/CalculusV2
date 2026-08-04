package com.mrgoddavid.function;

import com.mrgoddavid.function.domain.Domain;

import java.io.Serial;

/**
 * Throws this exception when user instantiates a domain class such that the minimum value is larger than maximum value
 * of the domain.
 *
 * @author Mr. GodDavid
 * @since 8/4/2026
 */
public class FunctionDomainMinLagerThanMaxException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 7376952549980046221L;

    /**
     * Throws this exception when user instantiate {@link Domain} such that its min is larger
     * than max.
     */
    public FunctionDomainMinLagerThanMaxException() {
        super("Min domain is larger than Max domain!");
    }
}
