package arrays;


import java.util.Arrays;

/**
 * Write an algorithm that takes in two Arrays and validates that the second array is a sub-sequence of
 * the first array. The elements in the sequence must occur in the same order in the main array
 * but they don't necessarily need to be consecutive.
 */
public class ValidateSubSequence {
    public static void main(String[] args) {
        int[] arrayOne = {5,1,22,25,6,-1,8,10};
        int[] arrayTwo = {1,6,-1,10};

        System.out.printf("Input: %s and %s\n", Arrays.toString(arrayOne), Arrays.toString(arrayTwo));
        System.out.printf("Is valid?: %b\n", validateSubSequence(arrayOne, arrayTwo));
    }

    /**
     * This approach takes advantage of the occurrence order and only moves forward on the sequence once
     * the current sequence element has been found
     *
     * This solution runs in O(n) time complexity and O(1) space complexity
     * @param mainList the main list that we are checking
     * @param sequence the sequence being validated
     * @return a boolean indicating sequence validity
     */
    private static boolean validateSubSequence(int[] mainList, int[] sequence){
        int subIdx = 0;

        for (int item: mainList) {
            if (item == sequence[subIdx]){
                if (subIdx == sequence.length -1)
                    return true;
                else
                    subIdx++;
            }
        }
        return false;
    }
}
