import java.util.Stack;

public class RemoveOutermostParanthesis {
    public static String remove(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (!st.isEmpty()) {
                    ans.append(ch);
                }
                st.push(ch);
            } else {
                st.pop();
                if (!st.isEmpty()) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String s = "((()))";
        System.out.println("After removing:"+remove(s));
    }
}
