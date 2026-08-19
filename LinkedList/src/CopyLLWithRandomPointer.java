public class CopyLLWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node curr = head;

        while (curr != null) {
            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        curr = head;

        while (curr != null) {

            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        curr = head;

        while (curr != null) {

            Node copy = curr.next;

            curr.next = copy.next;
            copyCurr.next = copy;
            copyCurr = copy;

            curr = curr.next;
        }

        return dummy.next;
    }
    public static void printList(Node head) {

        Node curr = head;

        while (curr != null) {
            int randomValue = (curr.random != null)
                    ? curr.random.val
                    : -1;

            System.out.println(
                    "Node: " + curr.val +
                            ", Random: " + randomValue
            );

            curr = curr.next;
        }
    }

    public static void main(String[] args) {


        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = n3;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n2;

        Node copiedHead = copyRandomList(n1);

        System.out.println("Copied List:");

        printList(copiedHead);
    }
}