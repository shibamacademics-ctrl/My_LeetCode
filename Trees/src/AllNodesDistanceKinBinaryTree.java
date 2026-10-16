import java.util.*;
class AllNodesDistanceKinBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        findParents(root, null, parent);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (distance == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && visited.add(node.left)) {
                    queue.offer(node.left);
                }
                if (node.right != null && visited.add(node.right)) {
                    queue.offer(node.right);
                }
                TreeNode p = parent.get(node);
                if (p != null && visited.add(p)) {
                    queue.offer(p);
                }
            }

            distance++;
        }

        return result;
    }

    private static void findParents(TreeNode node, TreeNode p,
                             Map<TreeNode, TreeNode> parent) {
        if (node == null) {
            return;
        }

        parent.put(node, p);

        findParents(node.left, node, parent);
        findParents(node.right, node, parent);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode target = root.left;
        int k = 2;
        AllNodesDistanceKinBinaryTree solution = new AllNodesDistanceKinBinaryTree();
        List<Integer> result = solution.distanceK(root, target, k);
        System.out.println("Nodes at distance " + k + " from target " + target.val + ":");
        System.out.println(result);
    }
}
