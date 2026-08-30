class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        int front = Math.max(minIdx, maxIdx) + 1;
        int back = n - Math.min(minIdx, maxIdx);
        int both = Math.min(minIdx + 1, maxIdx + 1) 
                 + Math.min(n - minIdx, n - maxIdx);

        return Math.min(front, Math.min(back, both));
    }
}
