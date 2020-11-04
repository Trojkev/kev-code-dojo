package strings;

import java.util.LinkedHashMap;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String text = "perpendicular";
        System.out.println("First Non Repeater: "+firstNonRepeatingCharacter(text));
    }

    private static char firstNonRepeatingCharacter(String text) {
        char letter = '.';
        if (text == null) return letter;
        if (text.length() == 1) return text.charAt(0);

        LinkedHashMap<Character, Integer> charMap = new LinkedHashMap<>();

        text = text.toLowerCase();
        for (char c: text.toCharArray()) {
            if (charMap.containsKey(c))
                charMap.put(c, charMap.get(c) + 1);
            else
                charMap.put(c, 1);
        }

        for (char c: charMap.keySet()) {
            if (charMap.get(c) == 1){
                letter = c;
                break;
            }
        }

        return letter;
    }
}
