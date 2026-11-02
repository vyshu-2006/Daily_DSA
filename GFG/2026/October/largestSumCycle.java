class Solution {

    public int largestSumCycle(int[] edge) {

        int n = edge.length;

        int[] vis = new int[n];
        int ans = -1;



        for (int i = 0; i < n; i++) {

            if (vis[i] == 0) {

                int cur = i;
                while (cur != -1 && vis[cur] == 0) {

                    vis[cur] = 1; 
                    cur = edge[cur];

                }

                if (cur != -1 && vis[cur] == 1) {

                    int sum = 0;

                    int temp = cur;

                   
                    do {

                        sum += temp;

                        temp = edge[temp];

                    } while (temp != cur);



                    ans = Math.max(ans, sum);

                }


                cur = i;

                while (cur != -1 && vis[cur] == 1) {

                    vis[cur] = 2;

                    cur = edge[cur];

                }

            }

        }

        return ans;

    }

}
