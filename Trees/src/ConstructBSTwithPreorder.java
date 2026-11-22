import java.util.*;
class TreeNode33 {
    int data;
    TreeNode33 left;
    TreeNode33 right;

    TreeNode33(int val) {
        data = val;
        left = null;
        right = null;
    }
}
class ConstructBSTwithPreorder {
    static int idx = 0;

    public static TreeNode33 bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    public static TreeNode33 build(int[] preorder, int bound) {

        if (idx == preorder.length || preorder[idx] > bound) {
            return null;
        }

        TreeNode33 root = new TreeNode33(preorder[idx]);
        idx++;

        root.left = build(preorder, root.data);
        root.right = build(preorder, bound);

        return root;
    }

    public static void main(String[] args) {

        int[] preorder = {8, 5, 1, 7, 10, 12};

        TreeNode33 root = bstFromPreorder(preorder);

        System.out.println("Inorder Traversal:");

        inorder(root);
    }

    public static void inorder(TreeNode33 root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
