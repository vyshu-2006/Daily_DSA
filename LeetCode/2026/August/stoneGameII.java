class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1);
    }

    int solve(int i, int M) {

        if (i >= n)
            return 0;
        if (2 * M >= n - i)
            return suffix[i];

        if (dp[i][M] != -1)
            return dp[i][M];

        int maxStones = 0;

        for (int X = 1; X <= 2 * M; X++) {

            int opponent = solve(
                i + X,
                Math.max(M, X)
            );

            int current = suffix[i] - opponent;

            maxStones = Math.max(maxStones, current);
        }

        return dp[i][M] = maxStones;
    }
}
