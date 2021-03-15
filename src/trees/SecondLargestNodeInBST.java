package trees;

public class SecondLargestNodeInBST {

    static class BST{
        int value;
        BST left;
        BST right;

        BST(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        BST root = new BST(10);
        root.right = new BST(18);
        root.left = new BST(6);

        root.right.right = new BST(25);
        root.right.left = new BST(15);

        root.left.right = new BST(8);
        root.left.left = new BST(3);

        System.out.println("Second largest node is: " + findSecondLargestNode(root));
    }

    private static int findSecondLargestNode(BST root) {
        if(root == null) return -1;

        BST parent = null;
        BST currentNode = root;

        while(currentNode != null) {
            if(currentNode.right == null) break;

            parent = currentNode;
            currentNode = currentNode.right;
        }

        return parent.value;
    }
}
