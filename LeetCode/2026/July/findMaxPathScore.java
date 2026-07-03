import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int low = 0, high = 0;
        for (int[] edge : edges) {
            high = Math.max(high, edge[2]);
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid, edges, online, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int mid, int[][] edges, boolean[] online, long k) {
        int n = online.length;

        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cost = edge[2];

            if (cost < mid) continue;

            graph[u].add(new int[]{v, cost});
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int[] nei : graph[u]) {
                int v = nei[0];
                int cost = nei[1];

                if (dist[u] != Long.MAX_VALUE && online[v]) {
                    dist[v] = Math.min(dist[v], dist[u] + cost);
                }

                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return dist[n - 1] <= k;
    }
}
