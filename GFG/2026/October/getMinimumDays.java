class Solution {
    public int getMinimumDays(String s, int[] p) {

        int action = 0;

        StringBuilder sb = new StringBuilder(s);
            if (s.length() <= 1) {
            return 0;
           }

        for (int i = 0; i < p.length; i++) {

            int index = p[i];

            if (index == p.length - 1) {

                if (sb.charAt(index - 1) == sb.charAt(index)) {
                    sb.setCharAt(index, '?');
                    action = i + 1;
                }
            }

            else if (index == 0) {

                if (sb.charAt(index) == sb.charAt(index + 1)) {
                    sb.setCharAt(index, '?');
                    action = i + 1;
                }
            }

            else {

                if (sb.charAt(index) == sb.charAt(index - 1) ||
                    sb.charAt(index) == sb.charAt(index + 1)) {

                    sb.setCharAt(index, '?');
                    action = i + 1;
                }
            }

     }

        return action;
    }
}

