package trees;

import java.util.ArrayList;
import java.util.Arrays;

public class ReconstructBST {
    static class BST {
        int value;
        BST left;
        BST right;

        BST(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Integer[] input = {10,4,2,1,5,17,19,18};
        ArrayList<Integer> inputList = new ArrayList<>(Arrays.asList(input));

        BST root = reconstructBSTFromArray(inputList);
        if (root == null) {
            System.out.println("Root is null");
            return;
        }
        System.out.printf(
                "Root node: %d\nLeft node: %d\nRight node: %d\n",
                root.value, root.left.value, root.right.value);

        System.out.println("***************************************************************");
        root = reconstructBstOptimal(inputList);
        if (root == null) {
            System.out.println("Root is null");
            return;
        }
        System.out.printf(
                "Optimal Root node: %d\nLeft node: %d\nRight node: %d\n",
                root.value, root.left.value, root.right.value);
    }

    // O(n^2) time | O(n) space - where n is the size of the input list
    private static BST reconstructBSTFromArray(ArrayList<Integer> inOrderTraversalList) {
        if (inOrderTraversalList.size() == 0)
            return null;

        int currentValue = inOrderTraversalList.get(0);
        int rightSubtreeRootIdx = inOrderTraversalList.size();

        for (int i = 1; i < inOrderTraversalList.size(); i++) {
            int value = inOrderTraversalList.get(i);
            if (value >= currentValue){
                rightSubtreeRootIdx = i;
                break;
            }
        }

        BST leftSubtree = reconstructBSTFromArray(
                new ArrayList<>(inOrderTraversalList.subList(1, rightSubtreeRootIdx)));
        BST rightSubtree = reconstructBSTFromArray(
                new ArrayList<>(inOrderTraversalList.subList(rightSubtreeRootIdx, inOrderTraversalList.size())));

        BST root = new BST(currentValue);
        root.left = leftSubtree;
        root.right = rightSubtree;

        return root;
    }

    static class BSTInfo {
        int rootIdx;

        BSTInfo(int value) {
            this.rootIdx = value;
        }
    }

    // O(n) time | O(n) space - where n is the size of the input list
    private static BST reconstructBstOptimal(ArrayList<Integer> inOrderTraversalList) {
        BSTInfo treeInfo = new BSTInfo(0);
        int minBound = Integer.MIN_VALUE;
        int maxBound = Integer.MAX_VALUE;

        return reconstructBstOptimal(minBound, maxBound, inOrderTraversalList, treeInfo);
    }

    private static BST reconstructBstOptimal(
            int minBound, int maxBound, ArrayList<Integer> inOrderTraversalList, BSTInfo treeInfo) {
        if (treeInfo.rootIdx == inOrderTraversalList.size())
            return null;

        int currentValue = inOrderTraversalList.get(treeInfo.rootIdx);
        if (currentValue < minBound || currentValue >= maxBound)
            return null;

        treeInfo.rootIdx++;

        BST leftSubTree = reconstructBstOptimal(minBound, currentValue, inOrderTraversalList, treeInfo);
        BST rightSubtree = reconstructBstOptimal(currentValue, maxBound, inOrderTraversalList, treeInfo);

        BST node = new BST(currentValue);
        node.left = leftSubTree;
        node.right = rightSubtree;

        return node;
    }
}
