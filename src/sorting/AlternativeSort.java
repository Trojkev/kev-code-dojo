package sorting;

import java.util.Arrays;

public class AlternativeSort {
    public static void main(String[] args) {
        int[] array = {4,2,6,9,1,8,3,7,5};
        int start = 0;
        int end = array.length - 1;

        System.out.println("Initial array: " + Arrays.toString(array));

        int[] sorted = sortArray(array, start, end);
        System.out.println("Sorted array: " + Arrays.toString(sorted));

        int[] alternativeSorted = alternateSortedArray(sorted);
        System.out.println("Alternative sorted array: " + Arrays.toString(alternativeSorted));
    }

    private static int[] sortArray(int[] array, int start, int end){
        if (start < end) {
            int middle = (start + end) / 2;

            sortArray(array, start, middle); // sort the left half of the input array
            sortArray(array, middle+1, end); // sort the right half of the input array

            mergeArrays(array, start, middle, end); // merge the two sorted halves
        }

        return array;
    }

    private static void mergeArrays(int[] array, int start, int mid, int end){
        int s1 = mid - start + 1;
        int s2 = end - mid;
        int[] left = new int[s1]; // left half of the input array
        int[] right = new int[s2]; // right half of the input array

        System.arraycopy(array, start, left, 0, s1);
        for (int i = 0; i < s2; i++) {
            right[i] = array[mid+i+1];
        }

        int i = 0, j = 0, k = start;
        while (i < s1 && j < s2){
            if (left[i] < right[j])
                array[k++] = left[i++];
            else
                array[k++] = right[j++];
        }

        while (i < s1){
            array[k++] = left[i++];
        }

        while (j < s2){
            array[k++] = right[j++];
        }
    }

    private static int[] alternateSortedArray(int[] array){
        int[] result = new int[array.length];

        int i=0;
        int j = array.length - 1;
        int k = 0;

        while (j > i){
            result[k++] = array[j--];
            result[k++] = array[i++];
        }

        if (array.length %2 != 0)
            result[k] = array[i];

        return result;
    }
}
