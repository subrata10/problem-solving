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
        int i = 0, res = 0;

        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }

        return res;
    }
}
