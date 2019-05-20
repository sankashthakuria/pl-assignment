package com.powerledger.assignment.sortingrestapi.integrationtests;

import com.powerledger.assignment.sortingrestapi.controller.SortRestController;
import com.powerledger.assignment.sortingrestapi.service.SortingService;
import com.powerledger.assignment.sortingrestapi.sortstrategy.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by @author Sankash on 5/12/2019
 */

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(SortRestController.class)
public class SortingControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SortingService sortingService;

    @Test
    public void test_bubble_sort() throws Exception {
        given(this.sortingService.getImplementation("bubble"))
                .willReturn(new BubbleSort());
        this.mvc.perform(get("/api/v1/bubble?listOfItemsToSort=4,3,2,1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().json("{\n" +
                "  'complexityInfo': {\n" +
                "    'spaceComplexity': 'O(1)',\n" +
                "    'averageComplexity': 'O(n^2)',\n" +
                "    'worstComplexity': 'O(n^2)',\n" +
                "    'bestComplexity': 'O(n)'\n" +
                "  },\n" +
                "  'array': [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3,\n" +
                "    4\n" +
                "  ]\n" +
                "}"));
    }

    @Test
    public void test_heap_sort() throws Exception {
        given(this.sortingService.getImplementation("heap"))
                .willReturn(new HeapSort());
        this.mvc.perform(get("/api/v1/heap?listOfItemsToSort=4,3,2,1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().json("{\n" +
                "  'complexityInfo': {\n" +
                "    'spaceComplexity': 'O(1)',\n" +
                "    'averageComplexity': 'O(n log n)',\n" +
                "    'worstComplexity': 'O(n log n)',\n" +
                "    'bestComplexity': 'O(n log n)'\n" +
                "  },\n" +
                "  'array': [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3,\n" +
                "    4\n" +
                "  ]\n" +
                "}"));
    }

    @Test
    public void test_insertion_sort() throws Exception {
        given(this.sortingService.getImplementation("insertion"))
                .willReturn(new InsertionSort());
        this.mvc.perform(get("/api/v1/insertion?listOfItemsToSort=4,3,2,1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().json("{\n" +
                "  'complexityInfo': {\n" +
                "    'spaceComplexity': 'O(1)',\n" +
                "    'averageComplexity': 'O(n^2)',\n" +
                "    'worstComplexity': 'O(n^2)',\n" +
                "    'bestComplexity': 'O(n)'\n" +
                "  },\n" +
                "  'array': [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3,\n" +
                "    4\n" +
                "  ]\n" +
                "}"));
    }

    @Test
    public void test_merge_sort() throws Exception {
        given(this.sortingService.getImplementation("merge"))
                .willReturn(new MergeSort());
        this.mvc.perform(get("/api/v1/merge?listOfItemsToSort=4,3,2,1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().json("{\n" +
                "  'complexityInfo': {\n" +
                "    'spaceComplexity': 'O(n)',\n" +
                "    'averageComplexity': 'O(n log n)',\n" +
                "    'worstComplexity': 'O(n log n)',\n" +
                "    'bestComplexity': 'O(n log n)'\n" +
                "  },\n" +
                "  'array': [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3,\n" +
                "    4\n" +
                "  ]\n" +
                "}"));
    }

    @Test
    public void test_quick_sort() throws Exception {
        given(this.sortingService.getImplementation("quick"))
                .willReturn(new QuickSort());
        this.mvc.perform(get("/api/v1/quick?listOfItemsToSort=4,3,2,1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().json("{\n" +
                "  'complexityInfo': {\n" +
                "    'spaceComplexity': 'O(n) in worst case and O(log n) in average case',\n" +
                "    'averageComplexity': 'O(n log n)',\n" +
                "    'worstComplexity': 'O(n log n)',\n" +
                "    'bestComplexity': 'O(n log n)'\n" +
                "  },\n" +
                "  'array': [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3,\n" +
                "    4\n" +
                "  ]\n" +
                "}"));
    }

    @Test
    public void test_selection_sort() throws Exception {
        given(this.sortingService.getImplementation("selection"))
                .willReturn(new SelectionSort());
        this.mvc.perform(get("/api/v1/selection?listOfItemsToSort=4,3,2,1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().json("{\n" +
                "  'complexityInfo': {\n" +
                "    'averageComplexity': 'O(n^2)',\n" +
                "    'bestComplexity': 'O(n^2)',\n" +
                "    'worstComplexity': 'O(n^2)',\n" +
                "    'spaceComplexity': 'O(1)'\n" +
                "  },\n" +
                "  'array': [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3,\n" +
                "    4\n" +
                "  ]\n" +
                "}"));
    }

    @Test
    public void test_shell_sort() throws Exception {
        given(this.sortingService.getImplementation("shell"))
                .willReturn(new ShellSort());
        this.mvc.perform(get("/api/v1/shell?listOfItemsToSort=4,3,2,1").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().json("{\n" +
                "  'complexityInfo': {\n" +
                "    'spaceComplexity': 'O(1)',\n" +
                "    'averageComplexity': 'Worst and average case depends on the sequence gap',\n" +
                "    'worstComplexity': 'Worst and average case depends on the sequence gap',\n" +
                "    'bestComplexity': 'O(n log n)'\n" +
                "  },\n" +
                "  'array': [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3,\n" +
                "    4\n" +
                "  ]\n" +
                "}"));
    }

}
