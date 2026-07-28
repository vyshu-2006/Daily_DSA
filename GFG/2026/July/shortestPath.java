class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());

        for(int[] e: edges){
            int u=e[0], v=e[1], w=e[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }

        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        dist[src]=0;
        pq.offer(new int[]{src,0});

        while(!pq.isEmpty()){

            int[] cur=pq.poll();

            int node=cur[0];
            int d=cur[1];

            if(d>dist[node]) continue;

            for(int[] nbr:adj.get(node)){

                int next=nbr[0];
                int wt=nbr[1];

                if(d+wt<dist[next]){
                    dist[next]=d+wt;
                    pq.offer(new int[]{next,dist[next]});
                }
            }
        }

        return dist[dest]==Integer.MAX_VALUE?-1:dist[dest];
    }
}
