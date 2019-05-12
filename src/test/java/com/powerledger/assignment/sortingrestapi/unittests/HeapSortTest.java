package com.powerledger.assignment.sortingrestapi.unittests;

import com.powerledger.assignment.sortingrestapi.service.HeapSort;

/**
 * Created by @author Sankash on 5/11/2019
 */
public class HeapSortTest extends BaseSortTest {
    @Override
    protected void sort(Integer[] array) {
        new HeapSort().sort(array);
    }
}
