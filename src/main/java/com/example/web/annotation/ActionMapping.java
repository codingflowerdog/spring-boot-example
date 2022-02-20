package com.example.web.annotation;

import com.example.web.data.enums.Action;
import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Aspect
public @interface ActionMapping {
    public Action value();
}
