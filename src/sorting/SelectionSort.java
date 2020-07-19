package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] input = {8,10,3,6,4,2,7};
        System.out.println(
                "Unsorted: "+ Arrays.toString(input) +"\nSorted: "+ Arrays.toString(sortItems(input)));
    }

    private static int[] sortItems(int[] array){
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
