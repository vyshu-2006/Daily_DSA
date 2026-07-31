class Solution {
    static final int MOD = 1000000007;

    public int countSubsets(int[] arr) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        int[] masks = new int[31];

        for (int num = 2; num <= 30; num++) {
            int x = num;
            int mask = 0;
            boolean valid = true;

            for (int i = 0; i < 10; i++) {
                int cnt = 0;
                while (x % primes[i] == 0) {
                    x /= primes[i];
                    cnt++;
                }

                if (cnt > 1) {
                    valid = false;
                    break;
                }

                if (cnt == 1)
                    mask |= (1 << i);
            }

            if (x > 1)
                valid = false;

            if (valid)
                masks[num] = mask;
        }

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        int ones = 0;

        for (int num : arr) {
            if (num == 1) {
                ones++;
                continue;
            }

            if (masks[num] == 0)
                continue;

            int mask = masks[num];

            for (int state = (1 << 10) - 1; state >= 0; state--) {
                if ((state & mask) == 0) {
                    dp[state | mask] =
                        (dp[state | mask] + dp[state]) % MOD;
                }
            }
        }

        long ans = 0;
        for (int i = 1; i < (1 << 10); i++)
            ans = (ans + dp[i]) % MOD;

        long mul = 1;
        while (ones-- > 0)
            mul = (mul * 2) % MOD;

        ans = (ans * mul) % MOD;

        return (int) ans;
    }
}
