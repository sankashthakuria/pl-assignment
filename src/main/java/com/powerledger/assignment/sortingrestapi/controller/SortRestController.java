package com.powerledger.assignment.sortingrestapi.controller;

import com.powerledger.assignment.sortingrestapi.model.ApiResponse;
import com.powerledger.assignment.sortingrestapi.service.SortingAlgorithm;
import com.powerledger.assignment.sortingrestapi.service.SortingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by @author Sankash on 5/11/2019
 */

@RestController
@RequestMapping("/api/v1")
public class SortRestController<T> {

    private static final String DEFAULT_LIST = "4,3,2,1";

    @Autowired
    SortingService sortingService;

    @ApiOperation(value = "Perfrorm BubbleSort", response = ApiResponse.class, notes = "Performs sorting on array of integers - pass the values separated by commas")
    @RequestMapping(path = "/bubblesort", method = RequestMethod.GET)
    public <T extends Comparable<T>> ApiResponse<Object> bubblesort(@RequestParam(value = "listOfItemsToSort", defaultValue = DEFAULT_LIST) Long[] listOfItems) {
        Long[] sort = sortingService.getInstace(SortingAlgorithm.BUBBLE_SORT).sort(listOfItems);
        return ApiResponse.builder()
                .array(sort)
                .averageCaseComplexity("O(n^2)")
                .bestCaseComplexity("O(n)")
                .worstCaseComplexity("O(n^2)")
                .spaceComplexity("O(1)")
                .comment("testing")
                .build();

    }

    @ApiOperation(value = "Perfrorm HeapSort", response = ApiResponse.class, notes = "Performs sorting on array of integers - pass the values seperated by commas")
    @RequestMapping(path = "/heapsort", method = RequestMethod.GET)
    public <T extends Comparable<T>> ApiResponse<Object> heapsort(@RequestParam(value = "listOfItemsToSort", defaultValue = DEFAULT_LIST) Long[] listOfItems) {
        Long[] sort = sortingService.getInstace(SortingAlgorithm.HEAP_SORT).sort(listOfItems);
        return ApiResponse.builder()
                .array(sort)
                .averageCaseComplexity("O(n log n)")
                .bestCaseComplexity("O(n log n)")
                .worstCaseComplexity("O(n log n)")
                .spaceComplexity("O(n log n)")
                .comment("testing")
                .build();
    }

    @ApiOperation(value = "Perfrorm InsertionSort", response = ApiResponse.class, notes = "Performs sorting on array of integers - pass the values seperated by commas")
    @RequestMapping(path = "/insertionsort", method = RequestMethod.GET)
    public <T extends Comparable<T>> ApiResponse<Object> insertionsort(@RequestParam(value = "listOfItemsToSort", defaultValue = DEFAULT_LIST) Long[] listOfItems) {
        Long[] sort =  sortingService.getInstace(SortingAlgorithm.INSERTION_SORT).sort(listOfItems);
        return ApiResponse.builder()
                .array(sort)
                .averageCaseComplexity("O(n^2)")
                .bestCaseComplexity("O(n)")
                .worstCaseComplexity("O(n^2)")
                .spaceComplexity("O(1)")
                .comment("testing")
                .build();
    }

    @ApiOperation(value = "Perfrorm MergeSort", response = ApiResponse.class, notes = "Performs sorting on array of integers - pass the values seperated by commas")
    @RequestMapping(path = "/mergesort", method = RequestMethod.GET)
    public <T extends Comparable<T>> ApiResponse<Object> mergesort(@RequestParam(value = "listOfItemsToSort", defaultValue = DEFAULT_LIST) Long[] listOfItems) {
        Long[] sort =  sortingService.getInstace(SortingAlgorithm.MERGE_SORT).sort(listOfItems);
        return ApiResponse.builder()
                .array(sort)
                .averageCaseComplexity("O(n log n)")
                .bestCaseComplexity("O(n log n)")
                .worstCaseComplexity("O(n log n)")
                .spaceComplexity("O(n)")
                .comment("testing")
                .build();
    }

    @ApiOperation(value = "Perfrorm QuickSort", response = ApiResponse.class, notes = "Performs sorting on array of integers - pass the values seperated by commas")
    @RequestMapping(path = "/quicksort", method = RequestMethod.GET)
    public <T extends Comparable<T>> ApiResponse<Object> quicksort(@RequestParam(value = "listOfItemsToSort", defaultValue = DEFAULT_LIST) Long[] listOfItems) {
        Long [] sort =  sortingService.getInstace(SortingAlgorithm.QUICK_SORT).sort(listOfItems);
        return ApiResponse.builder()
                .array(sort)
                .averageCaseComplexity("O(n log n)")
                .bestCaseComplexity("O(n log n)")
                .worstCaseComplexity("O(n log n)")
                .spaceComplexity("O(n)")
                .comment("testing")
                .build();
    }

    @ApiOperation(value = "Perfrorm SelectionSort", response = ApiResponse.class, notes = "Performs sorting on array of integers - pass the values seperated by commas")
    @RequestMapping(path = "/selectionsort", method = RequestMethod.GET)
    public <T extends Comparable<T>> ApiResponse<Object> selectionsort(@RequestParam(value = "listOfItemsToSort", defaultValue = DEFAULT_LIST) Long[] listOfItems) {
        Long[] sort =  sortingService.getInstace(SortingAlgorithm.SELECTION_SORT).sort(listOfItems);
        return ApiResponse.builder()
                .array(sort)
                .averageCaseComplexity("O(n^2)")
                .bestCaseComplexity("O(n^2)")
                .worstCaseComplexity("O(n^2)")
                .spaceComplexity("O(1)")
                .comment("testing")
                .build();
    }

    @ApiOperation(value = "Perfrorm ShellSort", response = ApiResponse.class, notes = "Performs sorting on array of integers - pass the values seperated by commas")
    @RequestMapping(path = "/shellsort", method = RequestMethod.GET)
    public <T extends Comparable<T>> ApiResponse<Object> shellsort(@RequestParam(value = "listOfItemsToSort", defaultValue = DEFAULT_LIST) Long[] listOfItems) {
        Long[] sort =  sortingService.getInstace(SortingAlgorithm.SHELL_SORT).sort(listOfItems);
        return ApiResponse.builder()
                .array(sort)
                .averageCaseComplexity("Depends on the sequence gap")
                .bestCaseComplexity("O(n log n)")
                .worstCaseComplexity("Depends on the sequence gap")
                .spaceComplexity("O(1)")
                .comment("testing")
                .build();
    }

}
