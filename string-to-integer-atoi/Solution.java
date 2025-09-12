class Solution {
    public int myAtoi(String s) {
        int result = 0, i = 0, sign = 1;

        while (i < s.length() && s.charAt(i) == ' ') ++i;
        if (i == s.length()) return 0;

        if (s.charAt(i) == '-') {
            ++i;
            sign = -1;
        } else if (s.charAt(i) == '+') {
            ++i;
        }
        
        final int bound = Integer.MAX_VALUE / 10;
        while (i < s.length()) {
            int digit = s.charAt(i++) - '0';
            if (digit < 0 || digit > 9) return sign * result;
            if (result > bound || (result == bound && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;

        }
        return sign * result;
    }
}