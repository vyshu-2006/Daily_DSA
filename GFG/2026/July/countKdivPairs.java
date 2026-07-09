class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int[] freq = new int[k];
        int count = 0;

        for (int num : arr) {
            int rem = num % k;
            if (rem < 0) rem += k;

            int complement = (k - rem) % k;
            count += freq[complement];

            freq[rem]++;
        }

        return count;
    }
}
