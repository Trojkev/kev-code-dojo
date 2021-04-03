package dynamic_programming;

public class WaysToMakeChange {
    public static void main(String[] args) {
        int[] denominations = {1, 5, 10, 25};
        int amount = 10;

        System.out.println("Number of ways to make change: " + numberOfWaysToMakeChange(amount, denominations));
    }

    // O(nd) time | O(n) space - where n is the amount and d is the number of then denominations
    private static int numberOfWaysToMakeChange(int n, int[] denominations) {
        int[] changeWays = new int[n + 1];
        changeWays[0] = 1;

        for (int coin: denominations) {
            for (int amount = 1; amount < changeWays.length; amount++) {
                if (coin <= amount)
                    changeWays[amount] += changeWays[amount - coin];
            }
        }

        return changeWays[n];
    }
}
