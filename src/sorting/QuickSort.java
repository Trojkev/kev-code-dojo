package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = {7, 3, 9, 34, 12, 59, 42, 18};
        System.out.println("Input: "+ Arrays.toString(input));
        int[] sorted = quickSort(input, 0, input.length-1);
        System.out.println("Output: "+ Arrays.toString(sorted));
    }

    private static int[] quickSort(int[] array, int start, int end){
        if (start < end){
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot-1);
            quickSort(array, pivot+1, end);
        }
        return array;
    }

    private static int partition(int[] array, int start, int end){
        int pivot = array[end];
        int i = start;

        for (int j = start; j < end; j++) {
            if (array[j] < pivot){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }
}
