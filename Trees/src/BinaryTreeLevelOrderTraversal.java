import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;

    TreeNode3() {}

    TreeNode3(int val) {
        this.val = val;
    }

    TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode3 root){
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        Queue<TreeNode3> q = new LinkedList<TreeNode3>();
        if(root == null) return wrapList;
        q.offer(root);
        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i = 0;i<levelNum;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public static void main(String[] args) {
        TreeNode3 root = new TreeNode3(3);

        root.left = new TreeNode3(9);
        root.right = new TreeNode3(20);

        root.right.left = new TreeNode3(15);
        root.right.right = new TreeNode3(7);

        List<List<Integer>> result = levelOrder(root);

        System.out.println(result);
    }
}
