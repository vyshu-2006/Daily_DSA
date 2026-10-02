class Solution {
    public String lexiString(String s) {
        // code here
        int n = s.length();
               int i = 0, j = 1, k = 0;
               while (i < n && j < n && k < n) {
                   char charI = s.charAt((i + k) % n);
                   char charJ = s.charAt((j + k) % n);

                   if (charI == charJ) {
                       k++;
                   } else {
                       if (charI > charJ) {
                           i += k + 1;
                       } else {
                           j += k + 1;
                       }

                       if (i == j) {
                           j++;
                       }
                       k = 0; 
                   }
               }
               int startPos = Math.min(i, j);
               return s.substring(startPos) + s.substring(0, startPos);
    }
}
