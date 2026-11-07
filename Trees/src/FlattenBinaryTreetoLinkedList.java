import java.util.*;
class TreeNode22 {
    int val;
    TreeNode22 left;
    TreeNode22 right;

    TreeNode22(int val) {
        this.val = val;
    }

    TreeNode22(int val, TreeNode22 left, TreeNode22 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class FlattenBinaryTreetoLinkedList {
    TreeNode22 prev = null;
    public void flatten(TreeNode22 root) {
        if (root == null)
            return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }

    public static void main(String[] args) {
        TreeNode22 root = new TreeNode22(1);
        root.left = new TreeNode22(2);
        root.right = new TreeNode22(5);
        root.left.left = new TreeNode22(3);
        root.left.right = new TreeNode22(4);
        root.right.right = new TreeNode22(6);

        FlattenBinaryTreetoLinkedList obj =
                new FlattenBinaryTreetoLinkedList();

        obj.flatten(root);
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("NULL");
    }
}
