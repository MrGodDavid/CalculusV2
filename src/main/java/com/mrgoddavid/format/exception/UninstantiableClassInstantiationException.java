package com.mrgoddavid.format.exception;

/**
 * Throws this exception when the user tries to instantiate uninstantiable classes. For example, throws this exception
 * when user tries to instantiate an utility class that only contains static methods.
 *
 * @author Mr. GodDavid
 * @since 7/20/2026 added this exception.
 */
public class UninstantiableClassInstantiationException extends IllegalAccessException {

    /**
     * UninstantiableClassInstantiationException's constructor. Note that the error message is already provided.
     */
    public UninstantiableClassInstantiationException() {
        super("You cannot instantiate this class because this class is an utility class!");
    }
}
