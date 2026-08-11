class Solution {
    public int missingInteger(int[] nums) {
       HashSet<Integer> set=new HashSet<>();
       int ans=0;
       int sum=nums[0];
       for(int x:nums){
        set.add(x);
       }
       for(int i=1;i<nums.length;i++){
         if((nums[i-1]+1)==nums[i]){
            sum+=nums[i];
         }else {
            break;
         }
       } 
       ans=sum;
        while(set.contains(ans)){
                ans+=1;
        }
       return ans;
    }
}
