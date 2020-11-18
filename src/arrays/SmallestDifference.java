package arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Write an algorithm that takes in two arrays of integers and returns an array of two integers
 * the first from array one and the second from array two, whose absolute difference is closest to zero
 */
public class SmallestDifference {
    public static void main(String[] args) {
        int[] arrayOne = {-1,5,10,20,28,3};
        int[] arrayTwo = {26,134,135,15,17};

        System.out.printf("Input: %s and %s\n", Arrays.toString(arrayOne), Arrays.toString(arrayTwo));
        System.out.printf("Naive output: %s\n", Arrays.toString(smallestDifferenceNaive(arrayOne, arrayTwo)));
    }

    /**
     * The naive approach is to create a map containing the differences as keys and pairs as the values
     * then iterate the map looking for the smallest key, and return the pairs associated with it.
     *
     * This solution runs in O(n^m) time complexity and O(n^m) space complexity where m and n are the
     * respective sizes of the arrays.
     * @param arrayOne first input array of integers
     * @param arrayTwo second input array of integers
     * @return an array containing two integers with the least absolute difference
     */
    private static int[] smallestDifferenceNaive(int[] arrayOne, int[] arrayTwo){
        HashMap<Integer, String> pairs = new HashMap<>();

        for (int j : arrayOne) {
            for (int k : arrayTwo) {
                int difference = Math.abs(j - k);
                if (!pairs.containsKey(difference))
                    pairs.put(difference, j + "_" + k);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int key: pairs.keySet()) {
            if (key < min) min = key;
        }

        String[] pair = pairs.get(min).split("_");
        return new int[] {Integer.parseInt(pair[0]), Integer.parseInt(pair[1])};
    }
}
