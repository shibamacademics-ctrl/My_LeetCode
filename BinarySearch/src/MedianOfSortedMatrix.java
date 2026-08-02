public class MedianOfSortedMatrix {
        static int upperBound(int[] row, int target) {
            int low = 0, high = row.length;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (row[mid] <= target)
                    low = mid + 1;
                else
                    high = mid;
            }

            return low;
        }

        static int median(int mat[][]) {
            int n = mat.length;
            int m = mat[0].length;

            int low = Integer.MAX_VALUE;
            int high = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                low = Math.min(low, mat[i][0]);
                high = Math.max(high, mat[i][m - 1]);
            }

            int required = (n * m) / 2;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                int count = 0;
                for (int i = 0; i < n; i++) {
                    count += upperBound(mat[i], mid);
                }

                if (count <= required)
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            return low;
        }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };

        System.out.println("Median = " + median(matrix));
    }
}

