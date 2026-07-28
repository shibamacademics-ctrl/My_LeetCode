public class MinimumCapacityInDDays {
    public static int shipWithinDays(int[] weights, int D) {
        int n = weights.length;
        int minCap = 0,maxCap = 0;
        for(int wt : weights){
            minCap = Math.max(minCap,wt);
            maxCap+=wt;
        }
        while(minCap<=maxCap){
            int mid = minCap+(maxCap - minCap)/2;
            int days = 1;
            int sum = 0;
            for(int wt : weights){
                if(sum+wt>mid){
                    days++;
                    sum = 0;
                }
                sum+=wt;
            }
            if(days>D){
                minCap = mid + 1;
            }
            else{
                maxCap = mid - 1;
            }
        }
        return minCap;
    }
    public static void main(String[] args) {
        int wt[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Minimum Capacity is:"+shipWithinDays(wt,5));
    }

}
