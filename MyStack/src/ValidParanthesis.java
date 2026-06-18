import java.util.*;
public class ValidParanthesis{
    public static boolean valid(String s){
        Stack<Character> st = new Stack<>();
        int n = s.length();
        if(s.charAt(0)!='(' && s.charAt(0)!='{' && s.charAt(0)!='[')
            return false;

        for(int i = 0;i<n;i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                if((st.peek() == '(' && s.charAt(i)==')') || (st.peek() == '{' && s.charAt(i)=='}') || (st.peek() == '[' && s.charAt(i)==']')){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println("Valid Parathesis or Not: "+valid(s));

    }
}