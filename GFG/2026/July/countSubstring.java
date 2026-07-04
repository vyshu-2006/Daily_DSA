class Solution {
    long ans = 0;

    public int countSubstring(String s) {
        int n = s.length();
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : -1);
        }

        mergeSort(prefix, 0, n);

        return (int) ans;
    }

    private void mergeSort(long[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        countPairs(arr, l, mid, r);
        merge(arr, l, mid, r);
    }

    private void countPairs(long[] arr, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;

        while (j <= r) {
            while (i <= mid && arr[i] < arr[j])
                i++;

            ans += (i - l);
            j++;
        }
    }

    private void merge(long[] arr, int l, int mid, int r) {
        long[] temp = new long[r - l + 1];

        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= r)
            temp[k++] = arr[j++];

        for (i = l, k = 0; i <= r; i++, k++)
            arr[i] = temp[k];
    }
}
