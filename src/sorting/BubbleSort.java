package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {12,4,7,3,5,1,9};
        System.out.println("Original: "+ Arrays.toString(input));
        System.out.println("Sorted: "+ Arrays.toString(solution(input)));
    }

    private static int[] solution(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int temp;
            for (int j = 0; j < array.length -1 -i; j++) {
                if (array[j] > array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }
}
