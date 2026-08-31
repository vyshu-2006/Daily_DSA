class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int prevCritical = -1;
        int min = Integer.MAX_VALUE;
        int pos = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {
            if ((prev.val < curr.val && curr.val > curr.next.val) ||
                (prev.val > curr.val && curr.val < curr.next.val)) {

                if (first == -1) {
                    first = pos;
                } else {
                    min = Math.min(min, pos - prevCritical);
                }

                prevCritical = pos;
            }

            prev = curr;
            curr = curr.next;
            pos++;
        }

        if (first == -1 || first == prevCritical) {
            return new int[]{-1, -1};
        }

        return new int[]{min, prevCritical - first};
    }
}
