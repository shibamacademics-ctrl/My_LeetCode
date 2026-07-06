public class LargestElement {
    public static int Largest(int ar[]){
        int n = ar.length;
        int max = ar[0];
        for(int i = 1;i<n;i++){
            if(ar[i]>max){
                max = ar[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int ar [] = {1,4,3,2,5};
        System.out.println("Largest element is: "+Largest(ar));
    }
}
