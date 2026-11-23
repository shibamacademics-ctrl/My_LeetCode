import java.util.*;
class TreeNode36 {
    int val;
    TreeNode36 left, right;

    TreeNode36(int val) {
        this.val = val;
    }
}
class BSTIterator {
    private Stack<TreeNode36> st = new Stack<>();

    public BSTIterator(TreeNode36 root) {
        pushAll(root);
    }
    public int next() {
        TreeNode36 node = st.pop();
        pushAll(node.right);
        return node.val;
    }
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void pushAll(TreeNode36 root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
    public static void main(String[] args) {
        TreeNode36 root = new TreeNode36(7);
        root.left = new TreeNode36(3);
        root.right = new TreeNode36(15);
        root.right.left = new TreeNode36(9);
        root.right.right = new TreeNode36(20);

        BSTIterator obj = new BSTIterator(root);

        while (obj.hasNext()) {
            System.out.print(obj.next() + " ");
        }
    }
}
