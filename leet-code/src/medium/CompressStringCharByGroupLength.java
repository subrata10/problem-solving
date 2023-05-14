package medium;

/**
 * https://leetcode.com/problems/string-compression/?envType=study-plan-v2&id=leetcode-75
 */
public class CompressStringCharByGroupLength {

    public static void main(String[] args) {

        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        CompressStringCharByGroupLength byGroupLength = new CompressStringCharByGroupLength();
        System.out.println(byGroupLength.compress(chars));
    }

    int compress(char[] chars) {
        int charIndex = 0;
        int newIndex = 0;
        int charLength = chars.length;

        while (charIndex < charLength) {

            int groupLen = 1; // default length of each group

            // when character of current index & next index is equal
            while (charIndex + groupLen < charLength && chars[charIndex] == chars[charIndex + groupLen]) {
                groupLen++;
            }

            chars[newIndex++] = chars[charIndex];

            if (groupLen > 1) {
                for (char c : Integer.toString(groupLen).toCharArray()) {
                    chars[newIndex++] = c;
                }
            }

            charIndex = charIndex + groupLen;
        }

        return newIndex;
    }
}
