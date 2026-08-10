
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class IntroductionToSingleLL {

    Node head;

    public void insertBeg(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }


    public void insertEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
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

        Node current = head;
        for (int i = 1; i < pos - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Out of Range");
            return;
        }

        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
    }
    public void DeleteBeg() {

        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }

        head = head.next;
    }
    public void DeleteEnd() {

        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        if (head.next == null) {
            DeleteBeg();
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
    public void DeleteAtPosition(int pos) {

        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            DeleteBeg();
            return;
        }
        Node current = head;
        for (int i = 1; i < pos - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Position out of range");
            return;
        }

        current.next = current.next.next;
    }
    public int search(int val) {

        Node current = head;
        int pos = 1;

        while (current != null) {
            if (current.val == val) {
                return pos;
            }
            current = current.next;
            pos++;
        }
        return -1;
    }
    public void display() {

        Node current = head;

        while (current != null) {

            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }
    public static void main(String args[]) {

        IntroductionToSingleLL ll = new IntroductionToSingleLL();

        ll.insertEnd(10);
        ll.insertEnd(20);
        ll.insertEnd(30);
        ll.insertEnd(40);

        System.out.println("Original List:");
        ll.display();

        ll.insertBeg(5);

        System.out.println("After insertBeg(5):");
        ll.display();

        ll.insertAtPosition(25, 4);

        System.out.println("After insertAtPosition(25, 4):");
        ll.display();

        ll.DeleteBeg();

        System.out.println("After DeleteBeg():");
        ll.display();

        ll.DeleteEnd();

        System.out.println("After DeleteEnd():");
        ll.display();

        ll.DeleteAtPosition(2);

        System.out.println("After DeleteAtPosition(2):");
        ll.display();

        int result = ll.search(30);

        System.out.println("Position of 30: " + result);
    }
}

