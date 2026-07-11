class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] count = new int[2];
                dfs(i, adj, visited, count);

                int vertices = count[0];
                int edgesInComponent = count[1] / 2;

                if (edgesInComponent == vertices * (vertices - 1) / 2) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, int[] count) {
        visited[node] = true;
        count[0]++; 
        count[1] += adj.get(node).size(); 

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, count);
            }
        }
    }
}
