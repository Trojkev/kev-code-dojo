package dynamic_programming;

public class SlidingWindow {
    public static void main(String[] args) {
        String text = "aabaaabbabbaabbb";
        System.out.println("Longest Substring: "+ findLongestSubstring(text));

        int[] numbers = {2,5,3,8,7,1,4,1};
        int size = 3;
        System.out.println("Max sub-array sum: "+ maxSubArraySum(numbers, size));
    }

    /**
     * This function takes in a string containing 'a' and 'b' and returns the longest sub-string with less
     * than 3 consecutive identical characters
     * @param text the input string to be processed
     * @return length of the longest sub-string meeting the condition
     */
    private static int findLongestSubstring(String text) {
        // no need to count if total length is less than 3
        if (text.length() < 3) return text.length();

        int maxLen = 0;
        int charCount = 1;
        int runningCount = 1;

        System.out.println(text);
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == text.charAt(i - 1)) charCount ++;
            else charCount = 1;

            if (charCount > 2){
                charCount = 1;
                maxLen = Math.max(maxLen, runningCount);
                runningCount = 1;
                i--;
            } else runningCount ++;

//            System.out.printf(
//                    "Index: %d, Char: %s, charCount: %d, runningCount: %d, maxLen: %d%n",
//                    i, text.charAt(i), charCount, runningCount, maxLen);
        }

        return maxLen;
    }

    /**
     * This function calculates the largest sum obtained by summing a contiguous sub array of size k
     * @param array an array of integers to be processed
     * @param k the size of the sub array to be computed
     * @return the largest sum possible
     */
    private static int maxSubArraySum(int[] array, int k){
        int maxSum = Integer.MIN_VALUE;
        int runningCount = 0;

        for (int i = 0; i < array.length; i++) {
            runningCount += array[i];
            if (i >= k-1){
                maxSum = Math.max(maxSum, runningCount);
                runningCount -= array[i - (k-1)];
            }
        }

        return maxSum;
    }
}
