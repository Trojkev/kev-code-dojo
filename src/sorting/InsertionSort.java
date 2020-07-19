package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] unsorted = {7, 8, 5, 2, 4, 6, 3};
        int[] sorted = sort(unsorted);
        System.out.println("Sorted array: " + Arrays.toString(sorted));
    }

    /**
     * This function takes in an unsorted integer array and sorts it using the
     * insertion sorting technique, and then returns the sorted array
     *
     * @param unsorted the unsorted array to be sorted
     * @return a sorted array
     */
    private static int[] sort(int[] unsorted) {
        if (unsorted == null) return new int[]{};
        else if (unsorted.length < 2) return unsorted;

        for (int i = 1; i < unsorted.length; i++) {
            int current = unsorted[i];

            int j = i - 1;
            while (j >= 0 && unsorted[j] > current) {
                unsorted[j + 1] = unsorted[j];
                j--;
            }
            unsorted[j + 1] = current;
        }

        return unsorted;
    }
}
