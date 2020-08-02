package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = {5, 3, 9, 8, 2, 7};
        int start = 0;
        int end = input.length-1;

        System.out.println(Arrays.toString(mergeSort(input, start, end)));
    }

    private static int[] mergeSort(int[] array, int start, int end){
        if (start < end){
            int middle = (start + end)/2;

            mergeSort(array, start, middle);
            mergeSort(array, middle+1, end);

            merge(array, start, middle, end);
        }

        return array;
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        System.arraycopy(array, start, left, 0, n1);
        for (int i = 0; i < n2; i++) {
            right[i] = array[mid+i+1];
        }

        // initial starting indexes of the left and right arrays
        int i = 0, j = 0;
        int k = start; // initial starting point of the merged sub-array array

        while (i < n1 && j < n2){
            if (left[i] <= right[j]){
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        // copy the remaining elements of left to the main array
        while (i < n1){
            array[k] = left[i];
            i++;
            k++;
        }

        // copy the remaining elements of right to the main array
        while (j < n2){
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
