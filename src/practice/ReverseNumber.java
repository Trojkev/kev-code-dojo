package practice;

public class ReverseNumber {
    public static void main(String[] args) {
        int num = 1000;
        System.out.println("Original: " + num);
        System.out.println("Reverse: " + reverseNumber(num));
    }

    // O(n) time | O(1) space - where n is the size of the number
    private static int reverseNumber(int N) {
        int num=0;
        while (N > 0) {
            num = num * 10 + N % 10;
            N = N / 10;
        }
        return num;
    }
}
