package searching;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] input = {2,3,4,5,6,7,8,9,10,12,15};
        int item = 12;
        System.out.println(
                "Input: "+ Arrays.toString(input)+"\nItem: "+item+
                "\nIndex: "+searchItem(input, item));
    }

    /**
     * Binary search algorithm implementation
     * We take in a sorted array of integers and the element we need.
     * find the mid point of the array and check if the element we are searching is at the center,
     * if so, we return the index.
     * If element we are searching is less than item at the center, we check on the lower half, else the upper
     * if the element is not found, we return -1
     *
     * Time complexity: O(logn) -> the input halves with every check
     * Space complexity: O(1) -> we need constant memory to store the start, mid and end variables
     * @param input the input array we are searching from
     * @param item the item being searched
     * @return first index of the item occurrence if present, else -1
     */
    private static int searchItem(int[] input, int item) {
        if (input == null) return -1;

        int start = 0;
        int end = input.length-1;
        int mid = (int) Math.floor((start+end)/2);

        for (int i = 0; i < input.length; i++) {
            if (input[mid] == item)
                return mid;
            if (item < input[mid]){
                end = mid;
                mid = (int) Math.floor((start+end)/2);
            } else {
                start = mid;
                mid = (int) Math.floor((start+end)/2);
            }
        }
        return -1;
    }
}
