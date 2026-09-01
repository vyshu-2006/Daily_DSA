class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = -1, sc = -1;
        int[][] id = new int[m][n];

        for (int i = 0; i < m; i++)
            java.util.Arrays.fill(id[i], -1);

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    id[i][j] = count++;
                }
            }
        }

        int allMask = (1 << count) - 1;

        if (count == 0)
            return 0;

        int[][][] best = new int[m][n][1 << count];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                java.util.Arrays.fill(best[i][j], -1);

        java.util.Queue<int[]> q = new java.util.ArrayDeque<>();

        q.offer(new int[]{sr, sc, energy, 0, 0});
        best[sr][sc][0] = energy;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int e = cur[2];
            int mask = cur[3];
            int moves = cur[4];

            if (mask == allMask)
                return moves;

            if (e == 0)
                continue;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                char cell = classroom[nr].charAt(nc);

                if (cell == 'X')
                    continue;

                int newEnergy = e - 1;
                int newMask = mask;

                if (cell == 'L') {
                    newMask |= (1 << id[nr][nc]);
                }

                if (cell == 'R') {
                    newEnergy = energy;
                }

                if (best[nr][nc][newMask] >= newEnergy)
                    continue;

                best[nr][nc][newMask] = newEnergy;

                q.offer(new int[]{
                    nr, nc, newEnergy, newMask, moves + 1
                });
            }
        }

        return -1;
    }
}
