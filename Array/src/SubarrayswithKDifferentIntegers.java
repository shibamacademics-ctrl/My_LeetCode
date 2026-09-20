import java.util.HashMap;

public class SubarrayswithKDifferentIntegers {
    public static int subarraysWithKDistinct(int[] nums, int k){
        return length(nums,k) - length(nums,k-1);
    }
    private static int length(int nums[],int k){
        int l = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int r=0;r<nums.length;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            count+=r-l+1;
        }
        return count;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,1,3,4};
        int k = 3;
        System.out.println("Subarray eith distinct vlues:"+subarraysWithKDistinct(nums,k));
    }
}
