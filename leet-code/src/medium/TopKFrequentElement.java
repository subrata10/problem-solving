package medium;

import java.sql.Array;
import java.util.*;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">Problem Description</a>
 */
public class TopKFrequentElement {
    public static void main(String[] args) {
//        int[] numbers = {5,5,5,1,1,2,2,2,3, 4};
        int[] numbers = {1};
        int[] res = topKFrequent(numbers, 1);
        System.out.println(res[0]);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length+1];

        for(int num : nums) {
            frequency.merge(num, 1, Integer::sum);
        }

        for(int number: frequency.keySet()) {
            int freq = frequency.get(number);

            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(number);
        }
        /**
         * bucket[0] -> null
         * bucket[1] -> {3,4}
         * bucket[2] -> {1}
         * bucket[3] -> {2,5}
         * bucket[4] -> null
         * .
         * .
         * bucket[10] -> null
         */

        int index = 0;
        int[] result = new int[k];

        for(int i= nums.length; i > 0; i--) {
            if(bucket[i] != null) {

                for(int number: bucket[i]) {
                    result[index++] = number;

                    if(index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
