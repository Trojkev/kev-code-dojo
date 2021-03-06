package practice;

import java.util.Stack;

public class BstValidator {
    public static void main(String[] args) {
        BstValidator tree = new BstValidator();
//        tree.root = new BNode(4);
//        tree.root.left = new BNode(2);
//        tree.root.left.left = new BNode(1);
//        tree.root.left.right = new BNode(3);
//        tree.root.right = new BNode(6);
//        tree.root.right.left = new BNode(5);
//        tree.root.right.right = new BNode(7);

        tree.root = new BNode(10);
        tree.root.left = new BNode(5);
        tree.root.right = new BNode(15);
        tree.root.left.right = new BNode(10);

        System.out.println(tree.isBst());
        System.out.println(tree.validateBST(tree.root));
    }

    // the root node of the tree
    private BNode root;

    /**
     * Takes in a tree, and returns true if the tree is a BST
     * and the node values are >= min and <= max
     *
     * @param node the binary tree being validated
     * @param min  the minimum value being compared
     * @param max  the minimum value being compared
     * @return a boolean indicating whether the tree is a BST
     */
    private boolean isBstUtil(BNode node, int min, int max) {
        /* an empty tree is always a BST, hence we return true*/
        if (node == null) {
            System.out.println("Null found");
            return true;
        }
        System.out.println("Node: " + node.data + " min: " + min + " max: " + max);

        /* if the node violates the min/max constraint, we return false*/
        if (node.data < min || node.data > max)
            return false;

        /*
         * otherwise, we check the subtrees of the current node recursively
         * while tightening the min/max constraints
         *
         * In this solution, we are assuming our tree has distinct values
         * */
        return (isBstUtil(node.left, min, node.data - 1) &&
                isBstUtil(node.right, node.data + 1, max));
    }

    private boolean isBst() {
        return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Here we take a binary tree and check whether it's a valid BST
     *
     * @param root the root node of the tree being validated
     * @return a boolean indicating whether it's a valid BST
     */
    private boolean validateBST(BNode root) {
        // let's create a stack to hold all the nodes from the root for processing
        Stack<BNode> nodes = new Stack<>();
        // here we store the minimum value and will always be the min
        int left_val = Integer.MIN_VALUE;

        // as long as we have something in the stack or the root is not null, we keep iterating
        while (!nodes.isEmpty() || root != null) {
            // as long as the current node is not a leaf (null) we go deeper in the tree
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }

            // now let's process the nodes from the stack
            root = nodes.pop();
            // if the root value is less than the left child value, we return false
            if (root.data <= left_val) return false;
            // now let's update the min value and set the root to be the right node for processing
            left_val = root.data;
            root = root.right;
        }

        return true;
    }
}

class BNode {
    int data;
    BNode left, right;

    BNode(int item) {
        this.data = item;
        left = right = null;
    }
}
