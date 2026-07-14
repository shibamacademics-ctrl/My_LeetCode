public class MaximumSumOfSubarray {
    public static int max(int ar[]){
        int n = ar.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;
        for(int i = 0;i<n;i++){
            sum+=ar[i];
            if(sum>max){
                max = sum;
                start = tempStart;
                end = i;
            }
            if(sum<0){
                sum = 0;
                tempStart = i + 1;
            }
        }
        System.out.print("Maximum subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println();
        return max;
    }
    public static void main(String[] args) {
        int ar[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum sum in subarray is: "+max(ar));
    }
}
