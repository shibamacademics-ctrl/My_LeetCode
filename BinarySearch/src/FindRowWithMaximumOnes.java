public class FindRowWithMaximumOnes {
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int maxCount = 0;
        int index = 0;

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }

        return new int[]{index, maxCount};
    }
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1},
                {1, 1, 1},
                {0, 0, 1},
                {1, 0, 1}
        };

        int[] result = rowAndMaximumOnes(mat);

        System.out.println("Row with maximum ones: " + result[0]);
        System.out.println("Maximum number of ones: " + result[1]);
    }
}
