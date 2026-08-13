class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int best;
        int len;

        Node(char leftChar, char rightChar,
             int prefix, int suffix, int best, int len) {

            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
            this.len = len;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s,
                                  String queryCharacters,
                                  int[] queryIndices) {

        arr = s.toCharArray();

        int n = arr.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];

            arr[index] = queryCharacters.charAt(i);

            update(1, 0, n - 1, index);

            ans[i] = tree[1].best;
        }

        return ans;
    }

    void build(int node, int l, int r) {

        if (l == r) {

            tree[node] = new Node(
                arr[l],
                arr[l],
                1,
                1,
                1,
                1
            );

            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    void update(int node, int l, int r, int index) {

        if (l == r) {

            tree[node] = new Node(
                arr[l],
                arr[l],
                1,
                1,
                1,
                1
            );

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, r, index);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    Node merge(Node left, Node right) {

        Node result = new Node(
            left.leftChar,
            right.rightChar,
            0,
            0,
            0,
            left.len + right.len
        );

        result.prefix = left.prefix;

        if (left.prefix == left.len &&
            left.rightChar == right.leftChar) {

            result.prefix = left.len + right.prefix;
        }

        result.suffix = right.suffix;

        if (right.suffix == right.len &&
            left.rightChar == right.leftChar) {

            result.suffix = right.len + left.suffix;
        }

        result.best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar) {

            result.best = Math.max(
                result.best,
                left.suffix + right.prefix
            );
        }

        return result;
    }
}
