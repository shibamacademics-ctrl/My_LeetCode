import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0,count2 = 0;
        int el1 = Integer.MIN_VALUE,el2 = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(count1 == 0 && nums[i]!=el2){
                el1 = nums[i];
                count1++;
            }
            else if(count2 == 0 && nums[i]!=el1){
                el2 = nums[i];
                count2++;
            }
            else if(nums[i] == el1){
                count1++;
            }
            else if(nums[i] == el2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        int count3 = 0;
        int count4 = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == el1){
                count3++;
            }
            if(nums[i] == el2){
                count4++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(count3>n/3){
            ans.add(el1);
        }
        if (count4>n/3){
            ans.add(el2);
        }
        return ans;
    }
    public static void main(String[] args) {
        int ar[] = {1,1,1,3,3,2,2,2};
        System.out.println("Majority Element list is: "+majorityElement(ar));
    }
}
