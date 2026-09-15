public class CountNumberofNiceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        int oddCount = 0;
        int ans = 0;
        int[] freq = new int[nums.length + 1];
        freq[0] = 1;

        for (int num : nums) {
            oddCount += num % 2;

            if (oddCount >= k) {
                ans += freq[oddCount - k];
            }

            freq[oddCount]++;
        }

        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println("Subarray Length is:"+numberOfSubarrays(nums,k));
    }
}
