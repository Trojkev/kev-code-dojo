package popular_algorithms;

public class KadaneAlgorithm {
    public static void main(String[] args) {
//        int[] input = {3, 5, -7, 4, 1, 9, 6, 8, 2, -18, 22, 1, -3};
        int[] input = {9, -5, -4, 6, -8, 1};
        System.out.println("Maximum sum sub-array is: " + maximumSubArraySum(input));
    }

    private static int maximumSubArraySum(int[] array) {
        int totalMax = array[0];
        int currentMax = array[0];

        for (int i = 1; i < array.length; i++) {
            currentMax = Math.max(array[i], currentMax + array[i]);

            if (currentMax > totalMax)
                totalMax = currentMax;

            System.out.println("Total: "+totalMax +", i: "+i);
        }

        return totalMax;
    }
}
