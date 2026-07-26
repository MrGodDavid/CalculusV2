package com.mrgoddavid.format.annotation;

import java.lang.annotation.*;

/**
 * Attaches this annotation above the class that can be instantiated only once.
 *
 * @author Mr. GodDavid
 * @since 7/25/2026
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface SingletonClass {
}
