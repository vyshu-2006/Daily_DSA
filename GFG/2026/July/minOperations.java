class Solution {
    static final long MOD = 1000000007L;

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public int minOperations(int[] b) {
        int n = b.length;
        boolean[] vis = new boolean[n];
        long ans = 1;

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {

                int curr = i;
                int len = 0;

                while (!vis[curr]) {
                    vis[curr] = true;
                    curr = b[curr] - 1;   // convert to 0-based
                    len++;
                }

                ans = (ans / gcd(ans, len)) * len;
                ans %= MOD;
            }
        }

        return (int) ans;
    }
}
