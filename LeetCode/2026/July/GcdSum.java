class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] prefixGcd=new int[n];
        int mxi=nums[0];
        prefixGcd[0]=nums[0];
        for(int i=1;i<n;i++){
            mxi=Math.max(mxi,nums[i]);
            prefixGcd[i]=gcd(mxi,nums[i]);
        }
        Arrays.sort(prefixGcd);
        int l=0;
        int r=n-1;
        long sum=0;
        while(l<r){
            sum+=gcd(prefixGcd[l],prefixGcd[r]);
            l++;
            r--;
        }
        return sum;
    }
    public static int gcd(int a,int b){
        while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
        }       
        return a;
    }
}
