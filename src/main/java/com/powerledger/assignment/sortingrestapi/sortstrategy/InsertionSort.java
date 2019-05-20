package com.powerledger.assignment.sortingrestapi.sortstrategy;

import com.powerledger.assignment.sortingrestapi.annotation.SortingStrategy;
import com.powerledger.assignment.sortingrestapi.model.ApiResponse;
import com.powerledger.assignment.sortingrestapi.model.ComplexityInfo;

import static com.powerledger.assignment.sortingrestapi.sortstrategy.SortUtils.less;

/**
 * Created by @author Sankash on 5/10/2019
 */
@SortingStrategy("insertion")
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

    @Override
    public <T extends Comparable> ApiResponse performSort(T[] array){
        return  ApiResponse.builder()
                .array(sort(array))
                .complexityInfo(
                        ComplexityInfo.builder()
                                .averageComplexity("O(n^2)")
                                .bestComplexity("O(n)")
                                .worstComplexity("O(n^2)")
                                .spaceComplexity("O(1)")
                                .build()
                )
                .build();
    }
}