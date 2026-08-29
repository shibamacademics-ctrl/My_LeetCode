class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

class ImplementationWithLL {
    Node top;
    int size;
    public ImplementationWithLL() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        top = top.next;
        size--;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return top.data;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ImplementationWithLL stack = new ImplementationWithLL();
        System.out.println("Is stack empty? " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Size: " + stack.size());
        System.out.println("Top: " + stack.peek());
        stack.pop();

        System.out.println("After pop:");
        System.out.println("Top: " + stack.peek());
        System.out.println("Size: " + stack.size());
        stack.push(40);

        System.out.println("After push(40):");
        System.out.println("Top: " + stack.peek());
        System.out.println("Size: " + stack.size());
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("After removing all elements:");
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Top: " + stack.peek());
    }
}
