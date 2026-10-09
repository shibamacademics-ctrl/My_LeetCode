import java.util.*;
class TreeNode15 {
    int val;
    TreeNode15 left;
    TreeNode15 right;

    TreeNode15(int val) {
        this.val = val;
    }
    TreeNode15(int val, TreeNode15 left, TreeNode15 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair3 {
    int line;
    TreeNode15 node;

    Pair3(TreeNode15 node, int line) {
        this.node = node;
        this.line = line;
    }
}
class BottomViewOfBT {
    public static ArrayList<Integer> bottomView(TreeNode15 root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair3> q = new LinkedList<>();

        q.add(new Pair3(root, 0));

        while (!q.isEmpty()) {
            Pair3 p = q.poll();

            TreeNode15 temp = p.node;
            int line = p.line;

            map.put(line, temp.val);

            if (temp.left != null) {
                q.add(new Pair3(temp.left, line - 1));
            }

            if (temp.right != null) {
                q.add(new Pair3(temp.right, line + 1));
            }
        }

        for (int value : map.values()) {
            res.add(value);
        }

        return res;
    }

    public static void main(String[] args) {

        TreeNode15 root = new TreeNode15(1);
        root.left = new TreeNode15(2);
        root.right = new TreeNode15(3);

        root.left.right = new TreeNode15(4);

        root.right.left = new TreeNode15(5);
        root.right.right = new TreeNode15(6);
        root.right.left.right = new TreeNode15(7);

        ArrayList<Integer> result = bottomView(root);

        System.out.println("Bottom View: " + result);
    }
}

