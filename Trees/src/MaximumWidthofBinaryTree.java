import java.util.LinkedList;
import java.util.Queue;

class TreeNode8 {
    int val;
    TreeNode8 left;
    TreeNode8 right;

    TreeNode8(int val) {
        this.val = val;
    }

    TreeNode8(int val, TreeNode8 left, TreeNode8 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair {
    TreeNode8 node;
    int index;

    Pair(TreeNode8 node, int index) {
        this.node = node;
        this.index = index;
    }
}

class MaximumWidthofBinaryTree {

    public static int widthOfBinaryTree(TreeNode8 root) {

        if (root == null)
            return 0;

        int maxwidth = 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            int size = q.size();

            int first = q.peek().index;
            int last = first;

            for (int i = 0; i < size; i++) {

                Pair current = q.poll();

                TreeNode8 node = current.node;
                int index = current.index;

                last = index;

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * index + 2));
                }
            }

            int width = last - first + 1;

            maxwidth = Math.max(maxwidth, width);
        }

        return maxwidth;
    }

    public static void main(String[] args) {
        TreeNode8 root = new TreeNode8(1);
        root.left = new TreeNode8(3);
        root.right = new TreeNode8(2);
        root.left.left = new TreeNode8(5);
        root.left.right = new TreeNode8(3);
        root.right.right = new TreeNode8(9);
        int result = widthOfBinaryTree(root);
        System.out.println("Maximum Width: " + result);
    }
}