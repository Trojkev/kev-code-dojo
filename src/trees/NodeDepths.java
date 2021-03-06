package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kmacharia
 * Write an  algorithm that takes in a Binary tree and returns a sum of all the node depths
 * root node is depth 0
 */
public class NodeDepths {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(18);
        root.left = new BinaryTree(15);
        root.right = new BinaryTree(21);
        root.left.left = new BinaryTree(8);
        root.left.right = new BinaryTree(10);
        root.right.left = new BinaryTree(17);
        root.right.right = new BinaryTree(30);
        root.left.left.left = new BinaryTree(2);
        root.left.left.right = new BinaryTree(5);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(15);

        System.out.println("Node Depths: "+ findNodeDepths(root));
        System.out.println("Node Depths Recursive: "+ findNodeDepthsRecursive(root));
    }

    private static int findNodeDepths(BinaryTree root){
        int totalDepths = 0;
        List<Level> stack = new ArrayList<>();
        stack.add(new Level(root, 0));

        while (stack.size() > 0){
            Level top = stack.remove(stack.size() -1);
            BinaryTree node = top.node;
            int depth = top.depth;

            if (node == null) continue;

            totalDepths += depth;
            stack.add(new Level(node.left, depth+1));
            stack.add(new Level(node.right, depth+1));
        }

        return totalDepths;
    }

    private static int findNodeDepthsRecursive(BinaryTree root) {
        return findNodeDepthsRecursive(root, 0);
    }

    private static int findNodeDepthsRecursive(BinaryTree node, int depth) {
        if (node == null)
            return 0;
        return depth + findNodeDepthsRecursive(node.left, depth+1)
                + findNodeDepthsRecursive(node.right, depth+1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Level{
        int depth;
        BinaryTree node;

        Level(BinaryTree node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}
