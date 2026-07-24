public class CountOccurancesInSortedArray {
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
    public static int count(int ar[],int x){
        int first = firstindex(ar,x);
        if(first == -1) return 0;
        int last = lastindex(ar,x);
        return last - first + 1;
    }
    public static void main(String[] args) {
        int ar[] = {1,2,2,2,3,4,5};
        int x = 2;
        System.out.println("Target Occurance is:"+count(ar,x));
    }
}
