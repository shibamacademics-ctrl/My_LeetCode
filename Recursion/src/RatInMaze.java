import java.util.ArrayList;

class RatInMaze {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        int n = maze.length;

        if (n == 0 || maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }

        boolean[][] visited = new boolean[n][n];

        // D, L, R, U
        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        dfs(0, 0, maze, visited, "", ans, dr, dc, dir);

        return ans;
    }

    private void dfs(int r, int c, int[][] maze, boolean[][] visited,
                     String path, ArrayList<String> ans,
                     int[] dr, int[] dc, char[] dir) {

        int n = maze.length;
        if (r == n - 1 && c == n - 1) {
            ans.add(path);
            return;
        }

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n
                    && maze[nr][nc] == 1
                    && !visited[nr][nc]) {

                dfs(nr, nc, maze, visited,
                        path + dir[i], ans, dr, dc, dir);
            }
        }
        visited[r][c] = false;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        RatInMaze obj = new RatInMaze();

        ArrayList<String> result = obj.ratInMaze(maze);

        System.out.println(result);
    }
}