class  ListNode{
int val;
ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class SortLL {
    ListNode head;
    public ListNode findmiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return dummyNode.next;
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findmiddle(head);

        ListNode right = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        right = sortList(right);

        return mergeTwoLists(left, right);
    }
    public void insertEnd(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void display() {

        ListNode current = head;

        while (current != null) {

            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        SortLL list = new SortLL();

        list.insertEnd(4);
        list.insertEnd(2);
        list.insertEnd(1);
        list.insertEnd(3);
        list.insertEnd(7);
        list.insertEnd(5);

        System.out.println("Before sorting:");
        list.display();

        list.head = list.sortList(list.head);

        System.out.println("After sorting:");
        list.display();
    }
}
