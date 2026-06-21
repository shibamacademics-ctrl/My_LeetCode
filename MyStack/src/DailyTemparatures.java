import java.util.*;
public class DailyTemparatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {

                int prevIndex = st.pop();
                answer[prevIndex] = i - prevIndex;
            }

            st.push(i);
        }

        return answer;
    }
    public static void main(String args[]){
        int temp[] = {73,74,75,71,69,72,76,73};
        System.out.println("Daily Temparatures list is: "+Arrays.toString(dailyTemperatures(temp)));

    }

}
