package medium;

import java.util.*;
import java.util.stream.Collectors;

public class TwoStringClosed {

    public static void main(String[] args) {
        String str1 = "aaabbbbccddeeeeefffff";
        String str2 = "aaaaabbcccdddeeeeffff";

/**     String aToz = "abcdefghijklmnopqrstuvwxyz";
 char[] aTozCharArr = aToz.toCharArray();

 for (int i = 0; i < aTozCharArr.length; i++) {
 System.out.println(Integer.valueOf(aTozCharArr[i]));
 }

 */
        TwoStringClosed obj = new TwoStringClosed();
        System.out.println("Are two string close? " + obj.closeString(str1, str2));
//        System.out.println("Are two strings closed? " + obj.closeStringsBruteForce(str1, str2));
    }

    public boolean closeString(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] word1CharFreq = countChar(word1.toCharArray());
        int[] word2CharFreq = countChar(word2.toCharArray());

        for (int i = 0; i < word1CharFreq.length; i++) {
            // checking any character is present either of the array and not present in alternate one.
            if (word1CharFreq[i] != 0 && word2CharFreq[i] == 0 || word1CharFreq[i] == 0 && word2CharFreq[i] != 0) {
                return false;
            }
        }
        // sort the value of the frequency of each character by internal double pivot quick sort
        Arrays.sort(word1CharFreq);
        Arrays.sort(word2CharFreq);

        /**
         * Returns true if the two specified arrays of ints are equal to one another.
         * Two arrays are considered equal if both arrays contain the same number of elements,
         * and all corresponding pairs of elements in the two arrays are equal.
         * In other words, two arrays are equal if they contain the same elements in the same order.
         * Also, two array references are considered equal if both are null.
         */
        return Arrays.equals(word1CharFreq, word2CharFreq);
    }

    /**
     * Found each character frequency by converting each character value in integer
     * and increase the value of that index value whenever each character will occur.
     *
     * @param chars - given word in array form of character type
     * @return return the integer array where each index will define the characters
     * and their value defines the corresponding character frequency.
     */
    private int[] countChar(char[] chars) {
        int[] charFreq = new int[26];

        for (char c : chars) {
            charFreq['z' - c] = charFreq['z' - c] + 1;
        }

        return charFreq;
    }

    public boolean closeStringsBruteForce(String word1, String word2) {

        // whether length of the two strings are equal or not.
        if (word1.length() != word2.length()) {
            return false;
        }

        Set<Character> uniqueChar1 = new HashSet<>();
        Set<Character> uniqueChar2 = new HashSet<>();
        char[] word1Char = word1.toCharArray();
        char[] word2Char = word2.toCharArray();

        for (char c : word1Char) {
            uniqueChar1.add(c);
        }
        List<Character> char1List = uniqueChar1.stream().sorted().collect(Collectors.toList());

        for (char c : word2Char) {
            uniqueChar2.add(c);
        }
        List<Character> char2List = uniqueChar2.stream().sorted().collect(Collectors.toList());

        // after sorting of unique characters of the given two strings
        // length of those unique characters are same or not
        if (char1List.size() != char2List.size()) {
            return false;
        }

        for (int i = 0; i < char1List.size(); i++) {
            // checking the all unique characters from two given strings are same or not.
            if (!(char1List.get(i) == (char2List.get(i)))) {
                return false;
            }
        }

        Map<Character, Integer> str1Freq = new LinkedHashMap<>();
        for (int i = 0; i < word1Char.length; i++) {
            char key = word1Char[i];
            int val = str1Freq.getOrDefault(key, 0);
            str1Freq.put(key, val + 1);
        }

        Map<Character, Integer> str2Freq = new LinkedHashMap<>();
        for (int i = 0; i < word2Char.length; i++) {
            char key = word2Char[i];
            int val = str2Freq.getOrDefault(key, 0);
            str2Freq.put(key, val + 1);
        }

        List<Integer> value1 = str1Freq.values().stream().sorted().collect(Collectors.toList());
        List<Integer> value2 = str2Freq.values().stream().sorted().collect(Collectors.toList());

        if (value1.equals(value2)) {
            return true;
        }

        return false;

    }

}
