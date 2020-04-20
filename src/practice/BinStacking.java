package practice;


public class BinStacking {
    public static void main(String[] args) {
        int[] items = {2, 5, 4, 7, 1, 3, 8};
        System.out.println("Next Fit Bins Used: "+nextFit (items, 10));

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
}
