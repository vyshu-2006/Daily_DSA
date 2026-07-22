class Solution {
    public int minDeletions(int[] arr) {
        // code here
        List<Integer> tails=new ArrayList<>();
        for(int x: arr){
            if(tails.size()==0 || x > tails.get(tails.size()-1)){
                tails.add(x);
            }else{
                int l=0;
                int r=tails.size()-1;
                while(l<r){
                    int mid=l+(r-l)/2;
                    if(tails.get(mid)<x){
                        l=mid+1;
                    }else{
                        r=mid;
                    }
                }
                tails.set(l,x);
            }
        }
        int ans=arr.length-tails.size();
        return ans;
    }
}
