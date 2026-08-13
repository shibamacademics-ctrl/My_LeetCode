class Node8{
    int val;
    Node8 next;
    Node8(int val){
        this.val = val;
        this.next = null;
    }
}
public class RemoveNthNodeFromTheEnd {
    Node8 head;
    public void insertEnd(int val) {
        Node8 newNode = new Node8(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node8 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void display() {

        Node8 current = head;

        while (current != null) {

            System.out.print(current.val + " -> ");
            current = current.next;
        }
    }
    public void removeNthEnd(Node8 head,int n){
        if(head==null || head.next==null){
            return;
        }
        Node8 fast = head;
        for(int i = 0;i<n;i++){
            fast = fast.next;
        }
        if(fast == null){
            head =  head.next;
            return;
        }
        Node8 slow = head;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
    }
    public static void main(String[] args) {
        RemoveNthNodeFromTheEnd list = new RemoveNthNodeFromTheEnd();

        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);

        System.out.println("Before:");
        list.display();

        list.removeNthEnd(list.head,2);

        System.out.println("After:");
        list.display();
    }
}
