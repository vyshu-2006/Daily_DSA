class Solution {
    public int minProd(int[] arr) {
        // code here
        Arrays.sort(arr);
        int neg=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0) neg++;
        }
        if(neg==0){
            if(arr[0]==0) return 0;
            return arr[0];
        }
        int ans=1;
        if(neg%2!=0){
            for(int x:arr){
                if(x!=0)  ans*=x;
            }
        }else{
            for (int i = 0; i < arr.length; i++) {
                if (i == neg - 1 || arr[i] == 0) continue;
                ans *= arr[i];
            }
        }
        return ans;
    }
}
