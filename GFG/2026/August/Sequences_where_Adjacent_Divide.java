class Solution {
    public int count(int n, int m) {
        // code here
        int ans = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
             Arrays.fill(dp[i], -1);
        }
        for(int first = 1; first <= m; first++) {
            ans += solve(1, first,n,m,dp);
        }

        return ans;
    }
    public int solve(int index,int prev,int n,int m,int[][] dp){
        if(index==n) return 1;
        if(dp[index][prev]!=-1) return dp[index][prev];
        int count = 0;

         for(int curr = 1; curr <= m; curr++) {

            if(curr % prev == 0 || prev % curr == 0) {

                count += solve(index + 1, curr,n,m,dp);
            }
        }
        dp[index][prev] = count;

        return dp[index][prev];
    }
}
