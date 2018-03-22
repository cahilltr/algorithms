package com.cahill.sorting;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Only did the Heapsort portion of Chapter 7.  PriorityQueue portion will wait till I feel like completing it.
 */
public class Heapsort {

    static Function<Integer, Integer> parentOfI = i -> Math.floorDiv(i, 2);
    static Function<Integer, Integer> leftOfI = i -> 2*i;
    static Function<Integer, Integer> rightOfI = i -> leftOfI.apply(i) + 1;

    //Account for 0 vs 1
    static int[] heapify(int[] input, int i) {
        int l = leftOfI.apply(i);
        int r = rightOfI.apply(i);

        int heapSize = input.length;
        int largest;

        if (l <= heapSize && input[l - 1] > input[i - 1]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r <= heapSize && input[r - 1] > input[largest - 1]) {
            largest = r;
        }

        if (largest != i) {
            int iValue = input[i - 1];
            int largestValue = input[largest - 1];
            input[i - 1] = largestValue;
            input[largest - 1] = iValue;
            input = heapify(input, largest);
        }
        return input;
    }

    static <T extends Comparable<? super T>> T[] heapifyGeneric(T[] input, int i) {
        int l = leftOfI.apply(i);
        int r = rightOfI.apply(i);

        int heapSize = input.length;
        int largest;

        if (l <= heapSize && input[l - 1].compareTo(input[i - 1]) > 0) {
            largest = l;
        } else {
            largest = i;
        }

        if (r <= heapSize && input[r - 1].compareTo(input[largest - 1]) > 0) {
            largest = r;
        }

        if (largest != i) {
            T iValue = input[i - 1];
            T largestValue = input[largest - 1];
            input[i - 1] = largestValue;
            input[largest - 1] = iValue;
            input = heapifyGeneric(input, largest);
        }
        return input;
    }

    static void buildHeap(int[] input) {
        for (int i = Math.floorDiv(input.length, 2); i >= 1; i--) {
            heapify(input, i);
        }
    }

    static <T extends Comparable<? super T>> void buildHeapGeneric(T[] input) {
        for (int i = Math.floorDiv(input.length, 2); i >= 1; i--) {
            heapifyGeneric(input, i);
        }
    }

    static int[] heapSort(int[] input) {
        if (input == null) return new int[0];
        int originalHeapSize = input.length;
        int[] output = new int[originalHeapSize];

        buildHeap(input);
        for (int i = input.length; i >= 2; i--) {
            int array1 = input[0];
            int arrayI = input[i - 1];
            input[0] = arrayI;
            output[originalHeapSize - input.length] = array1;
            input = heapify(Arrays.copyOfRange(input, 1, input.length), 1);
        }
        output[originalHeapSize - 1] = input[0];
        return output;
    }

    static <T extends Comparable<? super T>> T[] heapSortGeneric(T[] input) {
        if (input == null) return null;
        int originalHeapSize = input.length;
        T[] output = Arrays.copyOf(input, originalHeapSize);

        buildHeapGeneric(input);
        for (int i = input.length; i >= 2; i--) {
            T array1 = input[0];
            T arrayI = input[i - 1];
            input[0] = arrayI;
            output[originalHeapSize - input.length] = array1;
            input = heapifyGeneric(Arrays.copyOfRange(input, 1, input.length), 1);
        }
        output[originalHeapSize - 1] = input[0];
        return output;
    }

}
