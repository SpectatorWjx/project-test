package com.wjx.sjsr.common.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface MyFirstAnnotation {
    @AliasFor("path")
    String value() default "";

    @AliasFor("value")
    String path() default "";
}