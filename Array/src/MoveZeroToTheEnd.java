import java.util.Arrays;

public class MoveZeroToTheEnd {
    public static void MoveZero(int ar[]){
        int n = ar.length;
        int j = -1;
        for(int i = 0;i<n;i++){
            if(ar[i]==0){
                j = i;
                break;
            }
        }
        if(j == -1) return;
        for(int i = j+1;i<n;i++){
            if(ar[i]!=0){
                int temp = ar[j];
                ar[j] = ar[i];
                ar[i] = temp;
                j++;
            }
        }
        System.out.println("Array is: "+ Arrays.toString(ar));
    }

    public static void main(String[] args) {
        int ar[] = {1,2,2,3,0,3,0,2,4,0};
        MoveZero(ar);

    }
}
