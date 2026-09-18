public class MaximumPointsYouCanObtainfromCards {
    public static int maxScore(int nums[],int k){
        int lsum = 0,rsum = 0;
        int maxSum = 0;
        for(int i = 0;i<k;i++){
            lsum+=nums[i];
            maxSum = lsum;
        }
        int ridx = nums.length - 1;
        for(int i = k - 1;i>=0;i--){
            lsum-=nums[i];
            rsum+=nums[ridx];
            maxSum=Math.max(maxSum,(lsum+rsum));
            ridx--;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int ar[] = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println("Max Score is:"+maxScore(ar,k));
    }
}
