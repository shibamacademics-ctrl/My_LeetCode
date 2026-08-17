class Node16 {
    int val;
    Node16 next;
    Node16(int val){
        this.val = val;
        this.next = null;
    }
}
public class RemoveDuplicatesSortedListTwo {
    public Node16 remove(Node16 head){
        Node16 dummy = new Node16(0);
        dummy.next = head;
        Node16 prev = dummy,curr = head;

        while(curr!=null){
            if(curr.next!=null && curr.val == curr.next.val){
                while(curr.next!=null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                prev.next = curr.next;
            }
            else{
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Node16 head = new Node16(1);
        Node16 second = new Node16(2);
        Node16 third = new Node16(2);
        Node16 fourth = new Node16(3);
        Node16 fifth = new Node16(4);
        Node16 sixth = new Node16(4);
        Node16 seventh = new Node16(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        RemoveDuplicatesSortedListTwo obj = new RemoveDuplicatesSortedListTwo();

        head = obj.remove(head);

        Node16 temp = head;

        System.out.println("List after removing duplicates:");

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
