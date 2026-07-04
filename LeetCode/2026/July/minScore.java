class Solution {
    int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        List<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        boolean[] vis = new boolean[n + 1];
        dfs(1, adj, vis);

        return ans;
    }

    private void dfs(int node, List<int[]>[] adj, boolean[] vis) {
        vis[node] = true;

        for (int[] nei : adj[node]) {
            int next = nei[0];
            int wt = nei[1];

            ans = Math.min(ans, wt);

            if (!vis[next]) {
                dfs(next, adj, vis);
            }
        }
    }
}
