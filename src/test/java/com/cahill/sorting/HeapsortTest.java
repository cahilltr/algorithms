package com.cahill.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class HeapsortTest {
    private static final int[] expectedArray = new int[]{16,14,10,8,7,9,3,2,4,1};

    @Test
    public void heapify() throws Exception {
        int[] testArray = new int[]{16,4,10,14,7,9,3,2,8,1};

        //only succeeds with i = 2
        int[] resultArray = Heapsort.heapify(testArray, 2);
        System.out.println(Arrays.toString(resultArray));
        assertArrayEquals(resultArray, expectedArray);
    }

    @Test
    public void testBuildHeap() {
        int[] testArray = {4,1,3,2,16,9,10,14,8,7};

        Heapsort.buildHeap(testArray);
        System.out.println(Arrays.toString(testArray));
        assertArrayEquals(testArray, expectedArray);
    }

    @Test
    public void testHeapSort() {
        int[] sortedArray = {16, 14, 10, 9, 8, 7, 4, 3, 2, 1};
        int[] testArray = {4,1,3,2,16,9,10,14,8,7};
        int[] resultArray = Heapsort.heapSort(testArray);
        System.out.println(Arrays.toString(resultArray));
        assertArrayEquals(resultArray, sortedArray);
    }

    @Test
    public void testHeapSortGenericDescending() {
        String[] input = new String[]{"Hello", "This", "Is", "A", "Test"};

        String[] output = Heapsort.heapSortGeneric(input);

        System.out.println(Arrays.toString(output));

        IntStream.range(0, output.length).forEach(i -> {if (i < output.length - 1) {
            assertTrue(output[i].compareTo(output[i + 1]) > 0);
        } else {
            assertTrue(output[i].compareTo(output[i - 1]) < 0);
        }});
    }
}