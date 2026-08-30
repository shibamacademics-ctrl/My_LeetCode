import java.util.Arrays;
import java.util.Stack;

class NextGreaterElementTwo {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {

            int current = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < current) {
                ans[stack.pop()] = current;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        NextGreaterElementTwo obj = new NextGreaterElementTwo();
        int[] result = obj.nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));
    }
}