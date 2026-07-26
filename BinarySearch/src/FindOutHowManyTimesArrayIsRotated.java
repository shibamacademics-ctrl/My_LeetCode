public class FindOutHowManyTimesArrayIsRotated {
    public static int find(int ar[]){
        int low = 0,high = ar.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while(low<=high){
            int mid = low+(high - low)/2;
            if(ar[low]<=ar[high]){
                if(ar[low]<ans){
                    index = low;
                    ans = ar[low];
                }
                break;
            }
            if(ar[low]<=ar[mid]){
                if(ar[low]<ans){
                    index = low;
                    ans = ar[low];
                }
                low = mid + 1;
            }
            else{
                high = mid - 1;
                if(ar[mid] < ans){
                    index = mid;
                    ans = ar[mid];
                }
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int ar[] = {3,4,5,1,2};
        System.out.println("Array is rotated "+find(ar)+" times");
    }
}
