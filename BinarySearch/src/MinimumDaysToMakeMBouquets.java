public class MinimumDaysToMakeMBouquets {
    public static boolean possible(int ar[],int days,int m,int k){
        int n = ar.length;
        int count = 0;
        int nofb = 0;
        for(int i = 0;i<n;i++){
            if(ar[i]<=days){
                count++;
            }
            else{
                nofb+=(count/k);
                count = 0;
            }
        }
        nofb+=(count/k);
        return nofb>=m;
    }
    public static int mindays(int bloom[],int m,int k){
        int n = bloom.length;
        long val = (long) m*k;
        if(val>n) return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            min = Math.min(min,bloom[i]);
            max = Math.max(max,bloom[i]);
        }
        int low = min,high = max;
        while(low<=high){
            int mid = low+(high - low)/2;
            if(possible(bloom,mid,m,k)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int bloomsDays[] = {7,7,7,7,13,12,11,7};
        System.out.println("Minimum days bloom is:"+mindays(bloomsDays,2,3));
    }
}
