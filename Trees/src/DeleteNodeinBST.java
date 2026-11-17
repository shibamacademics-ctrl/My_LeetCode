import java.util.*;
class TreeNode29 {
    int data;
    TreeNode29 left;
    TreeNode29 right;

    TreeNode29(int val) {
        data = val;
        left = null;
        right = null;
    }
}
class DeleteNodeinBST {
    public static TreeNode29 deleteNode(TreeNode29 root, int key) {

        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }
            TreeNode29 successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            root.data = successor.data;

            root.right = deleteNode(root.right, successor.data);
        }

        return root;
    }
    public static void inorder(TreeNode29 root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode29 root = new TreeNode29(50);
        root.left = new TreeNode29(30);
        root.right = new TreeNode29(70);

        root.left.left = new TreeNode29(20);
        root.left.right = new TreeNode29(40);

        root.right.left = new TreeNode29(60);
        root.right.right = new TreeNode29(80);

        System.out.println("Original BST:");
        inorder(root);

        root = deleteNode(root, 50);

        System.out.println("\nAfter deleting 50:");
        inorder(root);
    }
}
