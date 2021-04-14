package arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] input = {7, 2, 3, 1, -9, 20, 5, 6};

        System.out.println("First missing num: " + firstMissingPositiveNumber(input));
    }

    private static int firstMissingPositiveNumber(int[] nums) {
        int n = nums.length;
        boolean containsOne = false;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                containsOne = true;
            else if (nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        }

        if (!containsOne) return 1;

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0)
                nums[index] = nums[index] * -1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i+1;
        }

        return n + 1;
    }
}
