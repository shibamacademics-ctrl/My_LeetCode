class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

class IntroductionToTrees {
    static void display(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        display(root);
    }
}