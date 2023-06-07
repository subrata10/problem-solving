package medium;

import java.util.Arrays;

public class MaxNumberOpKpairs {

    public static void main(String[] args) {
        int[] numbers = {3, 1, 3, 4, 3};
        MaxNumberOpKpairs object = new MaxNumberOpKpairs();
        object.maxOperations(numbers, 6);
    }

    public int maxOperations(int[] nums, int k) {
        int maxOp = 0;
        Arrays.sort(nums); // quick sort using library

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            if (nums[end] >= k) {
                end--;
                continue;
            }

            int sum = nums[start] + nums[end];

            if (sum == k) {
                System.out.println("(" + nums[start] + "," + nums[end] + ")");
                maxOp++;
                start++;
                end--;
            } else if (sum > k) {
                end--;
            } else {
                start++;
            }

        }
        return maxOp;
    }
}
