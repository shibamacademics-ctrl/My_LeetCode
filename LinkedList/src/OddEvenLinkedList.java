class Node7{
    int val;
    Node7 next;
    Node7(int val){
        this.val = val;
        this.next = null;
    }
}
public class OddEvenLinkedList {
    Node7 head;
    public void insertEnd(int val) {
        Node7 newNode = new Node7(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node7 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void display() {

        Node7 current = head;

        while (current != null) {

            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }
    public Node7 oddeven(Node7 head){
        if(head==null || head.next == null){
            return head;
        }
        Node7 odd = head,even = head.next,evenHead = head.next;
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static void main(String[] args) {
        OddEvenLinkedList list = new OddEvenLinkedList();

        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);

        System.out.println("Original list:");
        list.display();

        list.head = list.oddeven(list.head);

        System.out.println("Odd-Even list:");
        list.display();
    }
}
