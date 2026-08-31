class Solution {
    public int minCost(int n, int i, int d, int c) {
        long[] dp = new long[n + 1];
        dp[0] = 0;

        java.util.ArrayDeque<Integer> deque = new java.util.ArrayDeque<>();

        for (int len = 1; len <= n; len++) {
            int add = len - 1;

            if (add >= 1) {
                long value = dp[add] + 2L * add * d;

                while (!deque.isEmpty()) {
                    int last = deque.peekLast();
                    long lastValue = dp[last] + 2L * last * d;

                    if (lastValue <= value) {
                        break;
                    }

                    deque.pollLast();
                }

                deque.offerLast(add);
            }

            int minX = (len + 1) / 2;

            while (!deque.isEmpty() && deque.peekFirst() < minX) {
                deque.pollFirst();
            }

            dp[len] = dp[len - 1] + i;

            if (!deque.isEmpty()) {
                long copyDelete = dp[deque.peekFirst()]
                        + c
                        + (2L * deque.peekFirst() - len) * d;

                dp[len] = Math.min(dp[len], copyDelete);
            }
        }

        return (int) dp[n];
    }
}
