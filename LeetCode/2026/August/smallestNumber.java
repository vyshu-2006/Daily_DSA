class Solution {
    public int smallestNumber(int n, int t) {
        int curr=n;
        while(curr>=n){
          String s=Integer.toString(curr);
          int product=1;
          for(char ch:s.toCharArray()){
            if(ch=='0') return curr;
            product*=ch-'0';
          }
          if(product%t==0) return curr;
          else curr++;
        }
        return -1;
    }
}
