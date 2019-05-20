package com.powerledger.assignment.sortingrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by @author Sankash on 5/13/2019
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ComplexityInfo {
    private String spaceComplexity;
    private String averageComplexity;
    private String worstComplexity;
    private String bestComplexity;
}
