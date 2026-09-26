class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;

    TreeNode4() {}

    TreeNode4(int val) {
        this.val = val;
    }

    TreeNode4(int val, TreeNode4 left, TreeNode4 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode4 root){
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1 + Math.max(lh,rh);
    }

    public static void main(String[] args) {
        TreeNode4 root = new TreeNode4(1);

        root.left = new TreeNode4(2);
        root.right = new TreeNode4(3);

        root.left.left = new TreeNode4(4);
        root.left.right = new TreeNode4(5);

        root.left.right.left = new TreeNode4(6);
        MaximumDepthofBinaryTree obj = new MaximumDepthofBinaryTree();
        int depth = obj.maxDepth(root);
        System.out.println("Maximum Depth: " + depth);
    }
}
