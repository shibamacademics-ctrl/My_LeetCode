import java.util.LinkedList;
import java.util.Queue;

class ImplementationWihQueue {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public ImplementationWihQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementationWihQueue stack = new ImplementationWihQueue();
        System.out.println("Is stack empty? " + stack.empty());
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.top());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Top after pop: " + stack.top());
        stack.push(40);

        System.out.println("Top after push(40): " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is stack empty? " + stack.empty());
    }
}