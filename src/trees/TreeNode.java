package trees;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    private boolean isDeleted;

    TreeNode(int value){
        data = value;
        left = right = null;
    }

    TreeNode find(int value){
        if (data == value && !isDeleted())
            return this;
        if (value < data && left != null)
            return left.find(value);
        if (value > data && right != null)
            return right.find(value);

        return null;
    }

    void insert(int value){
        if (value > data) { // insert in the right sub-tree
            if (this.right == null)
                this.right = new TreeNode(value);
            else
                this.right.insert(value);
        } else { // insert in the left sub-tree
            if (this.left == null)
                this.left = new TreeNode(value);
            else
                this.left.insert(value);
        }
    }

    void delete(){
        this.isDeleted = true;
    }

    boolean isDeleted(){
        return this.isDeleted;
    }
}
