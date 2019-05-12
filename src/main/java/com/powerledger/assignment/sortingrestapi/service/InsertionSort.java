package com.powerledger.assignment.sortingrestapi.service;

import org.springframework.stereotype.Component;

import static com.powerledger.assignment.sortingrestapi.service.SortUtils.less;

/**
 * Created by @author Sankash on 5/10/2019
 */
@Component
public class InsertionSort implements Sortable {
    /**
     * This method implements the Generic Insertion Sort
     * Sorts the array in increasing order
     *
     * <p>
     * Has a worst case running time of:
     * O(n^2)
     * <p>
     * Has a average case running time of:
     * O(n^2)
     * <p>
     * And a best case running time of:
     * O(n)
     * <p>
     * Space complexity of:
     * O(1)
     * <p>
     *
     * @param array The array to be sorted
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int j = 1; j < array.length; j++) {

            // Picking up the key(Card)
            T key = array[j];
            int i = j - 1;

            while (i >= 0 && less(key, array[i])) {
                array[i + 1] = array[i];
                i--;
            }
            // Placing the key (Card) at its correct position in the sorted subarray
            array[i + 1] = key;
        }
        return array;
    }
}