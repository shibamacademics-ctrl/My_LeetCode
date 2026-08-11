class Node3{
    int val;
    Node3 next;
    Node3(int val){
        this.val = val;
        this.next = null;
    }
}
public class CycledLinkedList {
    Node3 head;
    public void insertEnd(int val) {
        Node3 newNode = new Node3(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node3 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void display() {

        Node3 current = head;

        while (current != null) {

            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }
    public boolean Iscycle(Node3 head){
        if(head==null || head.next == null){
            return false;
        }
        Node3 slow = head;
        Node3 fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        CycledLinkedList ll = new CycledLinkedList();
        ll.insertEnd(1);
        ll.insertEnd(2);
        ll.insertEnd(3);
        ll.insertEnd(4);
        ll.insertEnd(5);

        Node3 current = ll.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = ll.head.next;

        System.out.println("Cycle Exist:"+ll.Iscycle(ll.head));
    }
}
