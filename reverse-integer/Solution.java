class Solution {
    public int reverse(int x) {
        int result = 0;
        for (int i = 0; i < 9 && x != 0; ++i, x %= 10) {
            result = result * 10 + x % 10;
        }

        if (x != 0) {
            if (Math.abs(result) > Integer.MAX_VALUE / 10) return 0;
            result = result * 10 + x;
        }

        return result;
    }
}