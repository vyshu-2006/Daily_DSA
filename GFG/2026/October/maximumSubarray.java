class Solution {
    public int maximumSubarray(int[] arr) {
        // code here
      int n = arr.length;
      int square = 0;
      int nosquare = 0;
      int ans = 0;
      for(int i=0;i<n;i++){
          int curr = arr[i];
          int newnosquare = Math.max(curr ,nosquare+curr);
          int newsquare = Math.max(curr*curr,Math.max(nosquare+curr*curr,square+curr));
          nosquare = newnosquare;
          square = newsquare;
          ans = Math.max(ans,Math.max(nosquare,square));
      }
      return ans;
    }
}
