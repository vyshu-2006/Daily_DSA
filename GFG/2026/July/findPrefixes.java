class Solution {
    public ArrayList<String> findPrefixes(String[] arr) {
        // code here
        ArrayList<String> res=new ArrayList<>();
        Trie trie=new Trie();
        for(String word:arr){
            trie.insert(word);
        }
        for(String word:arr){
            res.add(trie.uniquePrefix(word));
        }
        return res;
    }
    
}
class TrieNode{
    TrieNode[] children=new TrieNode[26];
        boolean isEnd;
        int count;
}
class Trie{
        TrieNode root=new TrieNode();
        void insert(String s){
            TrieNode curr=root;
            for(char c:s.toCharArray()){
                if(curr.children[c-'a']==null){
                    TrieNode newNode=new TrieNode();
                    curr.children[c-'a']=newNode;
                }
                curr=curr.children[c-'a'];
                curr.count++;
            }
            curr.isEnd=true;
        }
        public String uniquePrefix(String word){
        StringBuilder sb=new StringBuilder();
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null) return "";
            else{
                curr=curr.children[c-'a'];
                 sb.append(c);
                if(curr.count==1){
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }
}
