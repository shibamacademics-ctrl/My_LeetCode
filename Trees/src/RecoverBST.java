class TreeNode38 {
    int val;
    TreeNode38 left, right;

    TreeNode38(int val) {
        this.val = val;
    }
}

class RecoverBST {

    TreeNode38 first = null;
    TreeNode38 second = null;
    TreeNode38 prev = null;

    public void recoverTree(TreeNode38 root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode38 root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }

        prev = root;

        inorder(root.right);
    }

    static void printTree(TreeNode38 root) {
        if (root == null) return;

        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {

        TreeNode38 root = new TreeNode38(3);
        root.left = new TreeNode38(1);
        root.right = new TreeNode38(4);
        root.right.left = new TreeNode38(2);

        RecoverBST obj = new RecoverBST();

        System.out.println("Before Recovery:");
        printTree(root);

        obj.recoverTree(root);

        System.out.println("\nAfter Recovery:");
        printTree(root);
    }
}