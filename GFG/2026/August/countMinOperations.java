class Solution {
    public int countMinOperations(int arr[]) {
        int count = 0;

        while (true) {
            boolean allZero = true;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0)
                    allZero = false;

                if (arr[i] % 2 == 1) {
                    arr[i]--;
                    count++;
                }
            }
            if (allZero)
                break;
            allZero = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero)
                break;
            for (int i = 0; i < arr.length; i++) {
                arr[i] /= 2;
            }
            count++;
        }

        return count;
    }
}
