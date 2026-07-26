public class SingleElementInSortedArray {
    public static int search(int ar[]){
        int n = ar.length;
        if(n == 1) return ar[0];
        if(ar[0]!=ar[1]) return ar[0];
        if(ar[n-1]!=ar[n-2]) return ar[n-1];
        int low = 1,high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(ar[mid]!=ar[mid+1] && ar[mid-1]!=ar[mid]){
                return ar[mid];
            } else if ((mid%2==1 && ar[mid-1] == ar[mid]) || (mid%2==0 && ar[mid]==ar[mid+1])) {
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ar[] = {1,1,2,2,3,3,4,5,5,6,6,7,7};
        System.out.println("Single Element is:"+search(ar));
    }
}
