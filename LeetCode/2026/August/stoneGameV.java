class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int l=0;
        int r=n-1;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        int[] prefix=new int[stoneValue.length+1];
        prefix[0]=0;
        for(int i=0;i<stoneValue.length;i++){
            prefix[i+1]=prefix[i]+stoneValue[i];
        }
        return solve(l,r,stoneValue,dp,prefix);
    }
    public int solve(int l,int r,int[] stoneValue,int[][] dp,int[] prefix){
        if(l==r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int ans=0;
        for(int k=l;k<r;k++){
            int left=prefix[k+1]-prefix[l];
            int right=prefix[r+1]-prefix[k+1];
            if(left<right){
                ans=Math.max(ans,left+solve(l,k,stoneValue,dp,prefix));
            }else if(right<left){
                ans=Math.max(ans,right+solve(k+1,r,stoneValue,dp,prefix));
            }else{
                ans=Math.max(ans,Math.max(left+solve(l,k,stoneValue,dp,prefix),right+solve(k+1,r,stoneValue,dp,prefix)));
            }
        }
        dp[l][r]=ans;
        return dp[l][r];
    }
}
