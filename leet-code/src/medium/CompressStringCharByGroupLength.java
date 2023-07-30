package medium;

/**
 * <a href="https://leetcode.com/problems/string-compression/?envType=study-plan-v2&id=leetcode-75" />
 * <p>
 * Given an array of characters <strong><i>chars</i></strong>, compress it using the following algorithm:
 * Begin with an empty string <strong>s</strong>. For each group of consecutive repeating characters in 'chars':
 *  <ul> If the groups' length is 1, append the character to s </ul>
 *  <ul> Otherwise, append the character followed by the group's length </ul>
 */
public class CompressStringCharByGroupLength {

    public static void main(String[] args) {

        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        CompressStringCharByGroupLength byGroupLength = new CompressStringCharByGroupLength();

        int result = byGroupLength.compress(chars);
        System.out.println(result); // Output: 4 As first 4 character will be ["a", "b", "1", "2"]

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
