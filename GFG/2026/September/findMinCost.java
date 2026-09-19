class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        // code here
        int n= s1.length(), m=s2.length();
        int[][]dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++)
        {
            Arrays.fill(dp[i],0);
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int lcs=dp[n][m];
        int del1=n-lcs;
        int del2=m-lcs;
        int tot=(del1*costS1)+(del2*costS2);
        return tot;
    }
}
