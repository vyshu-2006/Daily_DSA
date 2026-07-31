class Solution {
    public int minimumPushes(String word) {
        int[] freq=new int[26];
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int assigned=0;
        int count=0;
        int ans=0;
        for(int i=25;i>=0;i--){
            if(freq[i]==0) break;
            assigned=count/8+1;
            count++;
            ans+=freq[i] * assigned;
        }
        return ans;
    }
}
