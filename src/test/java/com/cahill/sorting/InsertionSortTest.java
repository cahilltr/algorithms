package com.cahill.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class InsertionSortTest {

    @org.junit.Test
    public void sortIntegers() throws Exception {
        int[] input = new int[]{31, 41, 59, 26, 41, 58};
        int[] output = InsertionSort.sortAscending(input);

        IntStream.range(0, output.length).forEach(i -> {if (i < output.length - 1) {
                assertTrue(output[i] <= output[i + 1]);
            } else {
                assertTrue(output[i] > output[i - 1]);
            }});

        Arrays.stream(output).forEach(System.out::println);
    }

    @org.junit.Test
    public void sortIntegersDescending() throws Exception {
        int[] input = new int[]{31, 41, 59, 26, 41, 58};
        int[] output = InsertionSort.sortDescending(input);

        IntStream.range(0, output.length).forEach(i -> {
            if (i < output.length - 1) {
                assertTrue(output[i] >= output[i + 1]);
            } else {
                assertTrue(output[i] < output[i - 1]);
            }
        });

        Arrays.stream(output).forEach(System.out::println);
    }

    @org.junit.Test
    public void sortGenericsAscending() throws Exception {
        String[] input = new String[]{"Hello", "This", "Is", "A", "Test"};
        String[] output = InsertionSort.sortGenericAscending(input);

        IntStream.range(0, output.length).forEach(i -> {if (i < output.length - 1) {
                        assertTrue(output[i].compareTo(output[i + 1]) < 0);
        } else {
            assertTrue(output[i].compareTo(output[i - 1]) > 0);
        }});

        Arrays.stream(output).forEach(System.out::println);
    }

    @org.junit.Test
    public void sortGenericsDescending() throws Exception {
        String[] input = new String[]{"Hello", "This", "Is", "A", "Test"};
        String[] output = InsertionSort.sortGenericDescending(input);

        IntStream.range(0, output.length).forEach(i -> {if (i < output.length - 1) {
                        assertTrue(output[i].compareTo(output[i + 1]) > 0);
        } else {
            assertTrue(output[i].compareTo(output[i - 1]) < 0);
        }});

        Arrays.stream(output).forEach(System.out::println);
    }

}