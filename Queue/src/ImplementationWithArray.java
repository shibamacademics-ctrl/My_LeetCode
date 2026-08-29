

class ImplementationWithArray {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    ImplementationWithArray(int size) {
        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = -1;
    }

    void enqueue(int value) {
        if (rear == capacity - 1) {
            System.out.println("Queue Overflow");
            return;
        }

        arr[++rear] = value;
        System.out.println(value + " inserted into queue");
    }
    int dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow");
            return -1;
        }

        return arr[front++];
    }

    int peek() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return -1;
        }

        return arr[front];
    }
    boolean isEmpty() {
        return front > rear;
    }
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ImplementationWithArray q = new ImplementationWithArray(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Front element: " + q.peek());

        System.out.println("Deleted element: " + q.dequeue());

        q.display();
    }
}