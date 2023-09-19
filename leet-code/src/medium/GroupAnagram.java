package medium;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/description/">Problem Description</a>
 */
public class GroupAnagram {
    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strings));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for(String word : strs) {
            char[] chars = word.toCharArray(); // convert into character array
            Arrays.sort(chars); // sort the characters
            String sortedWord = new String(chars); // build the characters into string

            if(!result.containsKey(sortedWord)) { // check the string is present in Map
                result.put(sortedWord, new ArrayList<>());
                // add blank Array List when sorted word is not present in Map
            }

            // retrieve the existing key from Map and add the actual word into corresponding list
            result.get(sortedWord).add(word);
        }

        // convert map values which is list of string and add it to new list i.e. List<List<String>
        return new ArrayList<>(result.values());
    }
}
