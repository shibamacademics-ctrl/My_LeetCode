import java.util.*;
public class LongestSubarraySumEqual_k {
    //For Postive and 0 element
    public static int max(int ar[],int k){
        /*int left = 0,right = 0;
        int sum = ar[0];
        int n = ar.length;
        int max = 0;
        while(right<n){
            while(left<=right && sum>k){
                sum-=ar[left];
                left++;
            }
            if(sum == k){
                max = Math.max(max,right-left+1);
            }
            right++;
            if(right<n) sum+=ar[right];
        }
        return max;*/
    //For Psotive,Negetive,and 0
        Map<Integer,Integer> sumseenMap = new HashMap<>();
        sumseenMap.put(0,-1);
        int Max = 0;
        int prefixSum = 0;
        int n = ar.length;
        for(int i = 0;i<n;i++){
            prefixSum+=ar[i];
            if(sumseenMap.containsKey(prefixSum - k)){
                Max = Math.max(Max,i - sumseenMap.get(prefixSum - k));
            }
            if(!sumseenMap.containsKey(prefixSum)){
                sumseenMap.put(prefixSum,i);
            }
        }
        return Max;
    }
    public static void main(String[] args) {
        int ar[] = {5,2,2,1,1,1,1,-9};
        int k = 4;
        System.out.println("Longest Subarray is: "+max(ar,k));
    }
}
