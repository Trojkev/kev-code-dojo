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
}
