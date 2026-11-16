import java.util.*;
class TreeNode28 {
    int data;
    TreeNode28 left;
    TreeNode28 right;

    TreeNode28(int val) {
        data = val;
        left = null;
        right = null;
    }
}
class InsertNodeinBST {
    public TreeNode28 insertIntoBST(TreeNode28 root, int val){
        if(root == null){
            return new TreeNode28(val);
        }
        TreeNode28 curr = root;
        while(true){
            if(curr.data<=val){
                if(curr.right!=null){
                    curr = curr.right;
                }
                else{
                    curr.right = new TreeNode28((val));
                    break;
                }
            }
            else{
                if(curr.left!=null){
                    curr = curr.left;
                }
                else{
                    curr.left = new TreeNode28((val));
                    break;
                }
            }
        }
        return root;
    }
    public void display(TreeNode28 root) {
        if (root == null) {
            return;
        }

        display(root.left);
        System.out.print(root.data + " ");
        display(root.right);
    }

    public static void main(String[] args) {
        InsertNodeinBST obj = new InsertNodeinBST();

        TreeNode28 root = new TreeNode28(50);

        obj.insertIntoBST(root, 30);
        obj.insertIntoBST(root, 70);
        obj.insertIntoBST(root, 20);
        obj.insertIntoBST(root, 40);
        obj.insertIntoBST(root, 60);
        obj.insertIntoBST(root, 80);

        System.out.println("BST Inorder Traversal:");
        obj.display(root);
    }
}
