class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] t = target.toCharArray();
        int n = target.length();

        for (int i = 0; i < n; i++) {
            int x = t[i] - 'a';

            if (freq[x] == 0) {
                for (int j = x + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        return build(t, i, j, freq);
                    }
                }

                for (int k = i - 1; k >= 0; k--) {
                    int c = t[k] - 'a';
                    freq[c]++;

                    for (int j = c + 1; j < 26; j++) {
                        if (freq[j] > 0) {
                            return build(t, k, j, freq);
                        }
                    }
                }

                return "";
            }

            freq[x]--;
        }

        for (int i = n - 1; i >= 0; i--) {
            int c = t[i] - 'a';
            freq[c]++;

            for (int j = c + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    return build(t, i, j, freq);
                }
            }
        }

        return "";
    }

    private String build(char[] t, int pos, int ch, int[] freq) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < pos; i++) {
            ans.append(t[i]);
        }

        ans.append((char) ('a' + ch));
        freq[ch]--;

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                ans.append((char) ('a' + i));
                freq[i]--;
            }
        }

        return ans.toString();
    }
}
