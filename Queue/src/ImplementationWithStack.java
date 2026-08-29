import java.util.Stack;

class ImplementationWithStack {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public ImplementationWithStack() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        moveElements();

        return outStack.pop();
    }

    public int peek() {
        moveElements();

        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
    private void moveElements() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        ImplementationWithStack q = new ImplementationWithStack();
        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println("Front: " + q.peek());
        System.out.println("Removed: " + q.pop());

        System.out.println("Front: " + q.peek());
        System.out.println("Removed: " + q.pop());
        q.push(40);

        System.out.println("Front: " + q.peek());
        System.out.println("Removed: " + q.pop());

        System.out.println("Removed: " + q.pop());
        System.out.println("Is queue empty? " + q.empty());
    }
}