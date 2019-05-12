package com.powerledger.assignment.sortingrestapi.integrationtests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerledger.assignment.sortingrestapi.model.ApiResponse;
import com.powerledger.assignment.sortingrestapi.service.*;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by @author Sankash on 5/12/2019
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("convertToInts")
public class SortingControllerTests {
    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private SortingService mock;

    @MockBean
    private BubbleSort bubbleSort;


    @Test
    public void test_bubblesort_interaction() throws JSONException {
        when(mock.getInstace(SortingAlgorithm.BUBBLE_SORT)).thenReturn(new BubbleSort());
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity("/api/v1/bubblesort?listOfItemsToSort=4,3,2,1", ApiResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());
        verify(mock, times(1)).getInstace(SortingAlgorithm.BUBBLE_SORT);
        assertArrayEquals(Arrays.asList(1,2,3,4).toArray(),(response.getBody().getArray()));
    }

    @Test
    public void test_heapsort_interaction() throws JSONException {
        when(mock.getInstace(SortingAlgorithm.HEAP_SORT)).thenReturn(new HeapSort());
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity("/api/v1/heapsort?listOfItemsToSort=4,3,2,1", ApiResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());
        verify(mock, times(1)).getInstace(SortingAlgorithm.HEAP_SORT);
        assertArrayEquals(Arrays.asList(1,2,3,4).toArray(),(response.getBody().getArray()));
    }

    @Test
    public void test_insertionsort_interaction() throws JSONException {
        when(mock.getInstace(SortingAlgorithm.INSERTION_SORT)).thenReturn(new InsertionSort());
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity("/api/v1/insertionsort?listOfItemsToSort=4,3,2,1", ApiResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());
        verify(mock, times(1)).getInstace(SortingAlgorithm.INSERTION_SORT);
        assertArrayEquals(Arrays.asList(1,2,3,4).toArray(),(response.getBody().getArray()));
    }

    @Test
    public void test_mergesort_interaction() throws JSONException {
        when(mock.getInstace(SortingAlgorithm.MERGE_SORT)).thenReturn(new MergeSort());
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity("/api/v1/mergesort?listOfItemsToSort=4,3,2,1", ApiResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());
        verify(mock, times(1)).getInstace(SortingAlgorithm.MERGE_SORT);
        assertArrayEquals(Arrays.asList(1,2,3,4).toArray(),(response.getBody().getArray()));
    }

    @Test
    public void test_quicksort_interaction() throws JSONException {
        when(mock.getInstace(SortingAlgorithm.QUICK_SORT)).thenReturn(new QuickSort());
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity("/api/v1/quicksort?listOfItemsToSort=4,3,2,1", ApiResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());
        verify(mock, times(1)).getInstace(SortingAlgorithm.QUICK_SORT);
        assertArrayEquals(Arrays.asList(1,2,3,4).toArray(),(response.getBody().getArray()));
    }

    @Test
    public void test_selectionsort_interaction() throws JSONException {
        when(mock.getInstace(SortingAlgorithm.SELECTION_SORT)).thenReturn(new SelectionSort());
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity("/api/v1/selectionsort?listOfItemsToSort=4,3,2,1", ApiResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());
        verify(mock, times(1)).getInstace(SortingAlgorithm.SELECTION_SORT);
        assertArrayEquals(Arrays.asList(1,2,3,4).toArray(),(response.getBody().getArray()));
    }

    @Test
    public void test_shellsort_interaction() throws JSONException {
        when(mock.getInstace(SortingAlgorithm.SHELL_SORT)).thenReturn(new ShellSort());
        ResponseEntity<ApiResponse> response = restTemplate.getForEntity("/api/v1/shellsort?listOfItemsToSort=4,3,2,1", ApiResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8, response.getHeaders().getContentType());
        verify(mock, times(1)).getInstace(SortingAlgorithm.SHELL_SORT);
        assertArrayEquals(Arrays.asList(1,2,3,4).toArray(),(response.getBody().getArray()));
    }

}
