import java.util.Arrays;

public class LeftRotate {
    public static void leftrotate(int ar[],int k){
        int n = ar.length;
        int d = k%n;
        int temp[] = new int[d];
        for(int i = 0;i<d;i++){
            temp[i] = ar[i];
        }
        for(int i = d;i<n;i++){
            ar[i-d] = ar[i];
        }
        for(int i = n-d;i<n;i++){
            ar[i] = temp[i-(n-d)];
        }
        System.out.println(Arrays.toString(ar));
    }
    public static void main(String[] args) {
        int ar[] = {1,2,3,4,5,6,7};
        leftrotate(ar,3);
    }
}
