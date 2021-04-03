package dynamic_programming;

import java.util.Arrays;

public class MinCoinsForChange {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 4, 5, 10};
        int amount = 6;

        System.out.println("Minimum coins for change: " + minimumCoinsToMakeChange(amount, denominations));
    }

    // O(nd) time | O(n) space - where n is the target amount and d is the number of denominations
    private static int minimumCoinsToMakeChange(int n, int[] denominations) {
        int[] minCoins = new int[n+1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;

        for (int coin: denominations) {
            for (int amount = 0; amount < minCoins.length; amount++) {
                if (coin <= amount) {
                    int newCoins;
                    if (minCoins[amount - coin] == Integer.MAX_VALUE)
                        newCoins = minCoins[amount - coin];
                    else
                        newCoins = minCoins[amount - coin] + 1;

                    minCoins[amount] = Math.min(minCoins[amount], newCoins);
                }
            }
        }

        return minCoins[n] != Integer.MAX_VALUE ? minCoins[n] : -1;
    }
}
