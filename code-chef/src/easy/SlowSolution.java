package easy;

import java.util.Scanner;

/**
 * <a href="https://www.codechef.com/problems/SLOWSOLN?tab=statement">Problem Description</a>
 */
public class SlowSolution {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int testcase = in.nextInt();

        for (int t = 0; t < testcase; t++) {

            int maxT = in.nextInt();
            int maxN = in.nextInt();
            int sumN = in.nextInt();

            int quotient = sumN / maxN;

            if (quotient >= maxT) { // if more than the given test case
                System.out.println(maxT * maxN * maxN);
            } else {
                int remainder = sumN % maxN;
                System.out.println(maxN * maxN * quotient + remainder * remainder);
            }
        }
    }
}
