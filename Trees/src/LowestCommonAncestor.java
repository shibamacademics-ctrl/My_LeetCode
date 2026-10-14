import java.util.*;
class TreeNode19 {
    int val;
    TreeNode19 left;
    TreeNode19 right;

    TreeNode19(int val) {
        this.val = val;
    }
    TreeNode19(int val, TreeNode19 left, TreeNode19 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class LowestCommonAncestor {
    public static TreeNode19 lowestCommonAncest1or(TreeNode19 root, TreeNode19 p, TreeNode19 q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode19 left = lowestCommonAncest1or(root.left, p, q);
        TreeNode19 right = lowestCommonAncest1or(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode19 root = new TreeNode19(3);
        root.left = new TreeNode19(5);
        root.right = new TreeNode19(1);

        root.left.left = new TreeNode19(6);
        root.left.right = new TreeNode19(2);

        root.right.left = new TreeNode19(0);
        root.right.right = new TreeNode19(8);

        root.left.right.left = new TreeNode19(7);
        root.left.right.right = new TreeNode19(4);
        TreeNode19 p = root.left;
        TreeNode19 q = root.left.right.right;
        TreeNode19 result = lowestCommonAncest1or(root, p, q);
        if (result != null) {
            System.out.println("Lowest Common Ancestor: " + result.val);
        } else {
            System.out.println("Lowest Common Ancestor not found");
        }

    }
}

