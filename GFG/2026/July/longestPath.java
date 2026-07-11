class Solution {
    int ans = -1;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        int n = mat.length;
        int m = mat[0].length;

        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;

        boolean[][] vis = new boolean[n][m];
        dfs(mat, xs, ys, xd, yd, vis, 0);

        return ans;
    }

    private void dfs(int[][] mat, int x, int y, int xd, int yd,
                     boolean[][] vis, int dist) {

        if (x == xd && y == yd) {
            ans = Math.max(ans, dist);
            return;
        }

        vis[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (isValid(mat, nx, ny, vis)) {
                dfs(mat, nx, ny, xd, yd, vis, dist + 1);
            }
        }

        vis[x][y] = false; 
    }

    private boolean isValid(int[][] mat, int x, int y, boolean[][] vis) {
        int n = mat.length;
        int m = mat[0].length;

        return x >= 0 && x < n &&
               y >= 0 && y < m &&
               mat[x][y] == 1 &&
               !vis[x][y];
    }
}
