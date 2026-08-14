class Node9{
    int val;
    Node9 next;
    Node9(int val){
        this.val = val;
        this.next = null;
    }
}
public class RemoveMiddleNode {
    Node9 head;
    public void insertEnd(int val) {
        Node9 newNode = new Node9(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node9 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void display() {

        Node9 current = head;

        while (current != null) {

            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    public Node9 removemiddle(Node9 head){
        if(head == null || head.next == null){
            return null;
        }
        Node9 slow = head;
        Node9 fast = head.next.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveMiddleNode list = new RemoveMiddleNode();

        list.insertEnd(1);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(7);
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(6);

        System.out.println("Before:");
        list.display();

        list.head = list.removemiddle(list.head);

        System.out.println("After:");
        list.display();
    }
}
