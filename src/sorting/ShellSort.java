package sorting;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] input = {7, 3, 9, 34, 12, 59, 42, 18};
        System.out.println("Input: "+ Arrays.toString(input));
        int[] sorted = shellSort(input);
        System.out.println("Output: "+ Arrays.toString(sorted));
    }

    private static int[] shellSort(int[] array){
        int n = array.length;

        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];

                int j;
                for (j = i; j >= gap && array[j-gap] > temp; j -= gap) {
                    array[j] = array[j-gap];
                }
                array[j] = temp;
            }
        }

        return array;
    }
}
