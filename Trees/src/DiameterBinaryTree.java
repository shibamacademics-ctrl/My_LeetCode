class TreeNode7 {
    int val;
    TreeNode7 left;
    TreeNode7 right;

    TreeNode7(int val) {
        this.val = val;
    }

    TreeNode7(int val, TreeNode7 left, TreeNode7 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class DiameterBinaryTree {
    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode7 root) {
        height(root);
        return diameter;
    }
    private static int height(TreeNode7 node){
        if(node == null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        diameter = Math.max(diameter,lh+rh);
        return 1+Math.max(lh,rh);

    }

    public static void main(String[] args) {
        TreeNode7 root = new TreeNode7(1);
        root.left = new TreeNode7(2);
        root.right = new TreeNode7(3);
        root.left.left = new TreeNode7(4);
        root.left.right = new TreeNode7(5);
        int result = diameterOfBinaryTree(root);
        System.out.println("Diameter of Binary Tree: " + result);
    }
}
