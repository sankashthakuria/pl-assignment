package com.powerledger.assignment.sortingrestapi.sortstrategy;

import com.powerledger.assignment.sortingrestapi.annotation.SortingStrategy;
import com.powerledger.assignment.sortingrestapi.model.ApiResponse;
import com.powerledger.assignment.sortingrestapi.model.ComplexityInfo;

import static com.powerledger.assignment.sortingrestapi.sortstrategy.SortUtils.less;
import static com.powerledger.assignment.sortingrestapi.sortstrategy.SortUtils.swap;

/**
 * Created by @author Sankash on 5/10/2019
 */
@SortingStrategy("quick")
public class QuickSort implements Sortable {

    /**
     * The sorting process
     *
     * @param left  The first index of an array
     * @param right The last index of an array
     * @param array The array to be sorted
     **/

    private static <T extends Comparable<T>> void doSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }

    /**
     * This method finds the partition index for an array
     *
     * @param array The array to be sorted
     * @param left  The first index of an array
     * @param right The last index of an array
     *              Finds the partition index of an array
     **/

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) / 2;
        T pivot = array[mid];

        while (left <= right) {
            while (less(array[left], pivot)) {
                ++left;
            }
            while (less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                swap(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    /**
     * This method implements the Generic Quick Sort
     *
     * <p>
     * Has a worst case running time of:
     * O(n log n)
     * <p>
     * Has a average case running time of:
     * O(n log n)
     * <p>
     * And a best case running time of:
     * O(n log n)
     * <p>
     * Space complexity of:
     * O(n) in worst case and O(log n) in average case
     * <p>
     *
     * @param array The array to be sorted
     *              Sorts the array in increasing order
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    @Override
    public <T extends Comparable> ApiResponse performSort(T[] array){
        return  ApiResponse.builder()
                .array(sort(array))
                .complexityInfo(
                        ComplexityInfo.builder()
                                .averageComplexity("O(n log n)")
                                .bestComplexity("O(n log n)")
                                .worstComplexity("O(n log n)")
                                .spaceComplexity("O(n) in worst case and O(log n) in average case")
                                .build()
                )
                .build();
    }
}
