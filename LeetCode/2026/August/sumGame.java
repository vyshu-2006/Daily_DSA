class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int diff = 0;
        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            if (i < n / 2) {
                if (ch == '?')
                    leftQ++;
                else
                    diff += ch - '0';
            } else {
                if (ch == '?')
                    rightQ++;
                else
                    diff -= ch - '0';
            }
        }

        if ((leftQ + rightQ) % 2 == 1)
            return true;

        diff -= 9 * (rightQ - leftQ) / 2;

        return diff != 0;
    }
}
