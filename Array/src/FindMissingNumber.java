public class FindMissingNumber {
    public static int MissingNumber(int ar[],int N){
        //Brute Force Approach
        /*int n = ar.length;
        for(int i  = 1;i<=N;i++){
            int flag = 0;
            for(int j = 0;j<n;j++){
                if(ar[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }
        }
        return -1;*/
        //Optimal
        /*
        int sum = (N*(N+1))/2;
        int sl = 0;
        int n = ar.length;
        for(int i = 0;i<n;i++){
            sl +=ar[i];
        }
        int ans = sum - sl;
        if(ans == 0){
            return 0;
        }
        return ans;*/

        int xor1 = 0;
        int xor2 = 0;
        for (int i = 1; i <= N; i++) {
            xor1 ^= i;
        }
        for (int i = 0; i < ar.length; i++) {
            xor2 ^= ar[i];
        }
        return xor1 ^ xor2;
    }
    public static void main(String[] args) {
        int ar[] = {1,2,4,5};
        int N = 5;
        System.out.println("Missing number is: "+MissingNumber(ar,N));
    }
}
