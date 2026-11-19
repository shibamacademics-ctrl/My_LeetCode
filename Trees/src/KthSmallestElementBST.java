import java.util.*;
class TreeNode30 {
    int data;
    TreeNode30 left;
    TreeNode30 right;

    TreeNode30(int val) {
        data = val;
        left = null;
        right = null;
    }
}
class KthSmallestElementBST {
    static int count = 0;
    static int result = -1;
    public static int kthSmallest(TreeNode30 root,int k){
        inorder(root,k);
        return result;
    }
    private static void inorder(TreeNode30 root,int k){
        if(root == null){
            return;
        }
        inorder(root.left,k);
        count++;
        if(count == k){
            result = root.data;
            return;
        }
        inorder(root.right,k);

    }
    public static void main(String[] args) {

        TreeNode30 root = new TreeNode30(5);
        root.left = new TreeNode30(3);
        root.right = new TreeNode30(7);
        root.left.left = new TreeNode30(2);
        root.left.right = new TreeNode30(4);
        root.right.left = new TreeNode30(6);
        root.right.right = new TreeNode30(8);

        int k = 3;

        System.out.println("Kth Smallest Element: " + kthSmallest(root, k));
    }
}
