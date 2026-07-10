public class MaximumConsecutiveNumbers {
    public static int max(int ar[]){
        int n = ar.length;
        int max = 0;
        int count = 0;
        for(int i = 0;i<n;i++){
            if(ar[i]!=0){
                count++;
                max = Math.max(max,count);
            }
            else{
                count = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int ar[] = {1,1,0,1,1,1,0,1,1};
        System.out.println("Maximum Consecutive Numbers is: "+max(ar));
    }
}
