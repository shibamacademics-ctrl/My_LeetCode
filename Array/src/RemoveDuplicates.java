import java.util.Arrays;

public class RemoveDuplicates {
    public static int remove(int ar[]){
        int i = 0;
        for(int j = 1;j<ar.length;j++){
            if(ar[i]!=ar[j]){
                ar[i+1] = ar[j];
                i++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
     int ar[] = {1,1,2,2,2,3};
     System.out.println("Array Length is: "+remove(ar));
    }
}
