import java.util.HashMap;
import java.util.Map;

public class CountMaximumSubarraySumEqualK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0,count = 0;
        for(int i = 0;i<nums.length;i++){
            prefixSum +=nums[i];
            int remove = prefixSum - k;
            if (map.containsKey(remove)) {
                count += map.get(remove);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int ar[] = {1,2,3};
        System.out.println("Count Subarray sum which is equal to k: "+subarraySum(ar,3));
    }
}
