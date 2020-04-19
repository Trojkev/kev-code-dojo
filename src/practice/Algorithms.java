package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Algorithms {
    public static void main(String[] args) {
        // testing the parentheses balancer function
        String braces = "{([]()){}}";
        System.out.println(isBalanced(braces));

        // testing the fibonacci series nth finder
        System.out.println(nthFibonacci(5));

        // testing the bestCandidate function
        int size = 10;
        int[] cands = new int[size];
        for (int i = 0; i < size; i++)
            cands[i] = new Random().nextInt(10);
        System.out.println("Candidates: " + Arrays.toString(cands));
        System.out.println("Best: " + bestCandidate(cands, cands.length));

        // testing longestIncreasingSubSequence function
        int[] seq = {2, 4, 3, 6, 8, 5, 9};
        System.out.println("LIS: " + longestIncreasingSubsequence(seq));
    }

    /**
     * This function takes in a String of parentheses and returns a boolean whether they are balanced parentheses
     * that is if every opening parenthesis has a closing match
     *
     * @param braces The parentheses being validated
     * @return true if matched, false otherwise
     */
    private static boolean isBalanced(String braces) {
        // if the length of the string is odd, then it can't be a balanced, hence we return false
        if (braces.length() % 2 == 1)
            return false;

        List<Character> openers = Arrays.asList('(', '[', '{'); // opening braces
        Stack<Character> lefts = new Stack<>();

        for (int i = 0; i < braces.length(); i++) {
            if (openers.contains(braces.charAt(i))) // check it is an opening brace and push it into the stack
                lefts.push(braces.charAt(i));
            else { // if closing brace, compare it with the top of the stack if not empty and return false if not match
                if (lefts.isEmpty())
                    return false;
                if (lefts.peek() == '[' && braces.charAt(i) != ']' ||
                        lefts.peek() == '(' && braces.charAt(i) != ')' ||
                        lefts.peek() == '{' && braces.charAt(i) != '}')
                    return false;
                lefts.pop();
            }
        }

        return lefts.isEmpty();
    }

    /**
     * takes an integer and returns the fibonacci number at the position indicated by the number
     *
     * @param position the position on the fibonacci series that we want to retrieve the value
     * @return value stored at the specified position on the series
     */
    private static long nthFibonacci(long position) {
        if (position < 0)
            throw new NumberFormatException("Position cannot be negative number");
        if (position <= 2)
            return position - 1;
        return nthFibonacci(position - 1) + nthFibonacci(position - 2);
    }

    /**
     * This function takes in an array of integers and returns the probable highest ising the optimum stopping algorithm
     *
     * @param candidates the strengths of the candidates we are choosing from
     * @param n          the total number of candidates we want to choose from
     * @return an integer indicating the strongest candidate
     */
    private static int bestCandidate(int[] candidates, int n) {
        if (candidates == null || n == 0) // no candidates available
            return -1;
        int sample_size = (int) Math.ceil(n / Math.E);
        System.out.println("Sample size: " + sample_size);
        int optimal = 0;

        for (int i = 1; i < sample_size; i++)
            if (candidates[i] > candidates[optimal])
                optimal = i;

        for (int i = sample_size; i < candidates.length; i++)
            if (candidates[i] >= candidates[optimal]) // found a better candidate
                return candidates[i];

        return candidates[candidates.length - 1]; // got to the end without a candidate
    }

    /**
     * This function takes in an array of integers and returns the sum of the longest increasing sub-sequence
     *
     * @param sequence the array to be processed
     * @return integer denoting the max increasing sub-sequence
     */
    private static int longestIncreasingSubsequence(int[] sequence) {
        if (sequence.length == 0)
            return 0;

        /*
         * we need to solve this problem dynamically, hence we create an array that will hold
         *  the results for each item at an index in the array
         */
        int[] lis = new int[sequence.length];
        Arrays.fill(lis, 1); // we initialize the array with 1

        int max = -1;
        for (int i = 0; i < sequence.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
            max = Math.max(max, lis[i]);
        }

        return max;
    }

    /**
     * A stable tower is one that has a height n from stacked tiles in that no bigger tile is stacked on a smaller tile
     * each tile is assumed to be of constant height.
     * This function returns the total number of stable towers that can be derived from infinite tiles having the
     * provided height, and the largest size of the tiles is provided, and also with the specified number
     * of repetitions.
     *
     * @param height      the maximum height of a stable tower
     * @param maxSize     the size of the largest tile
     * @param repetitions maximum repetitions allowed for a single size tile
     * @return the total number of stable towers achievable
     */
    private static int stableTowerPossibleWays(int height, int maxSize, int repetitions) {
        int N = 100;
        int[][] dp = new int[N][N];
        int[][] preSum = new int[N][N];

        // initialize arrays with zeroes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = 0;
                preSum[i][j] = 0;
            }
        }

        // initializing the 0th row to zero
        for (int i = 1; i < height + 1; i++) {
            dp[0][i] = 0;
            preSum[0][i] = 1;
        }

        // initializing the 0th column to 1
        for (int i = 0; i < maxSize+1; i++) {
            preSum[i][0] = dp[i][0] = 1;
        }

        // here we solve the problem dynamically

        // for each row from 1 to maxSize
        for (int i=1; i<maxSize+1; i++){
            // for each column from 1 to height
            for (int j = 1; j < height+1; j++) {
                // initializing dp[i][j] to preSum[i-1][j]
                dp[i][j] = preSum[i-1][j];
                if (j>repetitions)
                    dp[i][j] -= preSum[i-1][j-repetitions-1];
            }

            // calculating the preSum for every i, 1<=i<=height;
            for (int j = 1; j < height+1; j++) {
                preSum[i][j] = dp[i][j] + preSum[i][j-1];
            }
        }

        return dp[maxSize][height];
    }
}
