import java.util.*;
class TreeNode37 {
    int val;
    TreeNode37 left, right;

    TreeNode37(int val) {
        this.val = val;
    }
}
class TwoSuminBST {
    public static boolean findTarget(TreeNode37 root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    public static boolean dfs(TreeNode37 root, int k, HashSet<Integer> set) {
        if (root == null)
            return false;

        if (set.contains(k - root.val))
            return true;

        set.add(root.val);

        return dfs(root.left, k, set) ||
                dfs(root.right, k, set);
    }
    public static void main(String[] args) {
        TreeNode37 root = new TreeNode37(5);
        root.left = new TreeNode37(3);
        root.right = new TreeNode37(6);
        root.left.left = new TreeNode37(2);
        root.left.right = new TreeNode37(4);
        root.right.right = new TreeNode37(7);

        int k = 9;

        System.out.println(findTarget(root, k));
    }
}