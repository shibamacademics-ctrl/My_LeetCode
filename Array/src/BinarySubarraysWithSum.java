public class BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    private static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int l = 0;
        int count = 0;
        int sum = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            count += r - l + 1;
        }

        return count;
    }
    public static void main(String[] args) {
        int nums[] = {1,0,1,0,1};
        int goal = 2;
        System.out.println("Length of the subarray:"+numSubarraysWithSum(nums,goal));
    }
}
