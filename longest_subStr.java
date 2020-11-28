import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int lengthOfLongest = 0;
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            Boolean expandWindow = true;
            while (expandWindow && j < s.length()) {
                if (charMap.containsKey(s.charAt(j))) {
                    if (charMap.get(s.charAt(j)) >= i && charMap.get(s.charAt(j)) < j) {
                        lengthOfLongest = Math.max(lengthOfLongest, (j - i));
                        i = Math.min(s.length(), j - 1);
                        expandWindow = false;
                    } else {
                        charMap.put(s.charAt(j), j);
                        j++;
                    }
                } else {
                    charMap.put(s.charAt(j), j);
                    j++;
                }
            }
            if (j == s.length()) {
                lengthOfLongest = Math.max(lengthOfLongest, (j - i));
            }
        }
        return lengthOfLongest;
    }

    public static void main(String[] args) {
        int returnValue = Solution.lengthOfLongestSubstring("dvdf");
        System.out.println("solution is:");
        System.out.println(returnValue);
    }
}