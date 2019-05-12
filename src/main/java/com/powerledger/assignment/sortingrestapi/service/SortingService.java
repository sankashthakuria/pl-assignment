package com.powerledger.assignment.sortingrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by @author Sankash on 5/11/2019
 */
@Component
public class SortingService {

    @Autowired
    private BubbleSort bubbleSort;

    @Autowired
    private HeapSort heapSort;

    @Autowired
    private InsertionSort insertionSort;

    @Autowired
    private MergeSort mergeSort;

    @Autowired
    private QuickSort quickSort;

    @Autowired
    private SelectionSort selectionSort;

    @Autowired
    private ShellSort shellSort;

    public Sortable getInstace(SortingAlgorithm e) {
        switch (e) {
            case BUBBLE_SORT:
                return bubbleSort;
            case INSERTION_SORT:
                return insertionSort;
            case HEAP_SORT:
                return heapSort;
            case MERGE_SORT:
                return mergeSort;
            case QUICK_SORT:
                return quickSort;
            case SELECTION_SORT:
                return selectionSort;
            case SHELL_SORT:
                return shellSort;
            default:
                return bubbleSort;

        }

    }

    public <T extends Comparable<T>> int[] convertToInts(String[] array){
        return Stream.of(array).mapToInt(Integer::parseInt).toArray();
    }

}
