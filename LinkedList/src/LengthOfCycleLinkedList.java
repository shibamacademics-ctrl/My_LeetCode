class Node5{
    int val;
    Node5 next;
    Node5(int val){
        this.val = val;
        this.next = null;
    }
}
public class LengthOfCycleLinkedList {
    Node5 head;
    public void insertEnd(int val) {
        Node5 newNode = new Node5(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node5 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void display() {

        Node5 current = head;

        while (current != null) {

            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }
    public int length(Node5 head){
        if(head == null || head.next == null){
            return 0;
        }
        Node5 slow = head;
        Node5 fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                int count = 1;
                fast = fast.next;
                while(slow!=fast){
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        LengthOfCycleLinkedList list = new LengthOfCycleLinkedList();

        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertEnd(40);
        list.insertEnd(50);

        Node5 current = list.head;

        Node5 cycleStart = null;
        Node5 tail = null;

        while (current != null) {
            if (current.val == 30) {
                cycleStart = current;
            }

            tail = current;
            current = current.next;
        }

        tail.next = cycleStart;

        System.out.println("Length of cycle: " + list.length(list.head));
    }
}
