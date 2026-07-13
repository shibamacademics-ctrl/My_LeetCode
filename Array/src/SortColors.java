import java.util.Arrays;

public class SortColors {
    public static void sort(int ar[]){
        int low = 0,mid = 0,high = ar.length - 1;
        while(mid<=high){
            if(ar[mid] == 0){
                int temp = ar[low];
                ar[low] = ar[mid];
                ar[mid] = temp;
                low++;
                mid++;
            }
            else if(ar[mid] == 1){
                mid++;
            }
            else{
                int temp = ar[high];
                ar[high] = ar[mid];
                ar[mid] = temp;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int ar[] = {1,2,0,0,2,0,1,1,2};
        System.out.println("Orginal Array is: "+ Arrays.toString(ar));
        sort(ar);
        System.out.println("Sorted Array is: "+ Arrays.toString(ar));
    }
}
