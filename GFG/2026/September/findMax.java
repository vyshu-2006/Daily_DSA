class Solution {
    public int findMax(int n) {
        int ans = n;
        int place = 1;

        while (place <= n) {
            int candidate = (n / (place * 10)) * (place * 10)
                          + ((n / place) % 10 - 1) * place
                          + (place - 1);

            if (candidate > 0 && digitSum(candidate) > digitSum(ans)) {
                ans = candidate;
            }

            place *= 10;
        }

        return ans;
    }

    private int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
