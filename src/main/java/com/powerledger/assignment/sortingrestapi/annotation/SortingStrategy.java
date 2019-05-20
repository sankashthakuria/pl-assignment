package com.powerledger.assignment.sortingrestapi.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by @author Sankash on 5/13/2019
 */
@Qualifier
@Documented
@Retention(RUNTIME)
@Component
public @interface SortingStrategy {
    String value() default "";
}
