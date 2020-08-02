package trees;

public class BinarySearchTree {
    private TreeNode root;

    private void insertNode(int data) {
        if (root == null)
            root = new TreeNode(data);
        else
            root.insert(data);
    }

    private TreeNode findNode(int data) {
        if (root != null)
            return root.find(data);

        return null;
    }

    private void deleteNode(int data) {

    }
}
