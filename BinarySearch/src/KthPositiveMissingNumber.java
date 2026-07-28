public class KthPositiveMissingNumber {
    public static int findKthPositive(int[] arr, int k) {
        int low = 0,high = arr.length - 1;
        while(low<=high){
            int mid = (low+high)/2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return k+high+1;
    }
    public static void main(String[] args) {
        int ar[] = {2,3,4,7,11};
        System.out.println("Kth Missing Number is:"+findKthPositive(ar,5));
    }
}
