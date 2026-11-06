import java.util.*;
class TreeNode21 {
    int val;
    TreeNode21 left;
    TreeNode21 right;

    TreeNode21(int val) {
        this.val = val;
    }

    TreeNode21(int val, TreeNode21 left, TreeNode21 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class CountNodesInCompleteBT {
    public static int countNodes(TreeNode21 root) {
        int leftDepth = leftdepth(root);
        int rightDepth = rightDepth(root);

        if(leftDepth == rightDepth){
            return (int) Math.pow(2,leftDepth) - 1;
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private static int leftdepth(TreeNode21 root){
        int depth = 0;
        while(root!=null){
            root = root.left;
            depth++;
        }
        return depth;
    }
    private static int rightDepth(TreeNode21 root){
        int depth = 0;
        while(root!=null){
            root = root.right;
            depth++;
        }
        return depth;
    }
    public static void main(String[] args) {
        TreeNode21 root = new TreeNode21(1);

        root.left = new TreeNode21(2);
        root.right = new TreeNode21(3);

        root.left.left = new TreeNode21(4);
        root.left.right = new TreeNode21(5);

        root.right.left = new TreeNode21(6);

        System.out.println("Total Nodes: " + countNodes(root));
    }
}
