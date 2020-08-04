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
        if (root == null)
            return;

        TreeNode node = findNode(data);
        if (node != null)
            node.delete();

//        TreeNode current = root;
//        TreeNode parent = null;
//        boolean isLeftChild = false;
//
//        // find the node to be deleted and it's parent to be updated
//        while (current != null && current.data != data) {
//            parent = current;
//
//            if (data < current.data) {
//                current = current.left;
//                isLeftChild = true;
//            } else {
//                current = current.right;
//                isLeftChild = false;
//            }
//        }
//
//        if (current != null && parent != null) {
//            if (current.left != null && current.right != null) { // the node has two children
//                System.out.println("Delete: "+data);
//            } else if (current.left != null) { // left child is present
//                if (current == root)
//                    root = current.left;
//                else {
//                    if (isLeftChild)
//                        parent.left = current.left;
//                    else parent.right = current.left;
//                }
//            }else if (current.right != null){ // right child is present
//                if (current == root)
//                    root = current.right;
//                else {
//                    if (isLeftChild)
//                        parent.left = current.right;
//                    else parent.right = current.right;
//                }
//            } else { // node is a leaf node
//                if (current == root)
//                    root = null;
//                else {
//                    if (isLeftChild)
//                        parent.left = null;
//                    else
//                        parent.right = null;
//                }
//            }
//        }
    }
}
