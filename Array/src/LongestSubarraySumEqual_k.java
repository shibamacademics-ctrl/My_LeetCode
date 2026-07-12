public class LongestSubarraySumEqual_k {
    //For Postive and 0 element
    public static int max(int ar[],int k){
        int left = 0,right = 0;
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
        return max;
    }
    public static void main(String[] args) {
        int ar[] = {1,2,3,1,1,1,3,1,2};
        int k = 3;
        System.out.println("Longest Subarray is: "+max(ar,k));
    }
}
