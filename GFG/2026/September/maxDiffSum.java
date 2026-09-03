class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;

        long dp0 = 0; 
        long dp1 = 0; 

        for (int i = 1; i < n; i++) {

            long new0 = Math.max(
                dp0 + Math.abs(arr[i] - arr[i - 1]),
                dp1 + Math.abs(arr[i] - 1)
            );

            long new1 = Math.max(
                dp0 + Math.abs(1 - arr[i - 1]),
                dp1
            );

            dp0 = new0;
            dp1 = new1;
        }

        return (int)Math.max(dp0, dp1);
    }
}
