package medium;

/**
 * Given a binary array nums and an integer k,
 * return the maximum number of consecutive 1's in the array
 * if you can flip at most k 0's.
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] binaryNumbers = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        // input 1: 0, 0, 1, 1, 0, 0, 1, 1,1,0,1,1,0,0,0,1,1,1,1, k = 3
        // input 2: 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, k = 2
        int maxFlipAllow = 3;

        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
        System.out.println("Max value : " + obj.longestOnes(binaryNumbers, maxFlipAllow));
    }

    public int longestOnes(int[] nums, int k) {
        int maxOnes = 0;
        int currentOnesCount = 0;
        int zeroCount = 0;
        int leftIndex = 0;

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {

            if (nums[currentIndex] == 0) {
                zeroCount++;
            }
            // whenever size of zero exceed the allowed value of flipping zero to one
            // left index will move forward by 1
            if (zeroCount > k) {

                // if left index value is 0 then it will maintain the maximum count of zero.
                if (nums[leftIndex] == 0) {
                    zeroCount = zeroCount - 1;
                }
                leftIndex++;
            }

            // when all the allowed zero are considered, or it is less than permitted flip
            // then every time the maximum count of one (1) are calculated.
            if (zeroCount <= k) {
                currentOnesCount = currentIndex - leftIndex + 1;
                maxOnes = Math.max(maxOnes, currentOnesCount);
            }

        }

        return maxOnes;
    }
}
