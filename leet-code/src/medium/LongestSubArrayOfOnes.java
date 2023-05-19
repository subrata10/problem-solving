package medium;

/**
 * Given a binary array nums, you should delete one element from it.
 * <p>
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array.
 * Return 0 if there is no such subarray.
 */
public class LongestSubArrayOfOnes {

    public static void main(String[] args) {
        int[] numbers = {0, 0, 0};
        // i/p -> {0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1};
        LongestSubArrayOfOnes subArrayOfOnes = new LongestSubArrayOfOnes();
        System.out.println("Max of one: " + subArrayOfOnes.longestSubarray(numbers));
    }

    public int longestSubarray(int[] nums) {
        int maxOnesLength = 0;
        int zeroCount = 0;
        int leftIndex = 0;
        int zeroIndex = -1;
        int currentIndex = 0;

        for (; currentIndex < nums.length; currentIndex++) {
            if (nums[currentIndex] == 0) {
                zeroCount++;

                if (zeroCount > 1) {
                    int currentSize = currentIndex - leftIndex - 1;
                    maxOnesLength = Math.max(maxOnesLength, currentSize);
                    leftIndex = zeroIndex + 1;
                }

                zeroIndex = currentIndex;
            }
        }

        int currentSize = currentIndex - leftIndex - 1;
        maxOnesLength = Math.max(maxOnesLength, currentSize);

        return maxOnesLength;
    }
}
