package practice;

public class StringOperations {
    public static void main(String[] args) {
        String input = "";

        String output = compress(input);
        System.out.println(input +" => "+ output);
    }

    /**
     * This function takes in a string, compresses it by counting repeating characters and replacing them with
     * the repetition count. If the final string is shorter than the original, we return it, else we return
     * the original string
     * @param original the string that is being compressed
     * @return the compressed string if shorter, else the original
     */
    private static String compress(String original){
        if (original.length() > 2){
            StringBuilder compressed = new StringBuilder();
            compressed.charAt(compressed.length());
        }
        return original;
    }
}
