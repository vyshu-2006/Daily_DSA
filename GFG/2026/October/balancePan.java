class Solution {
    public boolean balancePan(int a, int b) {
        while (b > 0) {
            int rem = b % a;

            if (rem == 1) {
                b--;
            } else if (rem == a - 1) {
                b++;
            } else if (rem != 0) {
                return false;
            }

            b /= a;
        }

        return true;
    }
}
