class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        long[] cnt = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt[g] += freq[multiple];
            }
        }

        long[] pairs = new long[max + 1];

        for (int g = max; g >= 1; g--) {
            if (cnt[g] >= 2) {
                pairs[g] = cnt[g] * (cnt[g] - 1) / 2;
            }

            for (int multiple = 2 * g; multiple <= max; multiple += g) {
                pairs[g] -= pairs[multiple];
            }
        }

        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + pairs[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1; 

            int lo = 1, hi = max;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (prefix[mid] >= target)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            ans[i] = lo;
        }

        return ans;
    }
}
