package arrays;

import java.util.HashMap;

public class IntegerPairs {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        System.out.println(evenPairs(nums));
    }

    private static boolean evenPairs(int[] A) {
        if (A.length % 2 == 1) return false;

        HashMap<Integer, Integer> pairs = new HashMap<>();

        for (int key : A) {
            if (pairs.containsKey(key)) {
                pairs.put(key, pairs.get(key) + 1);
                if (pairs.get(key) == 2)
                    pairs.remove(key);
            } else {
                pairs.put(key, 1);
            }
        }

        return pairs.isEmpty();
    }
}
