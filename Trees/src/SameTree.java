class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;

    TreeNode5() {}

    TreeNode5(int val) {
        this.val = val;
    }

    TreeNode5(int val, TreeNode5 left, TreeNode5 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class SameTree {
    public boolean isSameTree(TreeNode5 p, TreeNode5 q){
        if(p == q) return (p == q);
        return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        TreeNode5 p = new TreeNode5(1);
        p.left = new TreeNode5(2);
        p.right = new TreeNode5(3);
        TreeNode5 q = new TreeNode5(1);
        q.left = new TreeNode5(2);
        q.right = new TreeNode5(3);

        SameTree obj = new SameTree();
        boolean result = obj.isSameTree(p, q);

        System.out.println("Are the trees same? " + result);
    }
}
