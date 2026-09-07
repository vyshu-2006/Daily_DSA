class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[101][101];

        for (int x : arr) {

            int[][] next = new int[101][101];

            for (int inc = 0; inc <= 100; inc++) {
                for (int dec = 0; dec <= 100; dec++) {

                    int current = dp[inc][dec];
                    next[inc][dec] = Math.max(
                        next[inc][dec],
                        current
                    );
                    if (inc == 0 || x > inc) {
                        next[x][dec] = Math.max(
                            next[x][dec],
                            current + 1
                        );
                    }

                    if (dec == 0 || x < dec) {
                        next[inc][x] = Math.max(
                            next[inc][x],
                            current + 1
                        );
                    }
                }
            }

            dp = next;
        }
        int maxSelected = 0;

        for (int inc = 0; inc <= 100; inc++) {
            for (int dec = 0; dec <= 100; dec++) {
                maxSelected = Math.max(maxSelected, dp[inc][dec]);
            }
        }
        return n - maxSelected;
    }
}
