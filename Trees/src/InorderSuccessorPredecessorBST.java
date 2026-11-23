class TreeNode35 {
    int data;
    TreeNode35 left, right;

    TreeNode35(int data) {
        this.data = data;
    }
}
class BST {
    public static TreeNode35 predecessor(TreeNode35 root, int key) {
        TreeNode35 pred = null;

        while (root != null) {
            if (key > root.data) {
                pred = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return pred;
    }
    public static TreeNode35 successor(TreeNode35 root, int key) {
        TreeNode35 succ = null;

        while (root != null) {
            if (key < root.data) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }

        public static void main(String[] args) {

            TreeNode35 root = new TreeNode35(50);
            root.left = new TreeNode35(30);
            root.right = new TreeNode35(70);

            root.left.left = new TreeNode35(20);
            root.left.right = new TreeNode35(40);

            root.right.left = new TreeNode35(60);
            root.right.right = new TreeNode35(80);

            int key = 50;

            TreeNode35 pred = predecessor(root, key);
            TreeNode35 succ = successor(root, key);
            System.out.println("Predecessor: " +
                    (pred != null ? pred.data : "None"));

            System.out.println("Successor: " +
                    (succ != null ? succ.data : "None"));
        }

    }