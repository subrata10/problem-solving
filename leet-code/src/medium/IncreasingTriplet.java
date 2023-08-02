package medium;

import java.util.Scanner;

/**
 * <a href="https://leetcode.com/problems/increasing-triplet-subsequence/">Problem link</a>
 * <br/>
 * <br/>
 * Given an integer array <code>nums</code>,
 * return true, if there exists a triple of indices (i, j, k)
 * <br>
 * such that ( i < j < k ) &
 * <br>
 * nums[i] < nums[j] < nums[k]
 * if no such indices exists, return false.
 */
public class IncreasingTriplet {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();

        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = input.nextInt();
        }

        IncreasingTriplet object = new IncreasingTriplet();
        System.out.println(object.increasingTriplet(nums));

        // Optimal approach
        System.out.println(object.increasingTripletV1(nums));

    }

    public boolean increasingTripletV1(int[] nums) {
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;

        for(int number: nums) {
            if (number <= max1) {
                max1 = number;
            }
            else if(number <= max2) {
                max2 = number;
            }
            else {
                return true;
            }
        }

        return false;
    }

    public boolean increasingTriplet(int[] nums) {

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] < nums[i + 1] && nums[i + 1] < nums[i + 2]) {
                return true;
            }
        }
        return false;
    }
}
