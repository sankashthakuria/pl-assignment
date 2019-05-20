package com.powerledger.assignment.sortingrestapi.unittests;

import com.powerledger.assignment.sortingrestapi.sortstrategy.InsertionSort;

/**
 * Created by @author Sankash on 5/10/2019
 */
public class InsertionSortTest extends BaseSortTest {
    @Override
    protected void sort(Integer[] array) {
        new InsertionSort().sort(array);
    }
}
