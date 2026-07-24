class Solution {
    public int uniqueXorTriplets(int[] nums) {
       boolean[] pair=new boolean[2048];
       boolean[] ans=new boolean[2048];
       for(int i=0;i<nums.length;i++){
        for(int j=0;j<nums.length;j++){
            pair[nums[i]^nums[j]]=true;
        }
       } 
       for(int i=0;i<2048;i++){
        if(pair[i]){
           for(int x:nums){
            ans[i^x]=true;
           } 
        }
       }
       int count=0;
       for(boolean x:ans){
        if(x) count++;
       }
        return count;
    }
}
