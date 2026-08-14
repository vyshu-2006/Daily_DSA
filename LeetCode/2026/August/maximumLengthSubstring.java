class Solution {
    public int maximumLengthSubstring(String s) {
        int res=0;
        int[] freq=new int[26];
        int l=0;
        for(int r=0;r<s.length();r++){
            freq[(s.charAt(r))-'a']++;
            while(freq[s.charAt(r)-'a']>2){
                freq[s.charAt(l)-'a']--;
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}
