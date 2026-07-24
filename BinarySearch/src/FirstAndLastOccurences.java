import java.util.Arrays;

public class FirstAndLastOccurences {
    public static int firstindex(int ar[],int x){
        int n = ar.length;
        int low = 0, high = n - 1;
        int first = -1;
        while(low<=high){
            int mid = low + (high - low) /2;
            if(ar[mid] == x){
                first = mid;
                high = mid - 1;
            }
            else if(ar[mid]<x){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return first;
    }
    public static int lastindex(int ar[],int x){
        int n = ar.length;
        int low = 0, high = n - 1;
        int last = -1;
        while(low<=high){
            int mid = low + (high - low) /2;
            if(ar[mid] == x){
                last = mid;
                low = mid + 1;
            }
            else if(ar[mid]<x){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return last;
    }
    public static int[] firstandlastoccur(int ar[],int x){
        int first = firstindex(ar,x);
        if(first == -1) return new int[]{-1,-1};
        int last = lastindex(ar,x);
        return new int[]{first,last};
    }
    public static void main(String[] args) {
        int ar[] = {1,1,2,2,8,8,8,8,10,12,13};
        int x = 8;
        System.out.println("First and Last Occurances is:"+ Arrays.toString(firstandlastoccur(ar,x)));
    }
}
