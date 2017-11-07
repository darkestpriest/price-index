package com.darkestapp.price_index.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/11/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Supported {

    boolean value() default true;
}
