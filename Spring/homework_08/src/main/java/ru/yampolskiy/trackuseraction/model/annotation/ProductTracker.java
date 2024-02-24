package ru.yampolskiy.trackuseraction.model.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ProductTracker {
    ProductActions action();
    long id() default -1;
    String title() default "";
    String description() default "";;
    double cost() default 0.0;;
    int amount() default 0;
    int reserved() default 0;
}
