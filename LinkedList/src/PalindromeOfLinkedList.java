class Node6{
    int val;
    Node6 next;
    Node6(int val){
        this.val = val;
        this.next = null;
    }
}
public class PalindromeOfLinkedList {
    public static Node6 reverse(Node6 head) {
        Node6 current = head;
        Node6 prev = null;
        Node6 after = null;

        while (current != null) {
            after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }

        return prev;
    }

    public boolean isPalindrome(Node6 head) {
        Node6 slow = head;
        Node6 fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        Node6 newHead = reverse(slow.next);
        Node6 first = head;
        Node6 sec = newHead;
        while (sec != null) {
            if (first.val != sec.val) {
                reverse(newHead);
                return false;
            }
            first = first.next;
            sec = sec.next;
        }
        reverse(newHead);
        return true;
    }

    public static void main(String[] args) {
        PalindromeOfLinkedList list = new PalindromeOfLinkedList();

        Node6 head = new Node6(1);
        head.next = new Node6(2);
        head.next.next = new Node6(3);
        head.next.next.next = new Node6(2);
        head.next.next.next.next = new Node6(1);

        System.out.println(list.isPalindrome(head));
    }
}
