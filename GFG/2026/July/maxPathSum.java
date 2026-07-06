class Solution {
    public int maxPathSum(int[] a, int[] b) {
        // code here
        int sumA=0;
        int sumB=0;
        int ans=0;
        int i=0;
        int j=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                sumA+=a[i];
                i++;
            }else if(a[i]>b[j]){
                sumB+=b[j];
                j++;
            }else{
                ans=Math.max(sumA,sumB)+a[i];
                sumA=0;
                sumB=0;
                i++;
                j++;
            }
        }
        while(i<a.length){
            sumA+=a[i];
            i++;
        }
        while(j<b.length){
            sumB+=b[j];
            j++;
        }
        ans+=Math.max(sumA,sumB);
        return ans;
    }
}
