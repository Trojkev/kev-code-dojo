package trees;

public class MinHeightBST {
    static class BST {
        int value;
        BST left;
        BST right;

        BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 5, 7, 10, 13, 14, 17, 19};

        BST root = reconstructMinHeightBST(input);
        System.out.println("Root: " + root.value);
        System.out.println("Left: " + root.left.value);
        System.out.println("Right: " + root.right.value);
    }

    // O(n) time | O(n) - where n is the size of the input array
    private static BST reconstructMinHeightBST(int[] array) {
        return reconstructMinHeightBST(array, 0, array.length - 1);
    }

    private static BST reconstructMinHeightBST(int[] array, int startIdx, int endIdx) {
        if (startIdx > endIdx)
            return null;

        int midIdx = (startIdx + endIdx) / 2;
        BST root = new BST(array[midIdx]);

        root.left = reconstructMinHeightBST(array, startIdx, midIdx - 1);
        root.right = reconstructMinHeightBST(array, midIdx + 1, endIdx);

        return root;
    }
}
