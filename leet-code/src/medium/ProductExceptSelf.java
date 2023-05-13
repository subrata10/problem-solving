package medium;

import java.util.Scanner;

public class ProductExceptSelf {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcase = in.nextInt();
        int t = 0;

        while (t++ < testcase) {
            int length = in.nextInt();

            int[] nums = new int[length];

            for (int i = 0; i < length; i++) {
                nums[i] = in.nextInt();
            }

            int[] ans = new int[length];

            int prefix = 1;
            int suffix = 1;

            for (int i = 0; i < nums.length; i++) {
                ans[i] = prefix;
                prefix = prefix * nums[i];
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                ans[i] = ans[i] * suffix;
                suffix = suffix * nums[i];
            }

            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println("\n");
        }

    }
}
