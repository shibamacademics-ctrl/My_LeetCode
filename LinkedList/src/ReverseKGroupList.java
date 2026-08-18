class Node17{
    int val;
    Node17 next;
    Node17(int val){
        this.val = val;
        this.next = null;
    }
}
public class ReverseKGroupList {
    public Node17 reverse(Node17 head,int k){
        Node17 temp = head;
        int count = 0;
        while(count<k){
            if(temp == null){
                return head;
            }
            temp = temp.next;
            count++;
        }
        Node17 prevNode = reverse(temp,k);
        temp = head;
        count = 0;
        while(count<k){
            Node17 after = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = after;
            count++;
        }
        return prevNode;
    }
    public static void main(String[] args) {
        ReverseKGroupList obj = new ReverseKGroupList();

        // Create linked list:
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        Node17 head = new Node17(1);
        head.next = new Node17(2);
        head.next.next = new Node17(3);
        head.next.next.next = new Node17(4);
        head.next.next.next.next = new Node17(5);
        head.next.next.next.next.next = new Node17(6);
        head.next.next.next.next.next.next = new Node17(7);

        int k = 3;

        // Reverse in groups of k
        head = obj.reverse(head, k);

        // Print the result
        Node17 temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
