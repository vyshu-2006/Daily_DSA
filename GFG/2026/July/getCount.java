class Solution {
    public int getCount(int n) {
        int count = 0;

        for (int k = 2; k * (k + 1) / 2 <= n; k++) {
            int temp = 2 * n;

            if (temp % k != 0) continue;

            int val = temp / k - k + 1;

            if (val > 0 && val % 2 == 0)
                count++;
        }

        return count;
    }
}
