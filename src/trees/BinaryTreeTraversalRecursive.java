package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversalRecursive {
    static class BST {
        int value;
        BST left;
        BST right;

        BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.right = new BST(15);

        root.left.left = new BST(2);
        root.left.right = new BST(7);

        root.right.left = new BST(12);
        root.right.right = new BST(25);

        System.out.println("Pre-order traversal: " + preOrderTraverse(root, new ArrayList<>()));
        System.out.println("In-order traversal: " + inOrderTraverse(root, new ArrayList<>()));
        System.out.println("Post-order traversal: " + postOrderTraverse(root, new ArrayList<>()));
    }

    private static List<Integer> preOrderTraverse(BST root, List<Integer> array) {
        array.add(root.value);

        if (root.left != null)
            preOrderTraverse(root.left, array);

        if (root.right != null)
            preOrderTraverse(root.right, array);

        return array;
    }

    private static List<Integer> inOrderTraverse(BST root, List<Integer> array) {
        if (root.left != null)
            inOrderTraverse(root.left, array);

        array.add(root.value);

        if (root.right != null)
            inOrderTraverse(root.right, array);

        return array;
    }

    private static List<Integer> postOrderTraverse(BST root, List<Integer> array) {
        if (root.left != null)
            postOrderTraverse(root.left, array);

        if (root.right != null)
            postOrderTraverse(root.right, array);

        array.add(root.value);

        return array;
    }
}
