import java.util.*;
class TreeNode25 {
    int data;
    TreeNode25 left;
    TreeNode25 right;

    TreeNode25(int val) {
        data = val;
        left = null;
        right = null;
    }
}
class BuildBST {
    public static TreeNode25 insert(TreeNode25 root,int val){
        if(root == null){
            return new TreeNode25(val);
        }
        if(root.data>val){
            root.left =  insert(root.left,val);
        }
        else{
            root.right =  insert(root.right,val);
        }
        return root;
    }
    public static TreeNode25 build(int ar[]){
        TreeNode25 root = null;
        for(int val:ar){
            root = insert(root,val);
        }
        return root;
    }
    public static void inorder(TreeNode25 root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int ar[] = {3,2,1,5,6,4};
        TreeNode25 root = build(ar);
        inorder(root);
    }
}
