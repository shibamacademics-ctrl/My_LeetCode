import java.util.*;
public class EvaluateReversePolishNotations {
    public static int Notations(String tokens[]){
        int a,b;
        Stack<Integer> st = new Stack<>();
        for(String token : tokens){
            switch(token){
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "-":
                    b = st.pop();
                    a = st.pop();
                    st.push(a-b);
                    break;
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                case "/":
                    b = st.pop();
                    a = st.pop();
                    st.push(a/b);
                default:
                    st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }

    public static void main(String main[]){
        String tokens [] = {"2","1","+","3","*"};
        System.out.println("Valid Notation is : "+Notations(tokens));

    }

}
