package com.powerledger.assignment.sortingrestapi.unittests;


import com.powerledger.assignment.sortingrestapi.sortstrategy.SelectionSort;

/**
 * Created by @author Sankash on 5/10/2019
 */
public class SelectionSortTest extends BaseSortTest {
    @Override
    protected void sort(Integer[] array) {
        new SelectionSort().sort(array);
    }
}
