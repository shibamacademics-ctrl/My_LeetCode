public class FindSmallestDivisorInGivenThreshold {
    public static int smallest(int ar[],int threshold){
        int n = ar.length;
        int max = 0;
        for(int i = 0;i<n;i++){
            max = Math.max(max,ar[i]);
        }
        int low = 1,high = max;
        while(low<=high){
            int mid = low+(high - low)/2;
            int sum = 0;
            for(int i = 0;i<n;i++){
                sum+=(ar[i]+mid -1)/mid;
            }
            if(sum<=threshold){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int ar[] = {1,2,5,9};
        int threshold = 6;
        System.out.println("Smallest Divisor is:"+smallest(ar,threshold));
    }
}
