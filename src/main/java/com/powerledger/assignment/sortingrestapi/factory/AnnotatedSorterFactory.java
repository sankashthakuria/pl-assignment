package com.powerledger.assignment.sortingrestapi.factory;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;

/**
 * Created by @author Sankash on 5/13/2019
 */
public abstract class AnnotatedSorterFactory<A extends Annotation, T> {
    @Autowired
    private ListableBeanFactory beanFactory;

    public T getImplementation(String strategy) throws IllegalAccessException {
        Class<A> annotationClass = strategyAnnotation();
        Class<T> interfaceClass = strategyInterface();

        String[] names = beanFactory.getBeanNamesForAnnotation(annotationClass);

        for (String strategyName : names) {
            if (strategyName.equals(strategy)) {
                return beanFactory.getBean(strategyName, interfaceClass);
            }
        }

        throw new IllegalAccessException("There is no \"" + strategy + "\" strategy available for " + interfaceClass.getName());
    }

    public abstract Class<A> strategyAnnotation();
    public abstract Class<T> strategyInterface();
}
