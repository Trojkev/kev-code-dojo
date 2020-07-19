package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] input = {8,10,3,6,4,2,7};
        System.out.println(
                "Unsorted: "+ Arrays.toString(input) +"\nSorted: "+ Arrays.toString(sortItems(input)));
    }

    /**
     * Selection sort algorithm implementation.
     * We identify the smallest item in the input array and record it's index, then we swap the first unsorted
     * element with the element at min index
     * Time complexity : O(n^2) -> we are looping n times for every item in the array
     * Space complexity : O(1) -> we are only using two variables and sorting array in space
     * @param array the input array to be sorted
     * @return a sorted version of the input array
     */
    private static int[] sortItems(int[] array){
        if (array == null) {
            return new int[]{};
        } else if (array.length < 2) return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }
}
