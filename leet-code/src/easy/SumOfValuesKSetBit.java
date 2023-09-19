package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfValuesKSetBit {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        int[] numbers = {4,3,2,1};
        int[] nums = arr.stream().mapToInt(i->i).toArray();
        int k = 2;
        int sum = 0;
        for(int i=0; i< numbers.length; i++) {
            if(k == Integer.bitCount(i) ) {
                sum += numbers[i];
            }
        }
        System.out.println(sum);
    }
}
