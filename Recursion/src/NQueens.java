import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            Arrays.fill(board[r], '.');
        }
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        backtrack(0, n, board, cols, diag1, diag2, result);

        return result;
    }

    private static void backtrack(int row, int n,
                           char[][] board,
                           boolean[] cols,
                           boolean[] diag1,
                           boolean[] diag2,
                           List<List<String>> result) {
        if (row == n) {
            List<String> solution = new ArrayList<>();

            for (char[] r : board) {
                solution.add(new String(r));
            }

            result.add(solution);
            return;
        }
        for (int col = 0; col < n; col++) {

            int d1 = row - col + n - 1;
            int d2 = row + col;
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            backtrack(row + 1, n, board,
                    cols, diag1, diag2, result);
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    public static void main(String[] args) {
        int n = 4;

        List<List<String>> result = solveNQueens(n);

        System.out.println("Number of solutions: " + result.size());

        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }

            System.out.println();
        }
    }
}