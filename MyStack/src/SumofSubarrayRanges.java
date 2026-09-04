import java.util.Stack;

class Solution {
    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                    (i == n || nums[stack.peek()] < nums[i])) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                ans += (long) nums[mid]
                        * (mid - left)
                        * (right - mid);
            }

            if (i < n) {
                stack.push(i);
            }
        }
        stack.clear();
        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                    (i == n || nums[stack.peek()] > nums[i])) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                ans -= (long) nums[mid]
                        * (mid - left)
                        * (right - mid);
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {4,-2,-3,4,1};
        System.out.println("Sum of all subarray ranges is:"+subArrayRanges(nums));
    }
}

