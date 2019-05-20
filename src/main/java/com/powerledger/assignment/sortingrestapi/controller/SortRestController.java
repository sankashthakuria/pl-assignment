package com.powerledger.assignment.sortingrestapi.controller;

import com.powerledger.assignment.sortingrestapi.service.SortingService;
import com.powerledger.assignment.sortingrestapi.model.ApiResponse;
import com.powerledger.assignment.sortingrestapi.sortstrategy.Sortable;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * Created by @author Sankash on 5/11/2019
 */

@RestController
@RequestMapping("/api/v1")
@Log4j2
public class SortRestController<T> {

    private static final String DEFAULT_LIST = "4,3,2,1";

    @Autowired
    private SortingService sortingService;

    @ApiOperation(value = "Perform sort on a list of numbers", response = ApiResponse.class, notes = "Performs sorting on array of integers - pass the values separated by commas")

    @RequestMapping(path = "/{strategy:\\w+}", method = RequestMethod.GET)
    public <T extends Comparable<T>> ApiResponse doSort(@ApiParam(allowableValues = "bubble, heap, insertion, merge, quick, selection, shell") @PathVariable(name = "strategy") @Valid @NotEmpty String strategy, @RequestParam(value = "listOfItemsToSort", defaultValue = DEFAULT_LIST) Long[] listOfItems) throws IllegalAccessException {
        Sortable sorter = sortingService.getImplementation(strategy);
        return sorter.performSort(listOfItems);
    }
}
