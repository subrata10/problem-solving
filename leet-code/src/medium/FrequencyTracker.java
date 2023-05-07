package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple data structure which holds the frequency of a number and
 * do add number & delete number & check frequency operation.
 */
public class FrequencyTracker {
    Map<Integer, Integer> frequencyMap;
    Map<Integer, Integer> counterMap;

    public FrequencyTracker() {
        frequencyMap = new HashMap<>();
        counterMap = new HashMap<>();
    }

    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
//        frequencyTracker.deleteOne(9);
//        frequencyTracker.deleteOne(8);
//        frequencyTracker.deleteOne(1);
//        frequencyTracker.deleteOne(4);
//
//        System.out.println(frequencyTracker.hasFrequency(2));

        frequencyTracker.add(1);

        frequencyTracker.deleteOne(1);
//
//        System.out.println(frequencyTracker.hasFrequency(1));
//
//        frequencyTracker.deleteOne(10);
//        frequencyTracker.deleteOne(9);
//        frequencyTracker.deleteOne(10);
//
//        System.out.println(frequencyTracker.hasFrequency(1));

//        frequencyTracker.add(1);

        System.out.println(frequencyTracker.hasFrequency(1));

//        frequencyTracker.deleteOne(4);
//
//        System.out.println(frequencyTracker.hasFrequency(1));
//        System.out.println(frequencyTracker.hasFrequency(1));
//
//        frequencyTracker.add(10);
//
//        System.out.println(frequencyTracker.hasFrequency(1));
//
//        frequencyTracker.add(2);
//
//        frequencyTracker.deleteOne(1);
//
//        System.out.println(frequencyTracker.hasFrequency(2));
//
//        frequencyTracker.add(7);
//
//        System.out.println(frequencyTracker.hasFrequency(1));
//        System.out.println(frequencyTracker.hasFrequency(1));
//
//        frequencyTracker.add(7);
    }

    public void add(int number) {
        int freq = frequencyMap.getOrDefault(number, 0);
        frequencyMap.put(number, freq + 1);

        if (freq == 0) { // if there are no frequency present for the given number
            counterMap.put(1, counterMap.getOrDefault(1, 0) + 1);
        } else {
            counterMap.put(freq, counterMap.getOrDefault(freq, 0) - 1);
            counterMap.put(freq + 1, counterMap.getOrDefault(freq + 1, 0) + 1);
        }
    }

    public void deleteOne(int number) {
        int freq = frequencyMap.getOrDefault(number, 0);
        if (freq > 0) {
            frequencyMap.put(number, freq - 1);

            counterMap.put(freq, counterMap.getOrDefault(freq, 0) - 1);
            counterMap.put(freq - 1, counterMap.getOrDefault(freq - 1, 0) + 1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return counterMap.getOrDefault(frequency, 0) > 0;
    }
}
