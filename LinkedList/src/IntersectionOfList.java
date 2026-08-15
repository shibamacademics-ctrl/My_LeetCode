class Node11{
    int val;
    Node11 next;
    Node11(int val){
        this.val = val;
        this.next = null;
    }
}
public class IntersectionOfList {
    public Node11 intersection(Node11 headA,Node11 headB){
        Node11 temp1 = headA,temp2 = headB;
        while(temp1!=temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
            if(temp1 == temp2)
                return temp1;
            if(temp1 == null) temp1 = headB;
            if(temp2 == null) temp2 = headA;
        }
        return temp1;
    }

    public static void main(String[] args) {
        IntersectionOfList obj = new IntersectionOfList();

        Node11 common1 = new Node11(7);
        Node11 common2 = new Node11(8);

        common1.next = common2;

        Node11 headA = new Node11(1);
        headA.next = new Node11(2);
        headA.next.next = new Node11(3);
        headA.next.next.next = common1;

        Node11 headB = new Node11(4);
        headB.next = new Node11(5);
        headB.next.next = common1;

        Node11 result = obj.intersection(headA, headB);

        if (result != null) {
            System.out.println("Intersection point: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }
}
