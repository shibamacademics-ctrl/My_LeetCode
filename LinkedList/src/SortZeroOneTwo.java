class Node10{
    int val;
    Node10 next;
    Node10(int val){
        this.val = val;
        this.next = null;
    }
}
public class SortZeroOneTwo {
    Node10 head;

    public Node10 sort(Node10 head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node10 zeroHead = new Node10(-1);
        Node10 oneHead = new Node10(-1);
        Node10 twoHead = new Node10(-1);
        Node10 zero = zeroHead, one = oneHead, two = twoHead;
        Node10 current = head;
        while (current != null) {
            if (current.val == 0) {
                zero.next = current;
                zero = zero.next;
            } else if (current.val == 1) {
                one.next = current;
                one = one.next;
            } else {
                two.next = current;
                two = two.next;
            }
            current = current.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = (twoHead.next != null) ? twoHead.next : null;
        two.next = null;
        return zeroHead.next;
    }

    public static void main(String[] args) {
        SortZeroOneTwo obj = new SortZeroOneTwo();

        Node10 head = new Node10(1);
        head.next = new Node10(2);
        head.next.next = new Node10(0);
        head.next.next.next = new Node10(2);
        head.next.next.next.next = new Node10(1);
        head.next.next.next.next.next = new Node10(0);


        head = obj.sort(head);


        Node10 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
