package medium;

/**
 * https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/description/
 * In this problem, it is not defined with much more information. After reading and doing this program
 * I have figured out the problem description and giving here.
 *
 * if there is a number say 555
 * then x and y will be two number we have to build
 * where x will be maximum number & y will be minimum number
 * now to make a maximum number we have to pick a digit between 0<=digit<=9
 * Now how to make a maximum number:
 *  replace the first non-maximum digit by maximum digit from a given range of digit which is 9
 *  in this example 5 will be replaced by 9 and that same digit if occurs in next sequence of the number
 *  there also it will be replaced by same 9 (or maximum digit). The length of the maximum number will be always
 *  same length of the given number
 *
 *  Now how to make a minimum number
 *      To make a minimum number again iterate from left most place and check whether there is any 0 or 1.
 *      As per the constraint, no number will be given which starts with 0 so, it will start by 1
 *      now if first digit of the number is 1 then skip it and move to next digit. Now if next digit is 0 or 1
 *      then skip and move ahead if it encounters next digit which is not equal to 0 or 1 then replaced with 0 and
 *      replaced other places also by 0 wherever it occurs in the sequence of the number.
 *
 */
public class MaxDifference {

    public static void main(String[] args) {
        int num = 1101057;
        String s = String.valueOf(num);

        String desc = "9876543210";
        String asc = "123456789";

        String max = String.valueOf(num);
        String min = String.valueOf(num);

        for (int i = 0; i < s.length(); i++) {
            if ('9' == s.charAt(i)) {
                continue;
            } else {
                max = s.replaceAll(String.valueOf(s.charAt(i)), "9");
                System.out.println(max);
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if ('1' == s.charAt(i)) {
                continue;
            } else {
                if (i == 0) {
                    min = s.replaceAll(String.valueOf(s.charAt(i)), "1");
                } else if (i > 0 && s.charAt(i) == '0') {
                    continue;
                } else {
                    min = s.replaceAll(String.valueOf(s.charAt(i)), "0");
                }
                System.out.println(min);
                break;
            }
        }
        int expected = 8808050;
        int result = Integer.parseInt(max) - Integer.parseInt(min);
        System.out.println("Given number: " + num);
        System.out.println("Difference: \t" + result);
        System.out.println("Expected: \t" + expected);

    }
}
