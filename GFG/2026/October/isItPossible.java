class Solution {
    public boolean isItPossible(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int i = 0, j = 0;
        int n = s1.length();

        while (i < n && j < n) {
            while (i < n && s1.charAt(i) == '#') {
                i++;
            }

            while (j < n && s2.charAt(j) == '#') {
                j++;
            }

            if (i == n || j == n) {
                return i == n && j == n;
            }

            char ch = s1.charAt(i);

            if (ch != s2.charAt(j)) {
                return false;
            }

            if (ch == 'A' && i < j) {
                return false;
            }

            if (ch == 'B' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}
