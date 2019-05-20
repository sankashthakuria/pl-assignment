package com.powerledger.assignment.sortingrestapi.service;

import com.powerledger.assignment.sortingrestapi.annotation.SortingStrategy;
import com.powerledger.assignment.sortingrestapi.factory.AnnotatedSorterFactory;
import com.powerledger.assignment.sortingrestapi.sortstrategy.Sortable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * Created by @author Sankash on 5/13/2019
 */
@Component
@ApplicationScope
public class SortingService extends AnnotatedSorterFactory<SortingStrategy, Sortable> {
    @Override
    public Class<SortingStrategy> strategyAnnotation() {
        return SortingStrategy.class;
    }

    @Override
    public Class<Sortable> strategyInterface() {
        return Sortable.class;
    }
}
