package dynamic_programming;

import java.util.Arrays;

public class WaterArea {
    public static void main(String[] args) {
        int[] input = {0,8,0,0,5,0,0,10,0,0,1,1,0,3};
        int area = findWaterArea(input);

        System.out.println("Input: "+ Arrays.toString(input) + "\nOutput: "+area);
    }

    private static int findWaterArea(int[] heights) {
        int area = 0;
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            leftMax[i] = max;
            max = Math.max(max, heights[i]);
        }

        max = 0;
        for (int i = heights.length-1; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(max, heights[i]);
        }

        for (int i = 0; i < heights.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (heights[i] < min)
                area += min - heights[i];
        }

        return area;
    }
}
