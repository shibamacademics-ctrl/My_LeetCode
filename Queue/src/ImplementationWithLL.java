// Node class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Queue class
class ImplementationWithLL {
    Node front,rear;
    int size;
    public ImplementationWithLL() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int x) {
        Node newNode = new Node(x);
        if(front == null){
            front = newNode;
            rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void dequeue() {
        if(isEmpty()){
            return;
        }
        if(front!=null){
            front = front.next;
        }
        size--;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return front.data;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ImplementationWithLL q = new ImplementationWithLL();
        System.out.println("Is queue empty? " + q.isEmpty());
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Size: " + q.size());
        System.out.println("Front: " + q.getFront());
        q.dequeue();

        System.out.println("After dequeue:");
        System.out.println("Front: " + q.getFront());
        System.out.println("Size: " + q.size());
        q.enqueue(40);

        System.out.println("After enqueue(40):");
        System.out.println("Front: " + q.getFront());
        System.out.println("Size: " + q.size());
        q.dequeue();
        q.dequeue();
        q.dequeue();

        System.out.println("After removing all elements:");
        System.out.println("Is queue empty? " + q.isEmpty());
        System.out.println("Front: " + q.getFront());
    }
}
