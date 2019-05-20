package com.powerledger.assignment.sortingrestapi.unittests;

import com.powerledger.assignment.sortingrestapi.sortstrategy.ShellSort;

/**
 * Created by @author Sankash on 5/10/2019
 */
public class ShellSortTest extends BaseSortTest {
    @Override
    protected void sort(Integer[] array) {
        new ShellSort().sort(array);
    }
}
