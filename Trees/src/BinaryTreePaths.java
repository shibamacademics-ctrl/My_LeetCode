import java.util.*;
class TreeNode18 {
    int val;
    TreeNode18 left;
    TreeNode18 right;

    TreeNode18(int val) {
        this.val = val;
    }
    TreeNode18(int val, TreeNode18 left, TreeNode18 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode18 root){
        List<String> res = new ArrayList<>();
        dfs(root,"",res);
        return res;
    }
    private static void dfs(TreeNode18 node,String path,List<String>res){
        if(node == null) return;
        path+=node.val;
        if(node.left==null && node.right==null){
            res.add(path);
            return;
        }
        path+="->";
        dfs(node.left,path,res);
        dfs(node.right,path,res);
    }
    public static void main(String[] args) {
        TreeNode18 root = new TreeNode18(1);

        root.left = new TreeNode18(2);
        root.right = new TreeNode18(3);

        root.left.right = new TreeNode18(5);

        List<String> result = binaryTreePaths(root);

        System.out.println("Binary Tree Paths: " + result);
    }
}
