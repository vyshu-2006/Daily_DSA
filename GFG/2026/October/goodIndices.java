class Solution {

    private boolean dfs(int curr, int[] arr, boolean[] vis,
                     boolean[] stack, Set<Integer> good,
                     Set<Integer> bad) {

        int n = arr.length;
        if (curr < 0 || curr >= n) {
            return true;
        }
        if (good.contains(curr)) {
            return true;
        }

        if (bad.contains(curr)) {
            return false;
        }
        if (stack[curr]) {
            return false;
        }

        vis[curr] = true;
        stack[curr] = true;

        int next = curr + arr[curr];

        boolean res = dfs(next, arr, vis, stack, good, bad);

        stack[curr] = false;
        if (res) {
            good.add(curr);
        } else {
            bad.add(curr);
        }

        return res;
    }

    public int goodIndices(int[] arr) {
        int n = arr.length;

        boolean[] vis = new boolean[n];
        boolean[] stack = new boolean[n];

        Set<Integer> good = new HashSet<>();
        Set<Integer> bad = new HashSet<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                boolean res = dfs(i, arr, vis, stack, good, bad);

                if (res) {
                    count++;
                }
            } else if (good.contains(i)) {
                count++;
            }
        }

        return count;
    }
}
