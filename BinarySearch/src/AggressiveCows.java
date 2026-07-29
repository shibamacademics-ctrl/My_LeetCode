import java.util.Arrays;

public class AggressiveCows {
    public static boolean isPossible(int ar[],int mid,int k){
        int cows = 1,lastStall = ar[0];
        for(int i = 1;i<ar.length;i++){
            if(ar[i] - lastStall>=mid){
                cows++;
                lastStall = ar[i];
            }
            if(cows == k){
                return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int low = 1,high = arr[n-1] - arr[0];
        int ans = -1;
        while(low<=high){
            int mid = low+(high - low)/2;
            if(isPossible(arr,mid,k)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        int ar[] = {1 ,2 ,4, 8 ,9};
        int k = 3;
        System.out.println("Minimum Distance is:"+aggressiveCows(ar,k));
    }
}


