class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        // code here
        Stack<Integer> stack=new Stack<>();
        stack.push(arr.get(0));
        int lowerBound=Integer.MIN_VALUE;
        for(int i=1;i<arr.size();i++){
            int value=arr.get(i);
            if(value < lowerBound) return false;
            while(!stack.isEmpty() && value > stack.peek()){
                lowerBound = stack.pop();
                 
            }
            stack.push(value);
            
        }
        return true;
    }
}
