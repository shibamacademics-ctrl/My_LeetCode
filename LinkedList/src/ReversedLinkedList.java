class Node2 {
    int val;
    Node2 next;

    Node2(int val) {
        this.val = val;
        this.next = null;
    }
}
public class ReversedLinkedList {
    Node2 head;
    public void insertEnd(int val) {
        Node2 newNode = new Node2(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node2 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public Node2 reversed(Node2 head){
        if(head==null || head.next==null){
            return head;
        }
        Node2 current = head;
        Node2 prev = null;
        while(current!=null){
            Node2 after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }
        return prev;
    }
    public void display() {

        Node2 current = head;

        while (current != null) {

            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }
    public static void main(String[] args) {
        ReversedLinkedList ll = new ReversedLinkedList();
        ll.insertEnd(1);
        ll.insertEnd(2);
        ll.insertEnd(3);
        ll.insertEnd(4);
        ll.insertEnd(5);
        System.out.println("Original LinkedList");
        ll.display();
        ll.head = ll.reversed(ll.head);
        System.out.println("Reversed LinkedList");
        ll.display();

    }
}
