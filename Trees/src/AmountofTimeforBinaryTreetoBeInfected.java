import java.util.*;
class TreeNode20 {
    int val;
    TreeNode20 left;
    TreeNode20 right;

    TreeNode20(int val) {
        this.val = val;
    }

    TreeNode20(int val, TreeNode20 left, TreeNode20 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class AmountofTimeforBinaryTreetoBeInfected {

    public int amountOfTime(TreeNode20 root, int start) {

        Map<TreeNode20, TreeNode20> parentMap = new HashMap<>();

        TreeNode20 startNode = findStartNode(root, start, parentMap);

        Queue<TreeNode20> queue = new LinkedList<>();
        Set<TreeNode20> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode);

        int time = -1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) {

                TreeNode20 current = queue.poll();

                if (current.left != null &&
                        visited.add(current.left)) {
                    queue.offer(current.left);
                }

                if (current.right != null &&
                        visited.add(current.right)) {
                    queue.offer(current.right);
                }

                TreeNode20 parent = parentMap.get(current);

                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
            }
        }

        return time;
    }

    private TreeNode20 findStartNode(
            TreeNode20 root,
            int start,
            Map<TreeNode20, TreeNode20> parentMap) {

        Queue<TreeNode20> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode20 startNode = null;

        while (!queue.isEmpty()) {

            TreeNode20 current = queue.poll();

            if (current.val == start) {
                startNode = current;
            }

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }

            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }

        return startNode;
    }

    public static void main(String[] args) {
        TreeNode20 root = new TreeNode20(1);

        root.left = new TreeNode20(2);
        root.right = new TreeNode20(3);

        root.left.left = new TreeNode20(4);

        root.right.left = new TreeNode20(5);
        root.right.right = new TreeNode20(6);

        root.right.left.left = new TreeNode20(7);
        int start = 3;
        AmountofTimeforBinaryTreetoBeInfected obj =
                new AmountofTimeforBinaryTreetoBeInfected();
        int result = obj.amountOfTime(root, start);

        System.out.println("Time required: " + result);
    }
}
