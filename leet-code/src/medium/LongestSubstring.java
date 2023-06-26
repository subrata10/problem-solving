package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Find Longest Substring Without Repeating Characters
 */
public class LongestSubstring {

    public static void main(String[] args) {
        String[] testCases = {"abcabcbb", "bbbbbb", "pwkpwkef"};
        LongestSubstring obj = new LongestSubstring();
//        System.out.println(obj.lengthOfLongestSubstring(s));
        for (String testCase : testCases) {
            System.out.println(testCase+ ": " + obj.optimalSolution(testCase));
        }
    }

    public int optimalSolution(String s) {
        int maxLength = 0;

        for(int right=0, left=0; right <s.length(); right++) {
            int firstOccurrence = s.indexOf(s.charAt(right), left);

            if (firstOccurrence != right) {
                left = firstOccurrence + 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();

        int startI = 0;
        int i = 0;
        int max = 0;
        Map<Character, Integer> cache = new HashMap<>();

        while(i < length) {
            if(!cache.containsKey(chars[i])) {
                cache.put(chars[i], i);
                i++;
            }
            else {
                int subStringLength = i - startI;
                if(max < subStringLength) {
                    max = subStringLength;
                }
                i = cache.get(chars[i]) + 1;
                startI = i;
                cache.clear();
            }
        }

        if (cache.size() > max) {
            max = cache.size();
        }

        return max;
    }
}
