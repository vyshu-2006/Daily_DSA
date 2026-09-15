class Solution {
    public int getCount(Node root, int k) {

        if (root == null)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node node = q.remove();

                if (node.left == null && node.right == null) {
                    pq.add(level);
                }

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }

            level++;
        }

        int sum = 0;
        int count = 0;

        while (!pq.isEmpty()) {

            int val = pq.remove();

            if (sum + val > k)
                break;

            sum += val;
            count++;
        }

        return count;
    }
}
