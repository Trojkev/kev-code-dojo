package searching;

import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] input = {4,8,5,7,2,4,6,9};
        int item = 3;
        System.out.println(
                "Input: "+ Arrays.toString(input)+"\nSearch: "+item+"\nIndex :"+searchItem(input, item));
    }

    /**
     * Search through an array for the first occurrence of the provided item.
     * If found, return it's index. else, return -1
     * Time complexity: O(n) -> at worst case we might check all the elements of the array
     * Space complexity: O(1) -> we are not creating any variables or arrays
     *
     * @param input the input array to be searched
     * @param item the item being searched in the array
     * @return the index of the item in the array if present, else -1
     */
    private static int searchItem(int[] input, int item) {
        if (input == null) return -1;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == item)
                return i;
        }

        return -1;
    }
}
