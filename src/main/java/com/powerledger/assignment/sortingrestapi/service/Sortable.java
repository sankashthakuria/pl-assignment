package com.powerledger.assignment.sortingrestapi.service;

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

    /**
     * Auxiliary method for algorithms what wanted to work with lists from JCF
     *
     * @param unsorted - a list should be sorted
     * @return a sorted list
     */
}
