public class SecondLargestElement {
    public static int secondLargest(int ar[]){
        int n = ar.length;
        int max = ar[0],prev = ar[0];
        for(int i = 1;i<n;i++){
            if(ar[i]>max){
                prev = max;
                max = ar[i];
            }
        }
        return prev;

    }

    public static void main(String[] args) {
        int ar[] = {2,1,2,5};
        System.out.println("Second Largest Element is: "+secondLargest(ar));
    }
}
