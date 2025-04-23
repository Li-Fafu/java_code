class Solution {
    public int mySqrt(int x) {
        if (x < 1) {
            return 0;
        }
        int left = 1;
        long right = x;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;

            if (mid * mid <= x) {
                left = (int) mid;
            } else {
                right = mid - 1;
            }

        }
        return (int) left;
    }
}