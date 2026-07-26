public class FindPeakElement {
    public static int peak(int ar[]){
        int n = ar.length;
        if(n == 1) return 0;
        if(ar[0]>ar[1]) return 0;
        if(ar[n-1]>ar[n-2]) return n-1;
        int low = 1,high = n - 2;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(ar[mid - 1]<ar[mid] && ar[mid]>ar[mid+1]){
                return mid;
            }
            else if(ar[mid-1]<ar[mid]){
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int ar[] = {1,2,3,5,4,2};
        System.out.println("Peak Element index is :"+peak(ar));
    }
}
