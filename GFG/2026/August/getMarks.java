class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        ArrayList<Integer> ans = new ArrayList<>();

        long[] prefix = new long[n];

        for (int i = 0; i < n; i++) {
            long count = (long) r[i] - l[i] + 1;
            prefix[i] = count + (i == 0 ? 0 : prefix[i - 1]);
        }

        for (int k : rank) {
            int low = 0, high = n - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (prefix[mid] >= k)
                    high = mid;
                else
                    low = mid + 1;
            }

            long previous = low == 0 ? 0 : prefix[low - 1];
            ans.add((int)(l[low] + k - previous - 1));
        }

        return ans;
    }
}
