import java.util.*;
class TreeNode12 {
    int val;
    TreeNode12 left;
    TreeNode12 right;

    TreeNode12(int val) {
        this.val = val;
    }

    TreeNode12(int val, TreeNode12 left, TreeNode12 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BoundaryTraversal {
    public static boolean isLeaf(TreeNode12 node){
        return node.left==null && node.right==null;
    }
    public static void addLeftBoundary(TreeNode12 root,ArrayList<Integer> result){
        TreeNode12 curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr)){
                result.add(curr.val);
            }
            if(curr.left!=null){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
    }
    public static void addLeaves(TreeNode12 root,ArrayList<Integer> result){
        if(root == null)
            return;
        if(isLeaf(root)){
            result.add(root.val);
            return;
        }
        addLeaves(root.left,result);
        addLeaves(root.right,result);

    }
    public static void addRightBoundary(TreeNode12 root,ArrayList<Integer> result){
        TreeNode12 curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr)){
                temp.add(curr.val);
            }
            if(curr.right!=null){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        for(int i = temp.size() - 1;i>=0;i--){
            result.add(temp.get(i));
        }
    }
    public static ArrayList<Integer> boundary(TreeNode12 root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(!isLeaf(root)){
            result.add(root.val);
        }
        addLeftBoundary(root,result);
        addLeaves(root,result);
        addRightBoundary(root,result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode12 root = new TreeNode12(1);
        root.left = new TreeNode12(2);
        root.right = new TreeNode12(3);
        root.left.left = new TreeNode12(4);
        root.left.right = new TreeNode12(5);
        root.left.right.left = new TreeNode12(6);
        root.left.right.right = new TreeNode12(8);
        root.right.right = new TreeNode12(7);
        ArrayList<Integer> result = boundary(root);
        System.out.println(result);
    }
}
