class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;
        while(l<=nums.length-k){
            HashSet<Integer> set=new HashSet<>();
            for(int i=l;i<l+k;i++){
                set.add(nums[i]);
            }
            for(int x:set){
                map.put(x,map.getOrDefault(x,0)+1);
            }
            l++;
        }
        int ans=-1;
        for(int i:map.keySet()){
            if(map.get(i)==1){
                ans=Math.max(ans,i);
            }
        }
        return ans;
    }
}
