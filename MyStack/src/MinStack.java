import java.util.Stack;

class MinstackImpl {

    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinstackImpl() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);

        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        }
    }

    public void pop() {
        if (st.peek().equals(minSt.peek())) {
            minSt.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}
public class MinStack {
    public static void main(String[] args) {
        MinstackImpl ms = new MinstackImpl();

        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        System.out.println("Top: " + ms.top());
        System.out.println("Min: " + ms.getMin());

        ms.pop();

        System.out.println("Top: " + ms.top());
        System.out.println("Min: " + ms.getMin());

        ms.pop();

        System.out.println("Top: " + ms.top());
        System.out.println("Min: " + ms.getMin());
    }
}

