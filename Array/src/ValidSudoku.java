class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (row[num]) return false;
                    row[num] = true;
                }
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (col[num]) return false;
                    col[num] = true;
                }
            }
        }
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                boolean[] box = new boolean[9];

                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        if (board[i][j] != '.') {
                            int num = board[i][j] - '1';

                            if (box[num]) return false;
                            box[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        boolean result = obj.isValidSudoku(board);

        System.out.println("Valid Sudoku: " + result);
    }
}
