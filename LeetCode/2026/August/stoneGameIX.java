class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n=stones.length;
        int[] rem=new int[n];
        for(int i=0;i<n;i++){
            rem[i]=stones[i]%3;
        }
        int c0=0;
        int c1=0;
        int c2=0;
        for(int x:rem){
            if(x==0) c0++;
            else if(x==1) c1++;
            else c2++;
        }
        if(c0%2==0){
            if(c1>0 && c2>0) return true;
            else return false;
        }else{
            if(Math.abs(c1-c2)>2) return true;
            else return false; 
        }
    }
}
