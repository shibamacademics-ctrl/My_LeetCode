import java.util.Stack;

class RemoveKDigits {
    public static String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            char curr = num.charAt(i);
            while (!st.isEmpty() && k > 0 && st.peek() > curr) {
                st.pop();
                k--;
            }

            st.push(curr);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        String result = sb.substring(i);

        return result.isEmpty() ? "0" : result;
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println("After removing digits are:"+removeKdigits(num,k));
    }
}
