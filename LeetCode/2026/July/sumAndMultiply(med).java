class Solution {
    static final int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        int[] prefixSum = new int[n + 1];
        int[] prefixCnt = new int[n + 1];

        StringBuilder nz = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            prefixSum[i + 1] = prefixSum[i];
            prefixCnt[i + 1] = prefixCnt[i];

            if (d != 0) {
                prefixSum[i + 1] += d;
                prefixCnt[i + 1]++;
                nz.append(s.charAt(i));
            }
        }

        int m = nz.length();

        long[] pow10 = new long[m + 1];
        long[] hash = new long[m + 1];

        pow10[0] = 1;

        for (int i = 1; i <= m; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        for (int i = 0; i < m; i++) {
            int d = nz.charAt(i) - '0';
            hash[i + 1] = (hash[i] * 10 + d) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int sum = prefixSum[r + 1] - prefixSum[l];

            int left = prefixCnt[l];
            int right = prefixCnt[r + 1];
            int len = right - left;

            long num = (hash[right] - (hash[left] * pow10[len]) % MOD + MOD) % MOD;

            ans[i] = (int) ((num * sum) % MOD);
        }

        return ans;
    }
}
