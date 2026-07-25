public class SearchInRotatedTwo {
    public static boolean search(int[] nums, int k) {
        int n = nums.length;
        int low = 0,high = n - 1;
        while(low<=high){
            int mid = low+(high - low)/2;
            if(nums[mid] == k) return true;
            if(nums[low] == nums[mid] && nums[high] == nums[mid]){
                low++;
                high--;
                continue;
            }
            if(nums[low]<=nums[mid]){
                if(nums[low]<=k && k<=nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(nums[mid]<=k && k<=nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int ar[] = {7,8,1,2,3,3,3,4,5,6};
        int target = 3;
        System.out.println("Element exist?->"+search(ar,target));
    }
}
