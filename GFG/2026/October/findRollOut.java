class Solution {
    public String findRollOut(String s, int[] roll) {
        Arrays.sort(roll);
        char[] c = s.toCharArray();
        int n = c.length;
        int rollIdx = roll.length - 1;
        int activeRolls = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (rollIdx >= 0 && roll[rollIdx] >= i + 1) {
                activeRolls++;
                rollIdx--;
            }
            int shift = activeRolls % 26;
            c[i] = (char) ('a' + (c[i] - 'a' + shift) % 26);
        }
        return new String(c);
    }

}
