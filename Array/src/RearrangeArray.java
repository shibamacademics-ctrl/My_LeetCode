import java.util.Arrays;

public class RearrangeArray {
    public static int[] rearrange(int ar[]){
        int n = ar.length;
        int ans[] = new int[n];
        int posIndex = 0,negIndex = 1;
        for(int i = 0;i<n;i++){
            if(ar[i]<0){
                ans[negIndex] = ar[i];
                negIndex+=2;
            }
            else{
                ans[posIndex] = ar[i];
                posIndex+=2;
            }
        }
        System.out.println("Original Array is: "+ Arrays.toString(ar));
        return ans;
    }

    public static void main(String[] args) {
        int ar[] = {3,1,-2,-5,2,-4};
        System.out.println("Rearrange Array is: "+Arrays.toString(rearrange(ar)));
    }
}
