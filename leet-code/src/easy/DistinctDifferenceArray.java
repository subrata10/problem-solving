package easy;

import java.util.HashSet;
import java.util.Set;

public class DistinctDifferenceArray {
    public static void main(String[] args) {
        int[] numbers = {3, 2, 3, 4, 2};
        int[] distinct = distinctDifferenceArray(numbers);

        for (int i : distinct) {
            System.out.print(i + " ");
        }
    }


    public static int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int[] results = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            unique.add(nums[i]);
            results[i] = unique.size();
        }

        unique.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] = results[i] - unique.size();
            unique.add(nums[i]);
        }

        return results;
    }


}
