public class SingleNumber {
    public static int XOR(int ar[]){
        int xor = 0;
        for(int i = 0;i<ar.length;i++){
            xor = xor ^ ar[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int ar[] = {1,1,2,3,3,4,4};
        System.out.println("Single Number in the array is: "+XOR(ar));
    }
}
