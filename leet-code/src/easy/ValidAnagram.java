package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/valid-anagram">Problem Description</a>
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(valid(s, t));
    }

    private static boolean valid(String s, String t){
        int slen = s.length();
        int tlen = t.length();

        if(slen != tlen) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(char c : sChars) {
            sMap.put(c, sMap.getOrDefault(c,0)+1);
        }

        for(char c : tChars) {
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }

        for(char c : sChars) {
            if(Objects.equals(sMap.get(c), tMap.getOrDefault(c, 0))) {
                return false;
            }
        }

        return true;
    }
}
