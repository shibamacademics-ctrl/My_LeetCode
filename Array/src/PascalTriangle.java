import java.util.*;

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // First and last element of each row is 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of two elements from previous row
                    int value = result.get(i - 1).get(j - 1)
                            + result.get(i - 1).get(j);
                    row.add(value);
                }
            }

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int numRows = sc.nextInt();

        List<List<Integer>> triangle = generate(numRows);

        System.out.println("\nPascal's Triangle:");
        for (List<Integer> row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}