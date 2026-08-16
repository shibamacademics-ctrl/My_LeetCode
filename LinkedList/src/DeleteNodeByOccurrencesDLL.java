class Node13{
    int val;
    Node13 next;
    Node13 prev;
    Node13(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
public class DeleteNodeByOccurrencesDLL {
    Node13 head;
    public Node13 delete(Node13 head,int key){
        Node13 temp = head;
        while(temp!=null){
            if(temp.val == key){
                if(temp == head){
                    head = temp.next;
                }
                Node13 nextNode = temp.next;
                Node13 prevNode = temp.prev;
                if(nextNode!=null) nextNode.prev = prevNode;
                if(prevNode!=null) prevNode.next = nextNode;
                temp = nextNode;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
    public void display(Node13 head) {

        Node13 temp = head;

        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }
    public static void main(String[] args) {
        DeleteNodeByOccurrencesDLL obj = new DeleteNodeByOccurrencesDLL();

        // 10 <-> 20 <-> 10 <-> 30 <-> 10 <-> 40
        Node13 head = new Node13(10);
        head.next = new Node13(20);

        head.next.prev = head;
        head.next.next = new Node13(10);

        head.next.next.prev = head.next;
        head.next.next.next = new Node13(30);

        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node13(10);

        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node13(40);

        head.next.next.next.next.next.prev = head.next.next.next.next;

        System.out.println("Original List:");
        obj.display(head);
        head = obj.delete(head, 10);

        System.out.println("After deleting 10:");
        obj.display(head);
    }
}
