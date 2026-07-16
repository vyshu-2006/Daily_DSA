class Solution {
    int[][] dp;

    public int countWays(int n, int sum) {
        dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int count = 0;

        // First digit cannot be 0
        for (int d = 1; d <= 9; d++) {
            if (d <= sum) {
                count += solve(1, sum - d, n);
            }
        }

        return count == 0 ? -1 : count;
    }

    private int solve(int pos, int remSum, int n) {
        if (pos == n) {
            return remSum == 0 ? 1 : 0;
        }

        if (dp[pos][remSum] != -1) {
            return dp[pos][remSum];
        }

        int ways = 0;

        for (int d = 0; d <= 9; d++) {
            if (d <= remSum) {
                ways += solve(pos + 1, remSum - d, n);
            }
        }

        return dp[pos][remSum] = ways;
    }
}
