package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author kmacharia
 *
 * In this class, we shall take in a List of lists containing 3 integers representing 3 sides of a disk
 * that is length, width and height {l, w, h}.
 * The aim is to find the tallest stack of disks where every disk on the stack is smaller than the one beneath
 * it in all dimensions.
 * We are also not allowed to rotate or turn the disks in any way to get different dimensions for the same disk.
 *
 *
 * Algorithm
 * ==================
 * Sort the disks in ascending order based on the height
 * store the heights in an array to track the maximum height when that disk is at the bottom
 * keep track of the indices of the disks forming the stack
 */
public class DiskStacking {
    public static void main(String[] args) {
        List<int[]> disks = new ArrayList<>();
        disks.add(new int[]{2, 1, 2});
        disks.add(new int[]{3, 2, 2});
        disks.add(new int[]{2, 2, 8});
        disks.add(new int[]{2, 3, 4});
        disks.add(new int[]{1, 3, 1});
        disks.add(new int[]{4, 4, 5});

        List<int[]> stack = findTallestStack(disks);
        for (int[] item : stack) {
            System.out.println("{" + item[0] + ", " + item[1] + ", " + item[2] + "}");
        }

    }
    private static List<int[]> findTallestStack(List<int[]> disks){
        disks.sort(Comparator.comparingInt(disk -> disk[2]));

        int[] heights = new int[disks.size()];
        int[] stacks = new int[disks.size()];

        for (int i = 0; i < disks.size(); i++) {
            heights[i] = disks.get(i)[2];
            stacks[i] = -1;
        }

        int highestIndex = -1;
        for (int i = 0; i < disks.size(); i++) {
            int[] current = disks.get(i);
            for (int j = 0; j < i; j++) {
                int[] prev = disks.get(j);

                if (prev[0] < current[0] && prev[1] < current[1] && prev[2] < current[2]){
                    if (heights[i] < heights[j] + current[2]){
                        heights[i] = heights[j] + current[2];
                        stacks[i] = j;
                    }
                }
            }
            if (heights[i] >= heights[highestIndex])
                highestIndex = i;
        }

        return buildStack(disks, stacks, highestIndex);
    }

    private static List<int[]> buildStack(List<int[]> disks, int[] stacks, int heightIndex) {
        List<int[]> stack = new ArrayList<>();

        while (heightIndex != -1){
            stack.add(0, disks.get(heightIndex));
            heightIndex = stacks[heightIndex];
        }

        return stack;
    }
}
