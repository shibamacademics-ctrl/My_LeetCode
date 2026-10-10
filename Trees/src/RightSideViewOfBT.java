import java.util.*;
class TreeNode17 {
    int val;
    TreeNode17 left;
    TreeNode17 right;

    TreeNode17(int val) {
        this.val = val;
    }
    TreeNode17(int val, TreeNode17 left, TreeNode17 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class RightSideViewOfBT {
    public static List<Integer> rightSideView(TreeNode17 root){
        List<Integer> res = new ArrayList<>();
        rightSide(root,res,0);
        return res;
    }
    private static void rightSide(TreeNode17 node,List<Integer> res,int level){
        if(node == null) return;
        if(res.size() == level){
            res.add(node.val);
        }
        rightSide(node.right,res,level+1);
        rightSide(node.left,res,level+1);
    }
    public static void main(String[] args) {
        TreeNode17 root = new TreeNode17(1);

        root.left = new TreeNode17(2);
        root.right = new TreeNode17(3);

        root.left.left = new TreeNode17(4);
        root.left.right = new TreeNode17(5);

        root.right.left = new TreeNode17(6);
        root.right.right = new TreeNode17(7);

        List<Integer> result = rightSideView(root);

        System.out.println("Right Side View: " + result);
    }

}
