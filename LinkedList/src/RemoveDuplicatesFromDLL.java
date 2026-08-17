class Node14{
    int val;
    Node14 next;
    Node14 prev;
    Node14(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
public class RemoveDuplicatesFromDLL {
    public Node14 remove(Node14 head){
        Node14 temp = head;
        while(temp!=null && temp.next!=null){
            Node14 nextNode = temp.next;
            while(nextNode!=null && nextNode.val == temp.val){
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if(nextNode!=null) nextNode.prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node14 head = new Node14(1);
        Node14 second = new Node14(1);
        Node14 third = new Node14(2);
        Node14 fourth = new Node14(2);
        Node14 fifth = new Node14(3);
        Node14 sixth = new Node14(3);
        Node14 seventh = new Node14(4);

        head.next = second;
        second.prev = head;

        second.next = third;
        third.prev = second;

        third.next = fourth;
        fourth.prev = third;

        fourth.next = fifth;
        fifth.prev = fourth;

        fifth.next = sixth;
        sixth.prev = fifth;

        sixth.next = seventh;
        seventh.prev = sixth;

        RemoveDuplicatesFromDLL obj = new RemoveDuplicatesFromDLL();
        Node14 temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("NULL");
        head = obj.remove(head);
        System.out.println("DLL after removing duplicates:");
        temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
