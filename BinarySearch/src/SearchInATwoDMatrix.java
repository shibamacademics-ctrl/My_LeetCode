public class SearchInATwoDMatrix {
    private static int potentialRow(int mat[][],int target){
        int low = 0,high = mat.length - 1;
        while(low<=high){
            int mid = low+(high - low)/2;
            if(mat[mid][0]<=target && target<=mat[mid][mat[0].length - 1]){
                return mid;
            }
            else if (target < mat[mid][0]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    private static boolean binarysearch(int ar[],int target){
        int low = 0,high = ar.length - 1;
        while(low<=high){
            int mid = low+(high - low)/2;
            if(ar[mid] == target){
                return true;
            }
            else if(ar[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
    public static boolean searchMatrix(int[][] mat, int target) {
        int rowIndex = potentialRow(mat,target);
        if(rowIndex!=-1)
            return binarysearch(mat[rowIndex],target);
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;

        boolean found = searchMatrix(matrix, target);

        System.out.println("Target " + target + " found: " + found);
    }
}
