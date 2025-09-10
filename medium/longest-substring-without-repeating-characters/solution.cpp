#include <unordered_map>

class Solution {
    public:
        int lengthOfLongestSubstring(string s) {
            unordered_map<char, int> table;
            int longest = 0, start = 0;

            for (int i = 0; i < s.size(); ++i) {
                char c = s.at(i);
                if (table.find(c) != table.end()) {
                    longest = std::max(longest, static_cast<int>(table.size()));
                    int index = table.at(c), tmp = index + 1;
                    while (--index >= start) table.erase(s.at(index));
                    start = tmp;
                }
                table[c] = i;
            }

            return std::max(longest, static_cast<int>(table.size()));
        }
    };