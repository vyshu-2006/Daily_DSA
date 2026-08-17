class Solution {
     public int minThrows(int n, int[] lad, int[] sn) {
         int total = n * n;

         int[] jump = new int[total + 1];

         for(int i = 0; i < lad.length; i += 2){
             jump[lad[i]] = lad[i + 1];
         }

         for(int i = 0; i < sn.length; i += 2){
             jump[sn[i]] = sn[i + 1];
         }

         boolean[] visited = new boolean[total + 1];

         Queue<Integer> q = new LinkedList<>();
         q.add(1);
         visited[1] = true;

         int throwsCount = 0;

         while(!q.isEmpty()){
             int size = q.size();

             while(size-- > 0){
                 int curr = q.poll();

                 if(curr == total){
                     return throwsCount;
                 }

                 for(int dice = 1; dice <= 6; dice++){
                     int next = curr + dice;

                     if(next > total) break;

                     if(jump[next] != 0){
                         next = jump[next];
                     }

                     if(!visited[next]){
                         visited[next] = true;
                         q.add(next);
                     }
                 }
             }

             throwsCount++;
         }

         return -1;
     }
 }
