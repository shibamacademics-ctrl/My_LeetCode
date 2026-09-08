import java.util.Stack;

class OnlineStockSpan {
    Stack<int[]> st = new Stack<>();
    int ind = -1;

    OnlineStockSpan() {
        st.clear();
    }

    public int next(int price) {
        ind++;

        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }

        int ans = ind - (st.isEmpty() ? -1 : st.peek()[1]);

        st.push(new int[]{price, ind});

        return ans;
    }

    public static void main(String[] args) {
        OnlineStockSpan obj = new OnlineStockSpan();

        System.out.println(obj.next(100)); // 1
        System.out.println(obj.next(80));  // 1
        System.out.println(obj.next(60));  // 1
        System.out.println(obj.next(70));  // 2
        System.out.println(obj.next(60));  // 1
        System.out.println(obj.next(75));  // 4
        System.out.println(obj.next(85));  // 6
    }
}