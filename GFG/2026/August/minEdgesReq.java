class Solution {

    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    boolean union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return false;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        }
        else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        }
        else {
            parent[pb] = pa;
            rank[pa]++;
        }

        return true;
    }

    public int minEdgesReq(int n, int[][] edges) {

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int extraEdges = 0;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (!union(u, v)) {
                extraEdges++;
            }
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                components++;
            }
        }

        int needed = components - 1;

        if (extraEdges >= needed)
            return needed;

        return -1;
    }
}
