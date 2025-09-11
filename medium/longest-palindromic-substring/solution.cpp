class Solution {
    public:
        string longestPalindrome(string s) {
            int start = 0, longest = 0;
            for (size_t i = 0; i < s.size() - longest / 2; ++i) {
                for (unsigned char c = 0; c < 2; ++c) {
                    int left = i - c, right = i + 1;
                    while (left >= 0 && right < s.size() && s.at(left) == s.at(right)) {
                        --left;
                        ++right;
                    }
                    size_t width = right - left - 1;
                    if (width > longest) {
                        start = left + 1;
                        longest = width;
                    }
                }
            }
            return s.substr(start, longest);
        }
    };