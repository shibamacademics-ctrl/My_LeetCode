import java.util.*;
class TreeNode32 {
    int data;
    TreeNode32 left;
    TreeNode32 right;

    TreeNode32(int val) {
        data = val;
        left = null;
        right = null;
    }
}
class LCAinBST {
    public static TreeNode32 lowestCommonAncestor(TreeNode32 root, TreeNode32 p, TreeNode32 q){
        if(root == null) return null;
        int curr = root.data;
        if(curr<p.data && curr<q.data){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(curr>p.data && curr>q.data){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode32 root = new TreeNode32(6);
        root.left = new TreeNode32(2);
        root.right = new TreeNode32(8);

        root.left.left = new TreeNode32(0);
        root.left.right = new TreeNode32(4);

        root.right.left = new TreeNode32(7);
        root.right.right = new TreeNode32(9);

        TreeNode32 p = root.left;        // Node 2
        TreeNode32 q = root.left.right;  // Node 4

        TreeNode32 lca = lowestCommonAncestor(root, p, q);

        System.out.println("LCA: " + lca.data);
    }
}
