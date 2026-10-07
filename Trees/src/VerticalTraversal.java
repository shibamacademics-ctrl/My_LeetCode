import java.util.*;
class TreeNode13 {
    int val;
    TreeNode13 left;
    TreeNode13 right;

    TreeNode13(int val) {
        this.val = val;
    }

    TreeNode13(int val, TreeNode13 left, TreeNode13 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode13 root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0});

        while (!queue.isEmpty()) {
            Object[] curr = queue.poll();

            TreeNode13 node = (TreeNode13) curr[0];
            int row = (int) curr[1];
            int col = (int) curr[2];

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, node.val});

            if (node.left != null) {
                queue.offer(new Object[]{
                        node.left, row + 1, col - 1
                });
            }

            if (node.right != null) {
                queue.offer(new Object[]{
                        node.right, row + 1, col + 1
                });
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (List<int[]> nodes : map.values()) {
            nodes.sort((a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);

                return Integer.compare(a[1], b[1]);
            });

            List<Integer> column = new ArrayList<>();

            for (int[] node : nodes) {
                column.add(node[1]);
            }

            ans.add(column);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode13 root = new TreeNode13(
                3,
                new TreeNode13(9),
                new TreeNode13(
                        20,
                        new TreeNode13(15),
                        new TreeNode13(7)
                )
        );

        VerticalTraversal obj = new VerticalTraversal();

        List<List<Integer>> result = obj.verticalTraversal(root);

        System.out.println(result);
    }
}
