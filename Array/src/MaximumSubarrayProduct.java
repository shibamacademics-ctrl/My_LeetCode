public class MaximumSubarrayProduct {
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        System.out.println(maxProduct(nums1)); // 6

        int[] nums2 = {-2, 0, -1};
        System.out.println(maxProduct(nums2)); // 0

        int[] nums3 = {-2, 3, -4};
        System.out.println(maxProduct(nums3)); // 24

        int[] nums4 = {-2};
        System.out.println(maxProduct(nums4)); // -2

        int[] nums5 = {-1, -2, -3};
        System.out.println(maxProduct(nums5)); // 6
    }
}

