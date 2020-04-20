package practice;


public class BinStacking {
    public static void main(String[] args) {
        int[] items = {2, 5, 4, 7, 1, 3, 8};
        System.out.println("Next Fit Bins Used: "+nextFit (items, 10));

        System.out.println("First Fit Bins Used: "+firstFit (items, 10));

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
}
