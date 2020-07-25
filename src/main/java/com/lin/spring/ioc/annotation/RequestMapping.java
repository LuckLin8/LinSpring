package com.lin.spring.ioc.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})//作用于类和方法
@Documented
public @interface RequestMapping {
    String value() default "";
}
