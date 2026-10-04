class Solution {
    public int findPerimeter(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int perimeter = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    perimeter += 4;

                    for (int k = 0; k < 4; k++) {
                        int r = i + dr[k];
                        int c = j + dc[k];

                        if (r >= 0 && r < n && c >= 0 && c < m
                                && mat[r][c] == 1) {
                            perimeter--;
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}
