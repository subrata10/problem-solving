package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Description:
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
 */
public class GreatestCandies {

    public static void main(String[] args) {
        int[] candies = {};
        int extraCandies = 3;
        List<Boolean> result = kidsWithCandies(candies, extraCandies);
        System.out.println(result);

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answers = new ArrayList<>(candies.length);
        int maxCandyValue = findMax(candies);

        for(int i=0; i<candies.length; i++) {
            if(candies[i] + extraCandies >= maxCandyValue) {
                answers.add(true);
            }
            else {
                answers.add(false);
            }
        }

        return answers;
    }

    static int findMax(int[] arr) {
        int max = -1;
        for(int number : arr) {
            if(max < number) {
                max = number;
            }
        }

        return max;
    }
}
