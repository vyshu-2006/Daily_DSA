class Solution {
    public int solve(int n, String s) {
        boolean[] seen = new boolean[26];
        boolean[] using = new boolean[26];

        int available = n;
        int rejected = 0;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'A';

            if (!seen[idx]) {
                seen[idx] = true;

                if (available > 0) {
                    using[idx] = true;
                    available--;
                } else {
                    rejected++;
                }
            } else {
                if (using[idx]) {
                    available++;
                    using[idx] = false;
                }
            }
        }

        return rejected;
    }
}
