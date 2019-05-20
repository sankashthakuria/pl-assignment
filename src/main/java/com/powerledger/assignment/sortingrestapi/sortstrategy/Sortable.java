package com.powerledger.assignment.sortingrestapi.sortstrategy;

import com.powerledger.assignment.sortingrestapi.model.ApiResponse;

/**
 * The common interface of most sorting algorithms
 * <p>
 * Created by @author Sankash on 5/10/2019
 */
public interface Sortable {

    /**
     * Main method arrays sorting algorithms
     *
     * @param unsorted - an array should be sorted
     * @return a sorted array
     */
    <T extends Comparable<T>> T[] sort(T[] unsorted);



    default public <T extends Comparable> ApiResponse performSort(T[] array){
        return  ApiResponse.builder().array(sort(array)).build();
    }
}
