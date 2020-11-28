import java.util.HashMap;
import java.util.Map;

// Given an array of integers nums.

// A pair (i,j) is called good if nums[i] == nums[j] and i < j.

// Return the number of good pairs.

public class NumberOfGoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        int numberOfPairs = 0;
        Map<Integer, Integer> charMap = new HashMap<Integer, Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (charMap.containsKey(nums[i])) {
                numberOfPairs = numberOfPairs + charMap.get(nums[i]);
                charMap.put(nums[i], (charMap.get(nums[i]) + 1));
            } else {
                charMap.put(nums[i], 1);
            }
        }
        return numberOfPairs;
    }

    public static void main(String[] args) {
        int[] intArray = new int[4];
        intArray[0] = 1;
        intArray[1] = 1;
        intArray[2] = 1;
        intArray[3] = 1;
        // intArray[4] = 1;
        // intArray[5] = 3;
        int returnValue = NumberOfGoodPairs.numIdenticalPairs(intArray);
        System.out.println("solution is:");
        System.out.println(returnValue);
    }
}
