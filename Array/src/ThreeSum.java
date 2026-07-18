import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] ar){
        if(ar.length == 0 || ar.length<3){
            return new ArrayList<>();
        }
        int n = ar.length;
        Arrays.sort(ar);
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0;i<n-2;i++){
            int left = i + 1;
            int right = n-1;
            while(left<right){
               int sum = ar[i]+ar[left]+ar[right];
               if(sum == 0){
                   res.add(Arrays.asList(ar[i],ar[left],ar[right]));
                   left++;
                   right--;
               }
               else if(sum<0){
                   left++;
               }
               else{
                   right--;
               }
            }
        }
        return new ArrayList<>(res);
    }
    public static void main(String[] args) {
        int ar[] = {-1,0,1,2,-1,-4};
        System.out.println("3 Sum list is: "+threeSum(ar));
    }
}
