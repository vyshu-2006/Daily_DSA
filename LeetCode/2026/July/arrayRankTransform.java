class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] arr_sorted=arr.clone();
        Arrays.sort(arr_sorted);
        for (int num : arr_sorted) {
            if (!map.containsKey(num)) {
                map.put(num, map.size() + 1);
            }
        }
        int[] res=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i]=map.get(arr[i]);
        }
        return res;
    }
}
