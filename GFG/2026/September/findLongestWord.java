class Solution {

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length(); 
            }

            return a.compareTo(b);
        });



        for (String word : d) {
            if (isSubsequence(word, s)) {
                return word; 

            }

        }
        return "";

    }
    private boolean isSubsequence(String word, String s) {
        int wordPtr = 0;
        int sPtr = 0;
        while (wordPtr < word.length() && sPtr < s.length()) {
            if (word.charAt(wordPtr) == s.charAt(sPtr)) {
                wordPtr++;
            }
            sPtr++;
        }

        return wordPtr == word.length();
    }
}
