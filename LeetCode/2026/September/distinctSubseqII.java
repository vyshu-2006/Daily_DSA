class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1000000007;

        int n = s.length();

        long[] dp = new long[n + 1];
        int[] last = new int[26];
        java.util.Arrays.fill(last, -1);

        dp[0] = 1;

        for (int i = 0; i < n; i++) {

            dp[i + 1] = (2 * dp[i]) % MOD;
            if (last[s.charAt(i) - 'a'] != -1) {
                int prev = last[s.charAt(i) - 'a'];

                dp[i + 1] = (dp[i + 1] - dp[prev] + MOD) % MOD;
            }
            last[s.charAt(i) - 'a'] = i;
        }
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}
