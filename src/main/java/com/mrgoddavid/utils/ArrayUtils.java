package com.mrgoddavid.utils;

import com.mrgoddavid.format.exception.UninstantiableClassInstantiationException;

/**
 * This class holds utility methods of Java's arrays.
 *
 * @author Mr. GodDavid
 * @since 7/27/2026
 */
public final class ArrayUtils {

    /**
     * Private constructor, preventing user from instantiating this utility class.
     *
     * @throws UninstantiableClassInstantiationException when user tries to instantiate this class.
     */
    private ArrayUtils() throws UninstantiableClassInstantiationException {
        throw new UninstantiableClassInstantiationException();
    }

    /**
     * Reverses an array by swapping the first and last element in this array, and the second and second-last one, and
     * vise versa.
     *
     * @param arr an array of double number, and the array object itself is not null.
     * @return the reversed array.
     */
    public static double[] reverse(double[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            double temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
}
