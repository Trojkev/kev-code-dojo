package practice;


import java.util.Arrays;
import java.util.Collections;

public class BinStacking {
    public static void main(String[] args) {
        int[] items = {2, 5, 4, 7, 1, 3, 8};
        System.out.println("Next Fit Bins Used: "+nextFit (items, 10));

        System.out.println("First Fit Bins Used: "+firstFit (items, 10));

        System.out.println("Best Fit Bins Used: "+bestFit (items, 10));

        Integer[] weights = {2, 5, 4, 7, 1, 3, 8};
        System.out.println("First Fit Decreasing Bins Used: "+firstFitDecreasing (weights, 10));
    }

    /**
     * This algorithm calculates the minimum number of bins required to pack the provided weights given the
     * maximum bin capacity using the Next Fit algorithm
     * @param weights the weights that are to be packed in the bins
     * @param binCapacity the maximum bin capacity of each bean
     * @return the minimum number of bins used
     */
    private static int nextFit(int[] weights, int binCapacity){
        int binRem = binCapacity; // the remaining capacity of a bin
        int bins = 0;

        for (int weight: weights) {
            if (weight > binRem) {
                bins++; // use another bin
                binRem = binCapacity - weight;
            } else binRem -= weight;
        }

        return bins;
    }

    private static int firstFit(int[] weights, int capacity){
        int bins = 0; // initialize bins used to zero
        /* create an array to hold remaining capacity in bins,
        * there can be at most n bins where n is the number of weights to be packed
        * */
        int[] rem_bin = new int[weights.length];

        // let's now place each weight in the first bin where it fits
        for (int weight : weights) {
            // find the first bin that can accommodate the weight
            int j;
            for (j = 0; j < bins; j++) {
                if (weight <= rem_bin[j]){
                    rem_bin[j] -= weight;
                    break;
                }
            }
            // if no bin could accommodate the weight, use a new bin
            if (j == bins) {
                rem_bin[bins] = capacity - weight;
                bins++;
            }
        }
        return bins;
    }

    public static int bestFit(int[] weights, int capacity){
        int bins = 0;
        int[] bin_rem = new int[weights.length];

        // place each weight at a time
        for (int weight: weights) {
            // check the best bin that can accommodate the current weight
            int i;

            // initialize minimum space left in bin and index of best bin
            int min = capacity+1, best = 0;
            for (i = 0; i < bins; i++) {
                if (weight <= bin_rem[i] && bin_rem[i]-weight < min){
                    min = bin_rem[i] -weight;
                    best = i;
                }
            }

            // if no bin could accommodate the weight, we use a new one
            if (min == capacity+1){
                bin_rem[bins] = capacity - weight;
                bins++;
            } else bin_rem[best] -= weight; // assign the weight to the best been so far
        }

        return bins;
    }

    /**
     * This algorithm sorts the input array and then implements the First Fit algorithm
     * It is always guaranteed to use the minimum number of bins possible
     * @param weights the wights to be packed in bins
     * @param capacity the maximum capacity for each bin
     * @return the minimum bins used
     */
    private static int firstFitDecreasing(Integer[] weights, int capacity){
        Arrays.sort(weights, Collections.reverseOrder());

        // convert Integer[] to int[]
        int[] items = new int[weights.length];
        for (int i = 0; i < weights.length; i++) {
            items[i] = weights[i];
        }
        return firstFit(items, capacity);
    }
}
