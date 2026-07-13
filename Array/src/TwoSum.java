import java.util.*;
public class TwoSum {
    public static int[] sum(int ar[],int target){
        int n = ar.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int need = target - ar[i];
            if(map.containsKey(need)){
                return new int[]{map.get(need),i};
            }
            map.put(ar[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int ar[] = {2,3,4,6,7};
        int target = 7;
        System.out.println("Sum exist in arrays index of: "+Arrays.toString(sum(ar,target)));
    }
}
