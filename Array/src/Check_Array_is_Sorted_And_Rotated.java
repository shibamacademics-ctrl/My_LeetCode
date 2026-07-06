public class Check_Array_is_Sorted_And_Rotated {
    public static boolean check(int ar[]){
        int n = ar.length;
        int count = 0;
        for(int i = 0;i<n-1;i++){
            if(ar[i]>ar[i+1]){
                count++;
            }
        }
        if(count == 1 && ar[0]>ar[n-1]){
            return true;
        }
        if(count == 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int ar[] = {3,4,5,1,2};
        System.out.println("The array is Sorted and Rotated: "+check(ar));
    }
}
