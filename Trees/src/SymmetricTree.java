class TreeNode10 {
    int val;
    TreeNode10 left;
    TreeNode10 right;

    TreeNode10(int val) {
        this.val = val;
    }

    TreeNode10(int val, TreeNode10 left, TreeNode10 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class SymmetricTree {
    public static boolean isSymmetric(TreeNode10 root){
        return root == null || isSymmetricHelp(root.left,root.right);
    }
    private static boolean isSymmetricHelp(TreeNode10 left,TreeNode10 right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val!=right.val) return false;

        return isSymmetricHelp(left.left,right.right) && isSymmetricHelp(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode10 root = new TreeNode10(
                1,
                new TreeNode10(
                        2,
                        new TreeNode10(3),
                        new TreeNode10(4)
                ),
                new TreeNode10(
                        2,
                        new TreeNode10(4),
                        new TreeNode10(3)
                )
        );
        boolean result = isSymmetric(root);

        System.out.println("Is the tree symmetric? " + result);
    }
}
