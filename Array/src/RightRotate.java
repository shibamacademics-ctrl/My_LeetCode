import java.util.Arrays;

public class RightRotate {
    public static void rightrotate(int ar[],int k){
        int n = ar.length;
        int d = k%n;
        int temp[] = new int[d];
        for(int i = 0;i<d;i++){
            temp[i] = ar[n-d+i];
        }
        for(int i = n-d-1;i>=0;i--){
            ar[i+d] = ar[i];
        }
        for(int i = 0;i<d;i++){
            ar[i] = temp[i];
        }
        System.out.println("Array is: "+ Arrays.toString(ar));
    }
    public static void main(String[] args) {
        int ar[] = {1,2,3,4,5,6,7};
        rightrotate(ar,3);
    }
}
