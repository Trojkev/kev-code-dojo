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
