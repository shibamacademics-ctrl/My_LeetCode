import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }
class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        List<Integer> inorder = new ArrayList<>();
        TreeNode node = root;

        while(true){
            if(node!=null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                inorder.add(node.val);
                node = node.right;
            }
        }
        return inorder;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeInorderTraversal obj = new BinaryTreeInorderTraversal();

        List<Integer> result = obj.inorderTraversal(root);

        System.out.println("Inorder Traversal:");
        System.out.println(result);
    }
}
