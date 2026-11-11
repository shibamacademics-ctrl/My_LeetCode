import java.util.*;
class TreeNode24 {
    int val;
    TreeNode24 left;
    TreeNode24 right;

    TreeNode24(int val) {
        this.val = val;
    }

    TreeNode24(int val, TreeNode24 left, TreeNode24 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class ConstructBinaryTreefromnorderandPostorderTraversal {
    static int postIndex;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode24 buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    public static TreeNode24 helper(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = postorder[postIndex--];
        TreeNode24 root = new TreeNode24(rootVal);

        int index = map.get(rootVal);

        root.right = helper(inorder, postorder, index + 1, right);
        root.left = helper(inorder, postorder, left, index - 1);

        return root;
        }
        public static void main(String[] args) {

            int[] inorder = {9, 3, 15, 20, 7};
            int[] postorder = {9, 15, 7, 20, 3};

            ConstructBinaryTreefromnorderandPostorderTraversal obj =
                    new ConstructBinaryTreefromnorderandPostorderTraversal();

            TreeNode24 root = obj.buildTree(inorder, postorder);

            System.out.println("Preorder Traversal:");
            preorder(root);
        }

        static void preorder(TreeNode24 root) {
            if (root == null) {
                return;
            }

            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }

    }
