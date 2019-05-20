package com.powerledger.assignment.sortingrestapi.unittests;

import com.powerledger.assignment.sortingrestapi.sortstrategy.MergeSort;

/**
 * Created by @author Sankash on 5/10/2019
 */
public class MergeSortTest extends BaseSortTest {
    @Override
    protected void sort(Integer[] array) {
        new MergeSort().sort(array);
    }
}
