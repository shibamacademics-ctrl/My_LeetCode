class DlNode {
    int val;
    DlNode prev;
    DlNode next;

    DlNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class IntroductionToDoublyLL {

    DlNode head;

    public void insertBeg(int val) {
        DlNode newNode = new DlNode(val);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertEnd(int val) {
        DlNode newNode = new DlNode(val);

        if (head == null) {
            head = newNode;
            return;
        }

        DlNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;
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

        DlNode current = head;

        for (int i = 1; i < pos - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of range");
            return;
        }

        DlNode newNode = new DlNode(val);

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        }

        current.next = newNode;
    }

    public void DeleteBeg() {

        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }

        head = head.next;

        if (head != null) {
            head.prev = null;
        }
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

        DlNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.prev.next = null;
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

        DlNode current = head;

        for (int i = 1; i < pos && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of range");
            return;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

    public int search(int val) {

        DlNode current = head;
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

    public void displayForward() {

        DlNode current = head;

        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    public void displayBackward() {

        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }

        DlNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.prev;
        }

        System.out.println("NULL");
    }

    public static void main(String args[]) {

        IntroductionToDoublyLL ll = new IntroductionToDoublyLL();

        ll.insertEnd(10);
        ll.insertEnd(20);
        ll.insertEnd(30);
        ll.insertEnd(40);

        System.out.println("Original List:");
        ll.displayForward();

        ll.insertBeg(5);

        System.out.println("After insertBeg(5):");
        ll.displayForward();

        ll.insertAtPosition(25, 4);

        System.out.println("After insertAtPosition(25, 4):");
        ll.displayForward();

        ll.DeleteBeg();

        System.out.println("After DeleteBeg():");
        ll.displayForward();

        ll.DeleteEnd();

        System.out.println("After DeleteEnd():");
        ll.displayForward();

        ll.DeleteAtPosition(2);

        System.out.println("After DeleteAtPosition(2):");
        ll.displayForward();

        int result = ll.search(30);

        System.out.println("Position of 30: " + result);

        System.out.println("Forward:");
        ll.displayForward();

        System.out.println("Backward:");
        ll.displayBackward();
    }
}