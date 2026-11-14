import java.util.*;
class TreeNode26 {
    int data;
    TreeNode26 left;
    TreeNode26 right;

    TreeNode26(int val) {
        data = val;
        left = null;
        right = null;
    }
}
class SearchinBST {
    public static TreeNode26 search(TreeNode26 root,int val){
        if(root == null){
            return root;
        }
        while(root!=null && root.data!=val){
            root = root.data>val?root.left:root.right;
        }
        return root;
    }
    public static void main(String[] args) {

        TreeNode26 root = new TreeNode26(3);
        root.left = new TreeNode26(2);
        root.right = new TreeNode26(5);
        root.left.left = new TreeNode26(1);
        root.right.left = new TreeNode26(4);
        root.right.right = new TreeNode26(6);

        int val = 4;

        TreeNode26 result = search(root, val);

        if (result != null) {
            System.out.println("Element found: " + result.data);
        } else {
            System.out.println("Element not found");
        }
    }
}
