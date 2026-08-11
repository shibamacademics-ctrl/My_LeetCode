class Node4{
    int val;
    Node4 next;
    Node4(int val){
        this.val = val;
        this.next = null;
    }
}
public class CycleLinkedListTwo {
    Node4 head;
    public void insertEnd(int val) {
        Node4 newNode = new Node4(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node4 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void display() {

        Node4 current = head;

        while (current != null) {

            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }
    public Node4 startingpoint(Node4 head){
        if(head==null || head.next == null){
            return head;
        }
        Node4 slow = head;
        Node4 fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        CycleLinkedListTwo ll = new CycleLinkedListTwo();
        ll.insertEnd(1);
        ll.insertEnd(2);
        ll.insertEnd(3);
        ll.insertEnd(4);
        ll.insertEnd(5);

        Node4 current = ll.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = ll.head.next;

        System.out.println("Starting point of the cycle:"+ll.startingpoint(ll.head).val);
    }
}
