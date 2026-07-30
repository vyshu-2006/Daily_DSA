class Solution {
    public int minimumPushes(String word) {
        int[] freq=new int[26];
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int assigned=0;
        int cost=0;
        int pushcost=0;
        for(int i=25;i>=0;i--){
            if(freq[i]==0) break;
            if(assigned<8) pushcost=1;
            else if(assigned<16) pushcost=2;
            else if(assigned<24) pushcost=3;
            else pushcost=4;
            cost+=freq[i]*pushcost;
            assigned++;
        }
        return cost;
    }
}
