class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        if (m >= n) {
            int sum = 0;
            for (int x : arr) {
                sum += x;
            }
            return sum;
        }
        int windowSum = 0;
        for (int i = 0; i < m; i++) {
            windowSum += arr.get(i);
        }

        int max = windowSum;

        for (int i = 1; i < n; i++) {
            windowSum -= arr.get(i - 1);
            windowSum += arr.get((i + m - 1) % n);

            max = Math.max(max, windowSum);
        }

        return max;
    }
}
