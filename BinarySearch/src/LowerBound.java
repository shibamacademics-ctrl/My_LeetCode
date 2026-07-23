public class LowerBound {
    public static int lowerbound(int ar[],int n){
        int ans = n;
        int low = 0,high = ar.length - 1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(ar[mid]>=n){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
       int ar[] = {3,4,5,6,8,8,9,10};
       System.out.println("Lower Bound index is: "+lowerbound(ar,7));
    }
}
