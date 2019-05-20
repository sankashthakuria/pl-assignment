package com.powerledger.assignment.sortingrestapi.unittests;

import com.powerledger.assignment.sortingrestapi.sortstrategy.BubbleSort;

/**
 * Created by @author Sankash on 5/10/2019
 */
public class BubbleSortTest extends BaseSortTest {

    @Override
    protected void sort(Integer[] array) {
        new BubbleSort().sort(array);
    }
}
