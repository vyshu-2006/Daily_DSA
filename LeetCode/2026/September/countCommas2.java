class Solution {
    public long countCommas(long n) {
        long ans = 0;
        if (n >= 1_000) {
            ans += Math.min(n, 999_999L) - 999;
        }
        if (n >= 1_000_000) {
            ans += (Math.min(n, 999_999_999L) - 999_999L) * 2;
        }
        if (n >= 1_000_000_000L) {
            ans += (Math.min(n, 999_999_999_999L) - 999_999_999L) * 3;
        }
        if (n >= 1_000_000_000_000L) {
            ans += (Math.min(n, 999_999_999_999_999L)
                    - 999_999_999_999L) * 4;
        }
        if (n >= 1_000_000_000_000_000L) {
            ans += (n - 999_999_999_999_999L) * 5;
        }

        return ans;
    }
}
