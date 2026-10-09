import java.util.*;
class TreeNode16 {
    int val;
    TreeNode16 left;
    TreeNode16 right;

    TreeNode16(int val) {
        this.val = val;
    }
    TreeNode16(int val, TreeNode16 left, TreeNode16 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class BottomLeftViewBT {
    public int findBottomLeftValue(TreeNode16 root){
        Queue<TreeNode16> q = new LinkedList<>();
        q.offer(root);
        int res = root.val;
        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode16 node = q.poll();
                if (i == 0) {
                    res = node.val;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode16 root = new TreeNode16(2);
        root.left = new TreeNode16(1);
        root.right = new TreeNode16(3);
        BottomLeftViewBT obj = new BottomLeftViewBT();
        int result = obj.findBottomLeftValue(root);
        System.out.println("Bottom Left Value: " + result);
    }
}
