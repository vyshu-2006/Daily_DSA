class Solution {
    public int longestSubseq(int[] arr) {

        int[] dp = new int[1000002];
        int ans = 0;

        for (int x : arr) {

            int current = 1 + Math.max(dp[x - 1], dp[x + 1]);

            dp[x] = Math.max(dp[x], current);

            ans = Math.max(ans, dp[x]);
        }

        return ans;
    }
}
