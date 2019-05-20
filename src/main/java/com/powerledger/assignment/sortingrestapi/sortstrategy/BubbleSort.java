package com.powerledger.assignment.sortingrestapi.sortstrategy;

import com.powerledger.assignment.sortingrestapi.annotation.SortingStrategy;
import com.powerledger.assignment.sortingrestapi.model.ApiResponse;
import com.powerledger.assignment.sortingrestapi.model.ComplexityInfo;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

import static com.powerledger.assignment.sortingrestapi.sortstrategy.SortUtils.less;
import static com.powerledger.assignment.sortingrestapi.sortstrategy.SortUtils.swap;

/**
 * Created by @author Sankash on 5/10/2019
 */
@SortingStrategy("bubble")
@Log4j2
public class BubbleSort implements Sortable {


    /**
     * This method implements the Generic Bubble Sort
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
     *              Sorts the array in increasing order
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T array[]) {
        int unsortedBelow = array.length;
        while (unsortedBelow != 0) {
            int lastSwap = 0;
            for (int i = 1; i < unsortedBelow; i++) {
                if (!less(array[i - 1], array[i])) {
                    swap(array, i, i - 1);
                    lastSwap = i;
                }
            }
            unsortedBelow = lastSwap;
        }
        return array;
    }

    @Override
    public <T extends Comparable> ApiResponse performSort(T[] array){
        log.info("Performing bubble sort on {}",Arrays.toString(array));
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
