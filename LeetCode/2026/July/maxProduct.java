class Solution {
    public int maxProduct(int n) {
        String s=Integer.toString(n);
        int[] digits=new int[s.length()];
        for(int i=0;i<s.length();i++){
            digits[i]=s.charAt(i)-'0';
        }
        Arrays.sort(digits);
        return digits[s.length()-1]*digits[s.length()-2];
    }
}
