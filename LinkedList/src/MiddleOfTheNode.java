class Node1 {
int val;
Node1 next;

Node1(int val) {
    this.val = val;
    this.next = null;
}
}
public class MiddleOfTheNode {
    Node1 head;

    public void insertBeg(int val) {
        Node1 newNode = new Node1(val);
        newNode.next = head;
        head = newNode;
    }


    public void insertEnd(int val) {
        Node1 newNode = new Node1(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node1 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void insertAtPosition(int val, int pos) {

        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            insertBeg(val);
            return;
        }
        Node1 current = head;
        for (int i = 1; i < pos - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Out of Range");
            return;
        }

        Node1 newNode = new Node1(val);
        newNode.next = current.next;
        current.next = newNode;
    }
    public Node1 middle(Node1 head){
        Node1 slow = head,fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void display() {

        Node1 current = head;

        while (current != null) {

            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        MiddleOfTheNode ll = new MiddleOfTheNode();
        Node1 head = null;
        ll.insertEnd(4);
        ll.insertEnd(5);
        ll.insertEnd(1);
        ll.insertEnd(3);
        ll.insertEnd(2);
        System.out.println("Linked List:");
        ll.display();
        Node1 middleNode = ll.middle(ll.head);
        System.out.println("Middle Node: " + middleNode.val);
    }
}
