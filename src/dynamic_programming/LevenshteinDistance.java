package dynamic_programming;

import java.util.Arrays;

public class LevenshteinDistance {
    public static void main(String[] args) {
        String strOne = "abc";
        String strTwo = "yabd";

        System.out.println("Minimum edit operations: " + getMinimumEditOperations(strOne, strTwo));
    }

    // O(nm) time | O(nm) space - where n is the length of string one and m is the length of string two
    private static int getMinimumEditOperations(String strOne, String strTwo) {
        int cols = strOne.length();
        int rows = strTwo.length();
        int[][] mat = new int[rows + 1][cols + 1];

        for (int r = 0; r < rows + 1; r++) {
            for (int c = 0; c < cols; c++) {
                mat[r][c] = c;
            }
            mat[r][0] = r;
        }

        for (int r = 1; r < rows + 1; r++) {
            for (int c = 1; c < cols + 1; c++) {
                if (strOne.charAt(c-1) == strTwo.charAt(r-1)){
                    mat[r][c] = mat[r-1][c-1];
                } else {
                    mat[r][c] = 1 + Math.min(Math.min(mat[r][c-1], mat[r-1][c]), mat[r-1][c-1]);
                }
            }
        }
        for (int[] ints : mat) System.out.println(Arrays.toString(ints));

        return mat[rows][cols];
    }
}
