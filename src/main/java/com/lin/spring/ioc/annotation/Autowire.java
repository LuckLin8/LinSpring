package com.lin.spring.ioc.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) //运行时注解
@Target(ElementType.FIELD)  //作用于字段上
@Documented
public @interface Autowire {
    String value() default "";
}
