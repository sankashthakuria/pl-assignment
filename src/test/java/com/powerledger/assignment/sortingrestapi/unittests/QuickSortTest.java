package com.powerledger.assignment.sortingrestapi.unittests;


import com.powerledger.assignment.sortingrestapi.sortstrategy.QuickSort;

/**
 * Created by @author Sankash on 5/10/2019
 */
public class QuickSortTest extends BaseSortTest {
    @Override
    protected void sort(Integer[] array) {
        new QuickSort().sort(array);
    }
}
