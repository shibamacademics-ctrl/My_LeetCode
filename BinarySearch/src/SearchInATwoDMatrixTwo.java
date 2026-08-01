public class SearchInATwoDMatrixTwo {
    public static boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int row = 0, col = m - 1;
        while(row < n && col >= 0){
            if(mat[row][col] == target) return true;
            else if(mat[row][col]<target) row++;
            else col--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int[] targets = {5, 20, 30, 1, 25};

        for (int target : targets) {
            System.out.println("Target " + target + " found: " + searchMatrix(matrix, target));
        }
    }
}
