class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb=new StringBuilder();
        String s=Integer.toString(n);
        long sum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                sb.append(s.charAt(i));
                sum+=s.charAt(i)-'0';
            }
        }
        if(sb.length()==0) return 0;
        else return Long.parseLong(sb.toString())*sum;
    }
}
