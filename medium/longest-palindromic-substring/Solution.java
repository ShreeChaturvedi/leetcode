class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 1, length = 0;
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length - length / 2; ++i) {
            for (int c = 0; c < 2; ++c) {
                int left = i - c, right = i + 1;
                while (left >= 0 && right < sc.length && sc[left] == sc[right]) {
                    --left;
                    ++right;
                }
                if (right - left - 1 > length) {
                    start = left + 1;
                    end = right;
                    length = end - start;
                }
            }
        }
        return s.substring(start ,end);
    }
}