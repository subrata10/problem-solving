package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {1, 100, 200, 204, 4, 3, 2, 104, 103, 102, 101, 199, 198, 201, 202, 203};

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            int length = 0;

            if(!set.contains(num-1)) {

                length = length + 1; // for own existence

                while(set.contains(num+1)) {
                    length = length + 1; // for next number existence
                    num = num + 1;
                }

                max = Math.max(max, length);
            }
        }

        System.out.println(max);

    }
}
