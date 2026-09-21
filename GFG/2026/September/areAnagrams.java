/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {

    public boolean areAnagrams(Node root1, Node root2) {

        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();
             if (size1 != size2) return false;
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < size1; i++) {
                Node curr = q1.poll();
                freqMap.put(curr.data, freqMap.getOrDefault(curr.data, 0) + 1);
                if (curr.left != null) q1.add(curr.left);
                if (curr.right != null) q1.add(curr.right);
            }
            for (int i = 0; i < size2; i++) {
                Node curr = q2.poll();
                if (!freqMap.containsKey(curr.data)) return false;
                freqMap.put(curr.data, freqMap.get(curr.data) - 1);
                if (freqMap.get(curr.data) == 0) {
                    freqMap.remove(curr.data);
                }
                if (curr.left != null) q2.add(curr.left);
                if (curr.right != null) q2.add(curr.right);
            }
            if (!freqMap.isEmpty()) return false;
        }
        return q1.isEmpty() && q2.isEmpty();

    }

}
