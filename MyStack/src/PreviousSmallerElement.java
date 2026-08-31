import java.util.*;
public class PreviousSmallerElement {
    public static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Remove elements that are not smaller
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // If stack is empty, no smaller element exists
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Add current element
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};

        int[] result = nextSmallerElement(arr);

        System.out.println(Arrays.toString(result));
    }
}