package arrays;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {11, 12, 13, 14, 15, 16, 17},
                {18, 19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30, 31},
                {32, 33, 34, 35, 36, 37, 80}
        };

        int target = 30;

        System.out.println("Target found in matrix: " + findTargetInMatrix(matrix, target));
    }

    private static boolean findTargetInMatrix(int[][] matrix, int target) {
        int startIdx = 0;
        int endIdx = matrix.length - 1;
        int midIdx = 0;

        // find the row that possibly contains the target
        while (startIdx < endIdx){
            midIdx = (startIdx + endIdx) / 2;

            if (matrix[midIdx][matrix[midIdx].length-1] < target) {
                startIdx = midIdx + 1;
            } else if (matrix[endIdx][matrix[midIdx].length-1] > target) {
                endIdx = midIdx - 1;
            } else
                return true;
        }

        startIdx = 0;
        endIdx = matrix[midIdx].length-1;

        // find the column that possibly contains the target
        while (startIdx < endIdx) {
            int mid = (startIdx + endIdx) / 2;

            if (matrix[midIdx][mid] < target){
                /*
                 initially the solution was timing out because I was updating startIdx with midIdx+1
                 instead of mid+1
                */
                startIdx = mid + 1;
            } else if (matrix[midIdx][mid] > target) {
                /*
                 initially the solution was timing out because I was updating startIdx with midIdx-1
                 instead of mid-1
                */
                endIdx = mid - 1;
            } else
                return true;
        }

        return false;
    }
}
