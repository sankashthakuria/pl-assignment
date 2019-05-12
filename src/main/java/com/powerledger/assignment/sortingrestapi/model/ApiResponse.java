package com.powerledger.assignment.sortingrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by @author Sankash on 5/11/2019
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiResponse<T> {

    String bestCaseComplexity;
    String averageCaseComplexity;
    String worstCaseComplexity;
    String spaceComplexity;
    String comment;
    private T array[];


}
