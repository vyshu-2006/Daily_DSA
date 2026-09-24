class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        // code here
        int n = r.length;

              int[][] discs = new int[n][2];

              for (int i = 0; i < n; i++) {
                  discs[i][0] = r[i];
                  discs[i][1] = h[i];
              }
              Arrays.sort(discs, (a, b) -> Integer.compare(a[0], b[0]));
              int[] bit = new int[1002];

              int answer = 0;

              int i = 0;

              while (i < n) {
                  int j = i;

                    while (j < n && discs[j][0] == discs[i][0]) {
                      j++;
                  }

                  int[] dp = new int[j - i];

                  for (int k = i; k < j; k++) {
                      int height = discs[k][1];
                      int best = query(bit, height - 1);

                      dp[k - i] = best + height;

                      answer = Math.max(answer, dp[k - i]);
                  }
                  for (int k = i; k < j; k++) {
                      int height = discs[k][1];

                      update(bit, height, dp[k - i]);
                  }

                  i = j;
              }

              return answer;
          }
          private int query(int[] bit, int index) {
              int result = 0;

              while (index > 0) {
                  result = Math.max(result, bit[index]);
                  index -= index & -index;
              }

              return result;
          }
          private void update(int[] bit, int index, int value) {
              while (index < bit.length) {
                  bit[index] = Math.max(bit[index], value);
                  index += index & -index;
              }
    }
}

