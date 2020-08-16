package sorting;

import java.util.Arrays;

/**
 * This class implements a Bubble sort algorithm
 * Time complexity : O(n^2)
 * Space complexity : O(1)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {12,4,7,3,5,1,9};
        System.out.println("Original: "+ Arrays.toString(input));
        System.out.println("Sorted: "+ Arrays.toString(solution(input)));
    }

    /**
     * Implementation of bubble sort algorithm.
     * The largest element gets 'bubbled all the way to the end'
     * and the process gets repeated for all elements in the input array
     * The array is always sorted in place.
     *
     * @param array the input array which is to be sorted.
     * @return a sorted version of the input array
     */
    private static int[] solution(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length -1 -i; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }
}
