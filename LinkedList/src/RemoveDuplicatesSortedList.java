class Node15 {
    int val;
    Node15 next;
    Node15(int val){
        this.val = val;
        this.next = null;
    }
}
public class RemoveDuplicatesSortedList {
    public Node15 remove(Node15 head){
        Node15 temp = head;
        while(temp!=null && temp.next!=null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node15 head = new Node15(1);
        Node15 second = new Node15(1);
        Node15 third = new Node15(2);
        Node15 fourth = new Node15(2);
        Node15 fifth = new Node15(3);
        Node15 sixth = new Node15(4);
        Node15 seventh = new Node15(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        RemoveDuplicatesSortedList obj = new RemoveDuplicatesSortedList();

        head = obj.remove(head);
        Node15 temp = head;

        System.out.println("List after removing duplicates:");

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
