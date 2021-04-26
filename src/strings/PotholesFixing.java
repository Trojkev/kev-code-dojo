package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PotholesFixing {
    public static void main(String[] args) {
        String potholes = ".XX...XXX.X..X";
        int budget = 6;

        System.out.println("Potholes fixed : " + maximumPotholesFixed(potholes, budget));
    }

    private static int maximumPotholesFixed(String potholes, int budget) {
        if (budget <= 1 || potholes.length() == 0)
            return 0;

        int remaining = budget;
        List<Integer> groups = new ArrayList<>();
        int count = potholes.charAt(0) == '.' ? 0 : 1;

        for (int i = 1; i < potholes.length(); i++) {
            if (potholes.charAt(i) == 'X')
                count++;
            else {
                if (count > 0) {
                    groups.add(count);
                    count = 0;
                }
            }
        }
        if (count > 0) groups.add(count);
        groups.sort(Collections.reverseOrder());

        int totalFixed = 0;
        for (int holes: groups) {
            if (holes + 1 > remaining) {
                return totalFixed + remaining - 1;
            }
            else {
                totalFixed += holes;
                remaining -= holes + 1;
            }

        }

        return 0;
    }
}
