import java.util.*;
class TreeNode31 {
    int data;
    TreeNode31 left;
    TreeNode31 right;

    TreeNode31(int val) {
        data = val;
        left = null;
        right = null;
    }
}
class ValidBST {
    public static boolean isValidBST(TreeNode31 root) {
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private static boolean valid(TreeNode31 root,long min,long max){
        if(root == null) return true;
        if(root.data>=max || root.data<=min) return false;
        return valid(root.left,min,root.data) && valid(root.right,root.data,max);
    }

    public static void main(String[] args) {
        TreeNode31 root = new TreeNode31(10);

        root.left = new TreeNode31(5);
        root.right = new TreeNode31(15);

        root.left.left = new TreeNode31(2);
        root.left.right = new TreeNode31(7);

        root.right.left = new TreeNode31(12);
        root.right.right = new TreeNode31(20);

        if (isValidBST(root)) {
            System.out.println("Valid BST");
        } else {
            System.out.println("Invalid BST");
        }
    }
}
