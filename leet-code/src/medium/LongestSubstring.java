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

        for (String testCase : testCases) {
            System.out.println(testCase+ ": " + obj.optimalSolution(testCase));
        }
    }

    public int optimalSolution(String s) {
        int maxLength = 0;

        for(int rightIndex=0, leftIndex=0; rightIndex <s.length(); rightIndex++) {
            char character = s.charAt(rightIndex);

            // Find the first occurrence location for given character from left side index
            int firstOccurrenceIndex = s.indexOf(character, leftIndex);

            // present index value is not equal to the index of first occurrence of present character
            if (firstOccurrenceIndex != rightIndex) {
                leftIndex = firstOccurrenceIndex + 1;
            }

            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
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
