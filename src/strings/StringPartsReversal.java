package strings;

import java.util.ArrayList;
import java.util.List;

public class StringPartsReversal {
    public static void main(String[] args) {
        String text = "Hello world";
        System.out.println("Reversed: "+reverseText(text));
        System.out.println("Reversed parts: "+reverseTextByParts(text));
    }

    private static String reverseTextByParts(String text){
        // create a list that will hold the string parts of length 4 or less
        List<String> parts = new ArrayList<>();
        int index = 0;

        // iterate the string while splitting it on the 4th index and store in the list
        while (index < text.length()){
            parts.add(text.substring(index, Math.min(index+4, text.length())));
            index += 4; // increment index by 4
        }

        /*
            now that we have the string parts to be reversed,
            let's call the reverse function on each part while appending the result to the string builder
         */
        StringBuilder builder = new StringBuilder();
        for (String item: parts) {
            builder.append(reverseText(item));
        }

        return builder.toString();
    }

    private static String reverseText(String text){
        StringBuilder builder = new StringBuilder();

        for (int i = text.length()-1; i >= 0; i--) {
            builder.append(text.charAt(i));
        }

        return builder.toString();
    }
}
