package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description:
 * <a href="https://leetcode.com/problems/count-good-meals/description/"/>
 */
public class GoodMealCount {

    public static void main(String[] args) {
        int[] meals = {1, 3, 5, 7, 9};

        GoodMealCount mealCount = new GoodMealCount();
        System.out.println("Total meal pair : " + mealCount.countPairs(meals));
    }

    public int countPairs(int[] deliciousness) {
        int mod = 1000000007;

        Map<Integer, Integer> hashMap = new HashMap<>();
        long result = 0;

        for (int number : deliciousness) { // outer loop

            int power = 1;

            for (int j = 0; j < 22; j++) { // inner loop
                // 1 is present in the key then 2^2= 4 - 3 = 1 is present
                // other way around map will contain number and new number will be deducted from the power of 2
                // check whether the another number (e.g 1) is present in the table.
                if (hashMap.containsKey(power - number)) {
                    result = result + hashMap.get(power - number);
                    result = result % mod;
                }

                power = power * 2;
            }

            // keeping the frequency of the number
            hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);
        }

        return (int) result;
    }


}
