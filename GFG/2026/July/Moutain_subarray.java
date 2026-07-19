class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] incEnd = new int[n];
        int[] decEnd = new int[n];

        incEnd[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                incEnd[i] = incEnd[i + 1];
            } else {
                incEnd[i] = i;
            }
        }

        decEnd[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                decEnd[i] = decEnd[i + 1];
            } else {
                decEnd[i] = i;
            }
        }

        ArrayList<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            int peak = incEnd[l];

            ans.add(decEnd[peak] >= r);
        }

        return ans;
    }
}
