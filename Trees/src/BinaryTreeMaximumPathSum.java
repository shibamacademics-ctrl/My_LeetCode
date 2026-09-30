class TreeNode9 {
    int val;
    TreeNode9 left;
    TreeNode9 right;

    TreeNode9(int val) {
        this.val = val;
    }

    TreeNode9(int val, TreeNode9 left, TreeNode9 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class BinaryTreeMaximumPathSum {

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode9 root) {

        maxGain(root);

        return maxSum;
    }

    public static int maxGain(TreeNode9 node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));
        int currentPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPath);
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode9 root = new TreeNode9(-10);

        root.left = new TreeNode9(9);
        root.right = new TreeNode9(20);

        root.right.left = new TreeNode9(15);
        root.right.right = new TreeNode9(7);

        int result = maxPathSum(root);

        System.out.println("Maximum Path Sum: " + result);
    }
}