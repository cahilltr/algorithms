package com.cahill.sorting;

public class InsertionSort {

    public static int[] sortAscending(int[] input) {
        int i = 1;
        while (i < input.length) {
            int j = i;
            while ( j > 0 && input[j - 1] > input[j]) {
                //swap input[j] and input[j-1]
                int jminus1 = input[j - 1];
                int jvalue = input[j];
                input[j - 1] = jvalue;
                input[j] = jminus1;
                j--;
            }
            i++;
        }
        return input;
    }

    //The difference between Ascending and Descending is the check of input[j - 1] < input[j] (for descending) and input[j - 1] > input[j] (for ascending)
    public static int[] sortDescending(int[] input) {
        int i = 1;
        while (i < input.length) {
            int j = i;
            while ( j > 0 && input[j - 1] < input[j]) {
                //swap input[j] and input[j-1]
                int jminus1 = input[j - 1];
                int jvalue = input[j];
                input[j - 1] = jvalue;
                input[j] = jminus1;
                j--;
            }
            i++;
        }
        return input;
    }

    public static <T extends Comparable<? super T>> T[] sortGenericAscending(T[] input) {
        int i = 1;
        while (i < input.length) {
            int j = i;
            while (j > 0 && input[j - 1].compareTo(input[j]) > 0) {
                T jplus1 = input[j - 1];
                T jvalue = input[j];
                input[j - 1] = jvalue;
                input[j] = jplus1;
                j--;
            }
            i++;
        }
        return input;
    }

    public static <T extends Comparable<? super T>> T[] sortGenericDescending(T[] input) {
        int i = 1;
        while (i < input.length) {
            int j = i;
            while (j > 0 && input[j - 1].compareTo(input[j]) < 0) {
                T jplus1 = input[j - 1];
                T jvalue = input[j];
                input[j - 1] = jvalue;
                input[j] = jplus1;
                j--;
            }
            i++;
        }
        return input;
    }

}
