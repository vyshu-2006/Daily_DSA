import java.util.*;

class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#')
            return 0;

        int[][] dist = new int[n][m];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        boolean[][] visited = new boolean[n][m];

        Deque<int[]> dq = new ArrayDeque<>();

        dist[r][c] = 0;
        dq.offerFirst(new int[]{r, c});

        int count = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!dq.isEmpty()) {

            int[] cur = dq.pollFirst();

            int x = cur[0];
            int y = cur[1];

            if (visited[x][y])
                continue;

            int upMoves = dist[x][y];
            int downMoves = upMoves + x - r;

            if (upMoves > u || downMoves > d)
                continue;

            visited[x][y] = true;
            count++;

            for (int k = 0; k < 4; k++) {

                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (mat[nx][ny] == '#')
                    continue;

                int cost = (nx < x) ? 1 : 0;

                if (dist[nx][ny] > upMoves + cost) {

                    dist[nx][ny] = upMoves + cost;

                    if (cost == 1)
                        dq.offerLast(new int[]{nx, ny});
                    else
                        dq.offerFirst(new int[]{nx, ny});
                }
            }
        }

        return count;
    }
}
