class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> res=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        Arrays.sort(nums);
        int start=nums[0];
        int end=nums[nums.length-1];
        for(int i=start;i<end;i++){
            if(!set.contains(i)) res.add(i);
        }
        return res;
    }
}
