package com.powerledger.assignment.sortingrestapi.service;

import org.springframework.stereotype.Component;

import static com.powerledger.assignment.sortingrestapi.service.SortUtils.less;
import static com.powerledger.assignment.sortingrestapi.service.SortUtils.swap;

/**
 * Created by @author Sankash on 5/10/2019
 */
@Component
public class ShellSort implements Sortable {

    /**
     * This method implements Generic Shell Sort.
     *
     * <p>
     * Worst and average case depends on the sequence gap
     * <p>
     * And a best case running time of:
     * O(n log n)
     * <p>
     * Space complexity of:
     * O(1)
     * <p>
     *
     * @param array The array to be sorted
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int N = array.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    swap(array, j, j - h);
                }
            }

            h /= 3;
        }

        return array;
    }
}