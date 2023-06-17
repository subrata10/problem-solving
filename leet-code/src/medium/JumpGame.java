package medium;

/**
 * You are given an integer array <code>nums</code>. You're initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] testCase1 = {2,3,1,1,4};
        int[] testCase2 = {3,2,1,0,4};
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(testCase2));
    }

    public boolean canJump(int[] nums) {

        if (nums.length <= 1) {
            return true;
        }

        int goal = nums.length - 1; // goal is to reach to the last index so set it here.

        for (int index = nums.length - 1; index >= 0; index--) {
            // value at each index defines the step.
            // value@index + index >= next index. i.e. it can move from left to right.

            if(nums[index] + index >= goal) {
              goal = index; // goal will move left side as it is reachable from the current position.
            }
        }

        return goal == 0;
    }
}
