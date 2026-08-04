class Solution {
    public static int countPairs(int arr[], int k) {
        // code here
        int count=0;
        int i=0;
        Arrays.sort(arr);
       for(int j=0;j<arr.length;j++){
           while(arr[j]-arr[i]>=k){
               i++;
           }
           count+=(j-i);
       }
       return count;
    }
}
