import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> pairs = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(i, nums, pairs);
            }
        }
        return pairs;
    }

    public static void twoSum(int i, int[] nums, List<List<Integer>> pairs) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for (int j = i; j < nums.length; j++) {
            int complement = -nums[j] - nums[i];
            if (seen.contains(complement)) {
                pairs.add(Arrays.asList(nums[i], nums[j], complement));
                while (j < nums.length - 1 && nums[j + 1] == nums[j])
                    j++;
            }
            seen.add(nums[j]);
        }
    }

    // [-1,0,1,2,-1,-4]
    public static void main(String[] args) {
        int[] intArray = new int[6];
        intArray[0] = -1;
        intArray[1] = 0;
        intArray[2] = 1;
        intArray[3] = 2;
        intArray[4] = -1;
        intArray[5] = -4;
        // intArray[6] = 1;
        // intArray[7] = -5;
        // intArray[8] = 4;
        List<List<Integer>> returnValue = ThreeSum.threeSum(intArray);
        System.out.println(returnValue);

    }
}