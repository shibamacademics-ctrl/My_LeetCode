public class BookAllocation {
    public static boolean isPossible(int ar[],long mid,int k){
        int students = 1;
        long pages = 0;

        for (int x : ar) {


            if (x > mid)
                return false;

            if (pages + x <= mid) {
                pages += x;
            } else {
                students++;
                pages = x;
            }
        }

        return students <= k;
    }
    public static int findPages(int[] arr, int k) {

        if (k > arr.length) return -1;
        long sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
        }
        long low = 0,high = sum;
        long ans = -1;
        while(low<=high){
            long mid = low+(high - low)/2;
            if(isPossible(arr,mid,k)){
                ans  = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        int ar[] = {12 ,34 ,67 ,90};
        int k = 2;
        System.out.println("smallest possible maximum:"+findPages(ar,k));
    }
}
