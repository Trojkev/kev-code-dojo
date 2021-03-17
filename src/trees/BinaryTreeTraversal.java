package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
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

        System.out.println("Pre-order traversal: " + preOrderTraverse(root));
        System.out.println("In-order traversal: " + inOrderTraverse(root));
        System.out.println("Post-order traversal: " + postOrderTraverse(root));
    }

    private static List<Integer> preOrderTraverse(BST root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        BST currentNode = root;
        Stack<BST> nodes = new Stack<>();

        while (currentNode != null || !nodes.isEmpty()) {
            while (currentNode != null) {
                result.add(currentNode.value);
                nodes.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = nodes.pop();
            currentNode = currentNode.right;
        }

        return result;
    }

    private static List<Integer> inOrderTraverse(BST root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        BST currentNode = root;
        Stack<BST> nodes = new Stack<>();

        while (currentNode != null || !nodes.isEmpty()) {
            while (currentNode != null) {
                nodes.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = nodes.pop();
            result.add(currentNode.value);
            currentNode = currentNode.right;
        }

        return result;
    }

    private static List<Integer> postOrderTraverse(BST root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        BST currentNode = root;
        BST prevNode = null;
        Stack<BST> nodes = new Stack<>();

        while (currentNode != null || !nodes.isEmpty()) {
            while (currentNode != null) {
                nodes.add(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = nodes.peek();
            if (currentNode.right == null || currentNode.right == prevNode) {
                result.add(currentNode.value);
                prevNode = currentNode;
                currentNode = null;
                nodes.pop();
            } else
                currentNode = currentNode.right;
        }

        return result;
    }
}
