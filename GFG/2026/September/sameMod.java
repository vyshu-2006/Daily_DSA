class Solution {
    public int sameMod(int[] arr) {
        // code here
        int n=arr.length;
        if(n==1) return -1;
        int[] diff=new int[n-1];
        for(int i=0;i<n-1;i++){
            diff[i]=Math.abs(arr[i]-arr[i+1]);
        }
        int gcd=gcd(diff);
        if(gcd==0) return -1;
        int count=0;
        for(int i=1;i*i<=gcd;i++){
            if(gcd%i==0 && i*i==gcd) count++;
            else if(gcd%i==0 && i*i!=gcd) count+=2;
        }
        return count;
    }
    public int gcd(int[] arr){
        int g=arr[0];
        for(int i=1;i<arr.length;i++){
            g=gcd(g,arr[i]);
        }
        return g;
    }
    public int gcd(int x,int y){
        while(y!=0){
            int rem=x%y;
            x=y;
            y=rem;
        }
        return x;
    }
}
