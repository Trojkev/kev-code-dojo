package practice;

public class StringOperations {
    public static void main(String[] args) {
        // test compression function
        String input = "aaabbccccddeee";
        String output = compressString(input);
        System.out.println(input +" : Compressed => "+ output);

        // test string reversal function
        input = "Hello world";
        output = reverseString(input);
        System.out.println(input +" : Reversed => "+ output);

        String s1 = "anagrasm";
        String s2 = "nsagaram";
        System.out.println("Are "+ s1 +" and "+ s2 +" anagrams? : " + isAnagram(s1, s2));
    }

    /**
     * This function takes in a string, compresses it by counting repeating characters and replacing them with
     * the repetition count. If the final string is shorter than the original, we return it, else we return
     * the original string
     * @param original the string that is being compressed
     * @return the compressed string if shorter, else the original
     */
    private static String compressString(String original){
        if (original.length() > 2){
            StringBuilder compressed = new StringBuilder();

            // initialize the char counter to 0 and first compressed character to the first char on original string
            compressed.append(original.charAt(0));
            int count = 1;

            for (int i = 1; i < original.length(); i++) {
                if (compressed.charAt(compressed.length()-1) == original.charAt(i))
                    count++;
                else {
                    compressed.append(count);
                    compressed.append(original.charAt(i));
                    count = 1;
                }
            }
            // insert the count for the final character before you return
            compressed.append(count);

            // if the compressed string is longer than the original string, return the original
            if (compressed.length() > original.length())
                return original;

            return compressed.toString();
        }
        return original;
    }

    /**
     * This method takes in a string and reverses it, then returns the reversed string
     * @param original the string to be reversed
     * @return the reversed string
     */
    private static String reverseString(String original){
        if (original.length() > 1){
            StringBuilder reversed = new StringBuilder();
            for (char c: original.toCharArray()) {
                reversed.insert(0, c);
            }
            return reversed.toString();
        }

        return original;
    }

    /**
     * This algorithm takes in 2 strings and checks if they are anagrams of each other,
     * Two strings are anagrams if they contain the exact same letters even if spelt differently
     * @param s1 the first string being checked
     * @param s2 the second string being compared
     * @return a boolean indicating whether the strings are anagrams
     */
    private static boolean isAnagram(String s1, String s2){
        if (s1.length() != s2.length()) return false;

        int[] occurrenceCounter = new int[26];

        // increment the character encounter in the array for each character in the first string
        for (char c: s1.toCharArray()) {
            int idx = c - 97;
            occurrenceCounter[idx] = occurrenceCounter[idx]++;
        }

        // decrement the character encounter in the array for each character in the second string
        for (char c: s1.toCharArray()) {
            int idx = c - 97;
            occurrenceCounter[idx] = occurrenceCounter[idx]--;
        }

        for (int c: occurrenceCounter) { // check that all the character counters are equal to zero
            if (c != 0) return false;
        }

        return true;
    }
}
