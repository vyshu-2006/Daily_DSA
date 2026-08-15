class Solution {
    public int countWithout(int n, int d) {
        if (n == 0) return 0;

        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        int[][][] dp = new int[len + 1][2][2];
        dp[0][1][0] = 1;

        for (int i = 0; i < len; i++) {
            for (int tight = 0; tight <= 1; tight++) {
                for (int started = 0; started <= 1; started++) {

                    for (int x = 0; x <= (tight == 1 ? digits[i] - '0' : 9); x++) {

                        if (started == 1 || x != 0) {
                            if (x == d) continue;
                        }

                        int nt = (tight == 1 && x == digits[i] - '0') ? 1 : 0;
                        int ns = (started == 1 || x != 0) ? 1 : 0;

                        dp[i + 1][nt][ns] += dp[i][tight][started];
                    }
                }
            }
        }

        return dp[len][0][1] + dp[len][1][1];
    }
}
