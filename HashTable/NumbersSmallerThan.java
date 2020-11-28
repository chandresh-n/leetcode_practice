import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

// Return the answer in an array.

public class NumbersSmallerThan {
    public static int[] numsSmallerThan(int[] inputNumbers) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] inputNumbersClone = inputNumbers.clone();
        Arrays.sort(inputNumbersClone);
        for (int iterator = 0; iterator < inputNumbersClone.length; iterator++) {
            indexMap.putIfAbsent(inputNumbersClone[iterator], iterator);
        }

        for (int j = 0; j < inputNumbers.length; j++) {
            inputNumbers[j] = indexMap.get(inputNumbers[j]);
        }
        return inputNumbers;
    }

    public static void main(String[] args) {
        int[] intArray = new int[4];
        intArray[0] = 7;
        intArray[1] = 7;
        intArray[2] = 7;
        intArray[3] = 7;
        int[] returnValue = NumbersSmallerThan.numsSmallerThan(intArray);
        System.out.println("solution is:");
        System.out.println(Arrays.toString(returnValue));
    }
}
