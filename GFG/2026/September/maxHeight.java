class Solution {

    static class Box {
        int h;
        int w;
        int l;

        Box(int h, int w, int l) {
            this.h = h;
            this.w = Math.max(w, l);
            this.l = Math.min(w, l);
        }
    }

    private Box[] boxes;
    private int[] dp;

    public int maxHeight(int[] height, int[] width, int[] length) {

        int n = height.length;

        boxes = new Box[3 * n];

        int index = 0;

        for (int i = 0; i < n; i++) {
            boxes[index++] = new Box(
                height[i],
                width[i],
                length[i]
            );
            boxes[index++] = new Box(
                width[i],
                height[i],
                length[i]
            );
            boxes[index++] = new Box(
                length[i],
                height[i],
                width[i]
            );
        }

        int m = boxes.length;

        dp = new int[m];
        java.util.Arrays.fill(dp, -1);

        int answer = 0;

        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, solve(i));
        }

        return answer;
    }

    private int solve(int current) {

        if (dp[current] != -1) {
            return dp[current];
        }

        Box curr = boxes[current];

        int best = 0;

        for (int next = 0; next < boxes.length; next++) {

            Box nxt = boxes[next];

            if (nxt.w < curr.w && nxt.l < curr.l) {
                best = Math.max(best, solve(next));
            }
        }

        return dp[current] = curr.h + best;
    }
}
