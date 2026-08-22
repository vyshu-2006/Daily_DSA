class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int product=1;
        String s=Integer.toString(n);
        for(char ch:s.toCharArray()){
            sum+=ch-'0';
            product*=ch-'0';
        }
        return (n%(sum+product)==0)?true:false;
    }
}
