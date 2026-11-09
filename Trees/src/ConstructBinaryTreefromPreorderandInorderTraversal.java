import java.util.*;
class TreeNode23 {
    int val;
    TreeNode23 left;
    TreeNode23 right;

    TreeNode23(int val) {
        this.val = val;
    }

    TreeNode23(int val, TreeNode23 left, TreeNode23 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static TreeNode23 buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public static TreeNode23 construct(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode23 root = new TreeNode23(preorder[preStart]);

        int index = inStart;

        while (inorder[index] != root.val) {
            index++;
        }

        int leftSize = index - inStart;

        root.left = construct(preorder, inorder, preStart + 1, inStart, index - 1);

        root.right = construct(preorder, inorder, preStart + leftSize + 1, index + 1, inEnd);

        return root;
    }
    public static void display(TreeNode23 root) {
        if (root == null) {
            return;
        }

        display(root.left);
        System.out.print(root.val + " ");
        display(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode23 root = buildTree(preorder, inorder);

        System.out.println("Binary Tree Constructed Successfully");
        display(root);
    }
}
