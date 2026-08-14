class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        long[] nums = new long[arr.length + 1];
        nums[0] = s;

        long sum = s;
        int n = 1;

        for (int i = 0; i < arr.length; i++) {
            long next = sum + arr[i];

            if (next > x) break;

            nums[n++] = next;
            sum += next;
        }

        long target = x;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] <= target) {
                target -= nums[i];
            }
        }

        return target == 0;
    }
}
