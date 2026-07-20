class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] newgrid=new int[m][n];
        k=k%(m*n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int pos=i*n+j;
                int newPos=(pos+k)%(m*n);
                int newX=newPos/n;
                int newY=newPos%n;
                newgrid[newX][newY]=grid[i][j];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

         for (int j = 0; j < n; j++) {
            row.add(newgrid[i][j]);
            }

            ans.add(row);
         }

        return ans;
    }
}
