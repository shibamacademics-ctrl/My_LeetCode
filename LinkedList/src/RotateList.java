class Node18{
    int val;
    Node18 next;
    Node18(int val){
        this.val = val;
        this.next = null;
    }
}
public class RotateList {
    public Node18 rotate(Node18 head,int k){
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int n = 1;
        Node18 tail  = head;
        while(tail.next!=null){
            tail = tail.next;
            n++;
        }
        k = k%n;
        if(k == 0){
            return head;
        }
        tail.next = head;
        int steps = n - k - 1;
        Node18 newTail = head;
        for(int i = 0;i<steps;i++){
            newTail = newTail.next;
        }
        Node18 newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
    public static void main(String[] args) {
        RotateList obj = new RotateList();

        Node18 head = new Node18(1);
        head.next = new Node18(2);
        head.next.next = new Node18(3);
        head.next.next.next = new Node18(4);
        head.next.next.next.next = new Node18(5);

        int k = 2;

        head = obj.rotate(head, k);
        Node18 temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
