class Solution {
public: 
    int myAtoi(string s) {
        int result = 0, i = 0, sign = 1;
        while (i < s.length() && s.at(i) == ' ') ++i;
        if (i == s.length()) return 0;

        if (s.at(i) == '-') {
            sign = -1;
            ++i;
        } else if (s.at(i) == '+') {
            ++i;
        }

        const int bound = numeric_limits<int>::max() / 10;
        unsigned char digit;

        while (i < s.length()) {
            digit = s.at(i++) - '0';
            if (digit < 0 || digit > 9) break;
            if (result > bound || (result == bound && digit > 7)) {
                return sign == 1? numeric_limits<int>::max() : numeric_limits<int>::min();
            }
            result = result * 10 + digit;
        }

        return result * sign;
    }
};