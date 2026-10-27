class Solution {
 
public int getMaxWeight(String s) {
// code here
int n = s.length();
int next = 0;
int secondNext = 0;
 
for (int i = n - 1; i >= 0; i--) {
int single = 1 + next;
int pair = 0;
if(i+1 < n) {
    pair = 4 + secondNext;
    if(s.charAt(i) == s.charAt(i+1))
        pair -= 1;
}
int curr = Math.max(single, pair);
secondNext = next;
next = curr;
}
return next;
}
}
 
