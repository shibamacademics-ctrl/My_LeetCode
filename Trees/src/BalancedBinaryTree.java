class TreeNode6 {
    int val;
    TreeNode6 left;
    TreeNode6 right;

    TreeNode6(int val) {
        this.val = val;
    }

    TreeNode6(int val, TreeNode6 left, TreeNode6 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode6 root) {
        return height(root) != -1;
    }

    private int height(TreeNode6 node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode6 root = new TreeNode6(
                1,
                new TreeNode6(
                        2,
                        new TreeNode6(4),
                        new TreeNode6(5)
                ),
                new TreeNode6(3)
        );

        BalancedBinaryTree obj = new BalancedBinaryTree();

        boolean result = obj.isBalanced(root);

        System.out.println("Is the tree balanced? " + result);
    }
}
