package practice;

public class ReverseNumber {
    public static void main(String[] args) {
        int num = 1000;
        System.out.println("Original: " + num);
        System.out.println("Reverse: " + reverseNumber(num));
    }

    private static int reverseNumber(int N) {
        int enable_print = N % 10;
        int num=0;
        while (N > 0) {
            num = num * 10 + N % 10;
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            }
            else if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
        return num;
    }
}
