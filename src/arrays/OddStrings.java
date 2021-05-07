package arrays;

public class OddStrings {
    public static void main(String[] args) {
        String[] words = {"abc", "bcde"};
        int power = 2;
        System.out.println("IS EVEN: " + findIfiSOddString(words, power));
    }

    private static boolean findIfiSOddString(String[] words, int m) {
        int[][] ord = new int[words.length][10];

        for (int i=0; i< words.length; i++) {
            for (int c = 0; c < words[i].length(); c++) {
                ord[i][c] = (int) words[i].charAt(c) - 96;
            }
        }

        int sum = 0;
        for (int[] values : ord) {
            int result = 1;

            for (int val : values) {
                if (val == 0)
                    break;

                String number = String.valueOf((int) Math.pow(val, m));
                int num = Integer.parseInt(number.substring(number.length()-1));
                result *= num;
            }

            sum += result;
        }

        return sum % 2 == 0;
    }
}
