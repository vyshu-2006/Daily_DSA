class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        int i=1;
        while(set.contains(k*i)){
            i++;
        }
        return k*i;
    }
}
