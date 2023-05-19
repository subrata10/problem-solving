package medium;

public class MaximumVowels {

    public static void main(String[] args) {
        String str = "leetcode";
        int windowSize = 2;
        MaximumVowels object = new MaximumVowels();
        System.out.println("Maximum vowel in sub-array of size " + windowSize + " : " + object.maxVowels(str, windowSize));
    }

    public int maxVowels(String s, int k) {
        int windowVowelSum = 0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < k; i++) {
            if (chars[i] == 'a' || 'e' == chars[i] || chars[i] == 'i' || 'o' == chars[i] || chars[i] == 'u') {
                windowVowelSum = windowVowelSum + 1;
            }
        }

        int maxVowel = windowVowelSum;

        for (int i = k; i < chars.length; i++) {
            if (chars[i - k] == 'a' || 'e' == chars[i - k] || chars[i - k] == 'i' || 'o' == chars[i - k] || chars[i - k] == 'u') {
                windowVowelSum = windowVowelSum - 1;
            }

            if (chars[i] == 'a' || 'e' == chars[i] || chars[i] == 'i' || 'o' == chars[i] || chars[i] == 'u') {
                windowVowelSum = windowVowelSum + 1;
            }

            maxVowel = Math.max(maxVowel, windowVowelSum);
        }

        return maxVowel;
    }
}
