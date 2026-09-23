import java.util.ArrayList;
import java.util.List;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2() {}

    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode2 root) {
        List<Integer> result = new ArrayList<>();

        postorder(root, result);

        return result;
    }

    private void postorder(TreeNode2 root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    public static void main(String[] args) {

        TreeNode2 root = new TreeNode2(1);

        root.left = new TreeNode2(2);
        root.right = new TreeNode2(3);

        root.left.left = new TreeNode2(4);
        root.left.right = new TreeNode2(5);
        BinaryTreePostorderTraversal obj =
                new BinaryTreePostorderTraversal();
        List<Integer> result = obj.postorderTraversal(root);

        System.out.println("Postorder Traversal: " + result);
    }
}