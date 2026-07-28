class Solution {
    public String smallestPalindrome(String s) {
      HashMap<Character,Integer> freq=new HashMap<>();
      for(char ch:s.toCharArray()){
         freq.put(ch,freq.getOrDefault(ch,0)+1);
      }
      StringBuilder left=new StringBuilder();
      String middle="";
      for(char ch='a';ch<='z';ch++){
        int count=0;
        if(freq.containsKey(ch)){
            count=freq.get(ch);
        }
        if(count%2!=0){
            middle=String.valueOf(ch);
        }
        for(int i=0;i<count/2;i++){
           left.append(ch);
        }
      }
      StringBuilder copy = new StringBuilder(left);
      String right=copy.reverse().toString();
      return left+middle+right;
    }
}
