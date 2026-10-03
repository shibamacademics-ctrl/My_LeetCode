import java.util.*;
class TreeNode11 {
    int val;
    TreeNode11 left;
    TreeNode11 right;

    TreeNode11(int val) {
        this.val = val;
    }

    TreeNode11(int val, TreeNode11 left, TreeNode11 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class ZigZagTreeTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode11 root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode11> q = new LinkedList<>();
        q.offer(root);
        boolean lefttoright = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode11 node = q.poll();
                level.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            if(!lefttoright){
                Collections.reverse(level);
            }
            result.add(level);
            lefttoright = !lefttoright;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode11 root = new TreeNode11(3);

        root.left = new TreeNode11(9);
        root.right = new TreeNode11(20);

        root.right.left = new TreeNode11(15);
        root.right.right = new TreeNode11(7);
        List<List<Integer>> answer = zigzagLevelOrder(root);
        System.out.println(answer);
    }
}
