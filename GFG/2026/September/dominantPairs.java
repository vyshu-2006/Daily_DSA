import java.util.*;

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int half = n / 2;

        int[] right = new int[half];

        for (int i = 0; i < half; i++) {
            right[i] = arr[half + i];
        }

        Arrays.sort(right);

        int count = 0;

        for (int i = 0; i < half; i++) {

            int low = 0;
            int high = half;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if ((long) 5 * right[mid] <= arr[i]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            count += low;
        }

        return count;
    }
}
