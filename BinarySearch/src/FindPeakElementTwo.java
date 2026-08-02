import java.util.Arrays;

public class FindPeakElementTwo {
    public static int maxIndex(int ar[][],int col){
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0;i<ar.length;i++){
            if(ar[i][col]>max){
                max = ar[i][col];
                index = i;
            }
        }
        return index;
    }
    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0,high = m - 1;
        while(low<=high){
            int mid = low+(high - low)/2;
            int maxRowIndex = maxIndex(mat,mid);
            int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRowIndex][mid + 1] : -1;
            if(mat[maxRowIndex][mid]>left && mat[maxRowIndex][mid]>right){
                return new int[]{maxRowIndex,mid};
            }
            else if(mat[maxRowIndex][mid]<left){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[][] mat = {
                {41, 8, 2, 48, 18},
                {16, 15, 9, 7, 44},
                {48, 35, 6, 38, 28},
                {3, 2, 14, 15, 33},
                {39, 36, 13, 46, 42}
        };

        int[] peak = findPeakGrid(mat);

        System.out.println("Peak Position: " + Arrays.toString(peak));
        System.out.println("Peak Value: " + mat[peak[0]][peak[1]]);
    }
}
