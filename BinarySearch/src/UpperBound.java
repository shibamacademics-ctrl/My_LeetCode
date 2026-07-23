public class UpperBound {
    public static int upperbound(int ar[],int n){
        int ans = n;
        int low = 0,high = ar.length - 1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(ar[mid]>n){
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
        int ar[] = {3,4,5,6,7,8,8,9,10};
        System.out.println("Upper Bound index is: "+upperbound(ar,7));
    }
}
