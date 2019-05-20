package com.powerledger.assignment.sortingrestapi.sortstrategy;

import com.powerledger.assignment.sortingrestapi.annotation.SortingStrategy;
import com.powerledger.assignment.sortingrestapi.model.ApiResponse;
import com.powerledger.assignment.sortingrestapi.model.ComplexityInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.powerledger.assignment.sortingrestapi.sortstrategy.SortUtils.less;
import static com.powerledger.assignment.sortingrestapi.sortstrategy.SortUtils.swap;

/**
 * Created by @author Sankash on 5/11/2019
 */
@SortingStrategy("heap")
public class HeapSort implements Sortable {
    /**
     * This method implements Generic Shell Sort.
     *
     * <p>
     * Has a worst case running time of:
     * O(n log n)
     * <p>
     * Has a average case running time of:
     * O(n log n)
     * <p>
     * And a best case running time of:
     * O(n log n )
     * <p>
     * Space complexity of:
     * O(1)
     * <p>
     *
     * @param unsorted The array to be sorted
     */

    public <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
        int size = unsorted.size();

        @SuppressWarnings("unchecked")
        Heap<T> heap = new Heap<>(unsorted.toArray((T[]) new Comparable[unsorted.size()]));

        heap.makeMinHeap(0); // make min heap using index 0 as root.
        List<T> sorted = new ArrayList<>(size);
        while (size > 0) {
            T min = heap.getRoot(--size);
            sorted.add(min);
        }

        return sorted;
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        return sort(Arrays.asList(unsorted)).toArray(unsorted);
    }

    private static class Heap<T extends Comparable<T>> {
        /**
         * Array to store heap
         */
        private T[] heap;

        /**
         * Constructor
         *
         * @param heap array of unordered integers
         */
        public Heap(T[] heap) {
            this.heap = heap;
        }

        /**
         * Heapifies subtree from top as root to last as last child
         *
         * @param rootIndex index of root
         * @param lastChild index of last child
         */
        private void heapSubtree(int rootIndex, int lastChild) {
            int leftIndex = rootIndex * 2 + 1;
            int rightIndex = rootIndex * 2 + 2;
            T root = heap[rootIndex];
            if (rightIndex <= lastChild) { // if has right and left children
                T left = heap[leftIndex];
                T right = heap[rightIndex];
                if (less(left, right) && less(left, root)) {
                    swap(heap, leftIndex, rootIndex);
                    heapSubtree(leftIndex, lastChild);
                } else if (less(right, root)) {
                    swap(heap, rightIndex, rootIndex);
                    heapSubtree(rightIndex, lastChild);
                }
            } else if (leftIndex <= lastChild) { // if no right child, but has left child
                T left = heap[leftIndex];
                if (less(left, root)) {
                    swap(heap, leftIndex, rootIndex);
                    heapSubtree(leftIndex, lastChild);
                }
            }
        }


        /**
         * Makes heap with root as root
         *
         * @param root index of root of heap
         */
        private void makeMinHeap(int root) {
            int leftIndex = root * 2 + 1;
            int rightIndex = root * 2 + 2;
            boolean hasLeftChild = leftIndex < heap.length;
            boolean hasRightChild = rightIndex < heap.length;
            if (hasRightChild) { //if has left and right
                makeMinHeap(leftIndex);
                makeMinHeap(rightIndex);
                heapSubtree(root, heap.length - 1);
            } else if (hasLeftChild) {
                heapSubtree(root, heap.length - 1);
            }
        }

        /**
         * Gets the root of heap
         *
         * @return root of heap
         */
        private T getRoot(int size) {
            swap(heap, 0, size);
            heapSubtree(0, size - 1);
            return heap[size]; // return old root
        }


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
                                .spaceComplexity("O(1)")
                                .build()
                )
                .build();
    }


}
