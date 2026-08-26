class MColoring {
    boolean graphColoring(int v, int[][] edges, int m) {
        boolean[][] graph = new boolean[v][v];
        for (int[] edge : edges) {
            int u = edge[0];
            int w = edge[1];

            graph[u][w] = true;
            graph[w][u] = true;
        }

        int[] color = new int[v];

        return solve(0, v, m, graph, color);
    }

    private boolean solve(int node, int v, int m,
                          boolean[][] graph, int[] color) {
        if (node == v) {
            return true;
        }
        for (int c = 1; c <= m; c++) {

            if (isSafe(node, c, v, graph, color)) {
                color[node] = c;

                if (solve(node + 1, v, m, graph, color)) {
                    return true;
                }
                color[node] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int node, int c, int v,
                           boolean[][] graph, int[] color) {

        for (int i = 0; i < v; i++) {
            if (graph[node][i] && color[i] == c) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MColoring obj = new MColoring();

        int v = 4;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {1, 3},
                {2, 3}
        };

        int m = 3;

        boolean result = obj.graphColoring(v, edges, m);

        System.out.println(result);
    }
}