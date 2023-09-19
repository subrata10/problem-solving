package alg.slidingwindow;

/**
 * Q: Given an array of Integers of size n.
 * Calculate the maximum sum of 'k' consecutive elements in the array.
 */
public class MaxSumKConElements {

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;

        MaxSumKConElements elements = new MaxSumKConElements();
        System.out.println("Max sum: " + elements.maxSum(array, k));
    }

    int maxSum(int[] arr, int windowSize) {
        int l = arr.length;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) { // first window sum
            windowSum = windowSum + arr[i];
        }
        int maxSum = windowSum;

        for (int i = windowSize; i < l; i++) {
            // first element from the start will discard from previous window sum i.e (i-windowSize)
            // next element of each window will add to current window sum i.e. i
            windowSum = windowSum + arr[i] - arr[i - windowSize];
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }
}
