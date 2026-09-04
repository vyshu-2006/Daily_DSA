class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if(max(0,i,nums)-min(i,nums.length-1,nums)<=k){
                return i;
            }else{
                continue;
            }
        }
        return -1;
    }
    public int max(int l,int r,int[] nums){
        int max=Integer.MIN_VALUE;
        for(int i=l;i<=r;i++){
            max=Math.max(max,nums[i]);
        }
        return max;
    }
    public int min(int l,int r,int[] nums){
        int min=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            min=Math.min(min,nums[i]);
        }
        return min;
    }
}
