import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode1 root){
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode1> st = new Stack<>();
        if(root == null) return preorder;

        st.push(root);
        while(!st.isEmpty()){
            TreeNode1 node = st.pop();
            preorder.add(node.val);
            if(node.right!=null){
                st.push(node.right);
            }
            if(node.left!=null){
                st.push(node.left);
            }
        }
        return preorder;
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);

        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);

        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);
        BinaryTreePreorderTraversal obj =
                new BinaryTreePreorderTraversal();

        List<Integer> result = obj.preorderTraversal(root);
        System.out.println("Preorder Traversal: " + result);
    }
}
