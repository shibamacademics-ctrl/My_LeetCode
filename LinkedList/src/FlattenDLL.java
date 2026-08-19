public class FlattenDLL {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        flattenDFS(head);
        return head;
    }

    private static Node flattenDFS(Node curr) {

        Node last = curr;

        while (curr != null) {

            Node next = curr.next;
            if (curr.child != null) {
                Node childHead = curr.child;
                Node childTail = flattenDFS(childHead);
                curr.next = childHead;
                childHead.prev = curr;
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                curr.child = null;

                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        Node n7 = new Node(7);
        Node n8 = new Node(8);

        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n1.next = n2;
        n2.prev = n1;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n4.prev = n3;

        n3.child = n7;

        n7.next = n8;
        n8.prev = n7;
        n8.child = n11;

        n11.next = n12;
        n12.prev = n11;
        Node head = flatten(n1);

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.val);

            if (curr.next != null) {
                System.out.print(" -> ");
            }

            curr = curr.next;
        }
    }
}