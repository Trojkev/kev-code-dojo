package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniqueNumbersCount {
    public static void main(String[] args) {
        int[] array = {1,2,2,4,5,6};
        int k = 3;

        System.out.println("Unique numbers: " + getUniqueNumbers(array, k));
    }

    private static List<Integer> getUniqueNumbers(int[] array, int k) {
        List<Integer> uniqueNums = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) +1);
        }

        uniqueNums.add(map.size());

        for (int i = k; i < array.length; i++) {
            if(map.get(array[i-k]) == 1)
                map.remove(array[i-k]);
            else 
                map.put(array[i-k], map.get(array[i-k]) -1);

            map.put(array[i], map.getOrDefault(array[i], 0) + 1);

            uniqueNums.add(map.size());
        }

        return uniqueNums;
    }
}
