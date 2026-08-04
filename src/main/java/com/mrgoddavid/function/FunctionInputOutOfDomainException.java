package com.mrgoddavid.function;

import com.mrgoddavid.function.domain.Domain;

import java.io.Serial;

/**
 * Throws this exception when the input is out of the domain of the function.
 */
public class FunctionInputOutOfDomainException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 9205130962890822087L;

    /**
     * Constructs this exception with thrown reason. Given domain and input for debug.
     *
     * @param domain domain for debug.
     * @param input  input of the function for debug.
     */
    public FunctionInputOutOfDomainException(Domain domain, double input) {
        super("Input " + input + " is out of " + domain.toString());
    }

    /**
     * Constructs this exception with thrown reason.
     *
     * @param message reason of why throwing this exception.
     */
    public FunctionInputOutOfDomainException(String message) {
        super(message);
    }
}
