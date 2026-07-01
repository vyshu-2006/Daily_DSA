class Solution {
    public int maxSumSubarray(int[] arr) {
        // code here
        int n=arr.length;
        int res=arr[0];
        int[] keep=new int[n];
        keep[0]=arr[0];
        int[] delete=new int[n];
        delete[0]=Integer.MIN_VALUE/2;
        for(int i=1;i<n;i++){
            keep[i]=Math.max(arr[i],keep[i-1]+arr[i]);
            delete[i]=Math.max(delete[i-1]+arr[i],keep[i-1]);
        }
        for(int i=0;i<n;i++){
            res=Math.max(res,Math.max(keep[i],delete[i]));
        }
        return res;
    }
}
