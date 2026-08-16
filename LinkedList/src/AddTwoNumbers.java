class Node12{
    int val;
    Node12 next;
    Node12(int val){
        this.val = val;
        this.next = null;
    }
}
public class AddTwoNumbers {
    Node12 head;
    public Node12 add(Node12 l1,Node12 l2){
        Node12 dummy = new Node12(0);
        Node12 temp = dummy;
        int carry = 0;
        while(l1!=null || l2!=null || carry == 1){
            int sum = 0;
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            sum+=carry;
            carry = sum /10;

            Node12 node = new Node12(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Node12 l1 = new Node12(2);
        l1.next = new Node12(4);
        l1.next.next = new Node12(3);
        Node12 l2 = new Node12(5);
        l2.next = new Node12(6);
        l2.next.next = new Node12(4);

        AddTwoNumbers obj = new AddTwoNumbers();

        Node12 result = obj.add(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
