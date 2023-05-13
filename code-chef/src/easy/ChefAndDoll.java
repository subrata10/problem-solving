package easy;

import java.util.Scanner;

/**
 * The solution is built basis on XOR properties.
 * 1. commutativity (x ^ y = y ^ x)
 * 2. associativity [x ^ (y ^ z) = (x ^ y) ^ z]
 * 3. identity element [x ^ 0 = x]
 * 4. self-inverse [ x ^ x = 0]
 */
public class ChefAndDoll {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcase = in.nextInt(); // number of test case

        int t = 0;

        while (t++ < testcase) {
            int dollNumber = in.nextInt(); // number of dolls
            int dollType = 0;

            for (int i = 0; i < dollNumber; i++) {
                dollType ^= in.nextInt();
            }

            System.out.println(dollType);
        }
    }
}
