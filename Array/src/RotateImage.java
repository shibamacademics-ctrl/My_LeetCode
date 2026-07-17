import java.util.Arrays;

public class RotateImage {
    public static void reverse(int ar[]){
        int left = 0,right = ar.length - 1;
        while(left<right){
            int temp = ar[left];
            ar[left] = ar[right];
            ar[right] = temp;
            left++;
            right--;
        }
    }
    public static void rotate(int ar[][]){
        int n = ar.length;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                int temp = ar[i][j];
                ar[i][j] = ar[j][i];
                ar[j][i] = temp;
            }
        }
        for(int i = 0;i<n;i++){
            reverse(ar[i]);
        }
    }
    public static void printArray(int ar[][]){
        for(int i = 0;i<ar.length;i++){
            System.out.println(Arrays.toString(ar[i]));
        }
    }


    public static void main(String[] args) {
       int ar[][] = {{1,2,3},{4,5,6},{7,8,9}};
       System.out.println("Original Array is: ");
       printArray(ar);
       rotate(ar);
       System.out.println("After Rotating the Array is: ");
       printArray(ar);
    }
}
