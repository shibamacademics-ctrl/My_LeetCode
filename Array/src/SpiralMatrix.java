import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {

            // Left -> Right
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;

            // Top -> Bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // Right -> Left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // Bottom -> Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
    public static void printArray(int ar[][]){
        for(int i = 0;i<ar.length;i++){
            System.out.println(Arrays.toString(ar[i]));
        }
    }

    public static void main(String[] args) {
        int ar[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println("Original Matrix:");
        printArray(ar);

        SpiralMatrix obj = new SpiralMatrix();
        List<Integer> ans = obj.spiralOrder(ar);

        System.out.println("Spiral Order:");
        System.out.println(ans);
    }
}