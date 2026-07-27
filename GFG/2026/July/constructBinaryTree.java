/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    int preIndex=0;
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<preMirror.length;i++){
            map.put(preMirror[i],i);
        }
        return build(pre,preMirror,map,0,preMirror.length-1);
    }
    public Node build(int[] pre,int[] preMirror, HashMap<Integer,Integer> map,
                      int low,int high){
        Node root=new Node(pre[preIndex]);
        preIndex++;
        if(low==high) return root;
        if(preIndex>=pre.length) return root;
        int idx = map.get(pre[preIndex]);
        root.left=build(pre,preMirror,map,idx,high);
        root.right=build(pre,preMirror,map,low+1,idx-1);
        return root;
    }
}
