class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0, start = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                longest = Math.max(longest, map.size());
                int index = map.get(c), tmp = index + 1;
                while (--index >= start) map.remove(map.get(index));
                start = tmp;
            }
            map.put(c, i);
        }

        return Math.max(longest, map.size());
    }
}