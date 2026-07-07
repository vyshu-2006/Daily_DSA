class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        // code here
        if(arr.length==0) return n*m;
        ArrayList<Integer> b_rows=new ArrayList<>();
        ArrayList<Integer> b_cols=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            b_rows.add(arr[i][0]);
        }
        for(int j=0;j<arr.length;j++){
            b_cols.add(arr[j][1]);
        }
        Collections.sort(b_rows);
        Collections.sort(b_cols);
        int r_firstgap=b_rows.get(0)-1;
        int r_secondgap=0;
        for(int i=1;i<b_rows.size();i++){
            int gap=b_rows.get(i)-b_rows.get(i-1)-1;
            r_secondgap=Math.max(r_secondgap,gap);
        }
        int r_lastgap=n-b_rows.get(b_rows.size()-1);
        int c_firstgap=b_cols.get(0)-1;
        int c_secondgap=0;
        for(int i=1;i<b_cols.size();i++){
            int gap=b_cols.get(i)-b_cols.get(i-1)-1;
            c_secondgap=Math.max(c_secondgap,gap);
        }
        int c_lastgap=m-b_cols.get(b_cols.size()-1);
        int l=Math.max(r_firstgap,Math.max(r_secondgap,r_lastgap));
        int b=Math.max(c_firstgap,Math.max(c_secondgap,c_lastgap));
        return l*b;
    }
}
