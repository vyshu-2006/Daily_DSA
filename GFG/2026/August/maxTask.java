class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

        int[] dp = new int[n];

        dp[0] = Math.max(h[0], l[0]);

        if (n == 1)
            return dp[0];

        dp[1] = Math.max(
            dp[0] + l[1],
            h[1]
        );

        for (int i = 2; i < n; i++) {
            int low = dp[i - 1] + l[i];
            int high = dp[i - 2] + h[i];

            dp[i] = Math.max(low, high);
        }

        return dp[n - 1];
    }
}
