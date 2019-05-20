package com.powerledger.assignment.sortingrestapi.sortstrategy;

import com.powerledger.assignment.sortingrestapi.annotation.SortingStrategy;
import com.powerledger.assignment.sortingrestapi.model.ApiResponse;
import com.powerledger.assignment.sortingrestapi.model.ComplexityInfo;

import static com.powerledger.assignment.sortingrestapi.sortstrategy.SortUtils.less;
import static com.powerledger.assignment.sortingrestapi.sortstrategy.SortUtils.swap;

/**
 * Created by @author Sankash on 5/10/2019
 */
@SortingStrategy("shell")
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

    @Override
    public <T extends Comparable> ApiResponse performSort(T[] array){
        return  ApiResponse.builder()
                .array(sort(array))
                .complexityInfo(
                        ComplexityInfo.builder()
                                .averageComplexity("Worst and average case depends on the sequence gap")
                                .bestComplexity("O(n log n)")
                                .worstComplexity("Worst and average case depends on the sequence gap")
                                .spaceComplexity("O(1)")
                                .build()
                )
                .build();
    }
}