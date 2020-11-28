import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        int minimumDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {

            int closestTwoSum = closestTwoSum(i, nums, target);
            if (Math.abs(target - (nums[i] + closestTwoSum)) < minimumDiff) {
                minimumDiff = Math.abs(target - (nums[i] + closestTwoSum));
                closestSum = nums[i] + closestTwoSum;
            }
        }
        return closestSum;
    }

    public static int closestTwoSum(int i, int[] nums, int target) {
        int smallestDiff = Integer.MAX_VALUE;
        int j = i + 1;
        int k = nums.length - 1;
        int closestTwoSum = Integer.MAX_VALUE;

        while (j < k) {
            if (Math.abs((target - (nums[i] + nums[j] + nums[k]))) < smallestDiff) {
                smallestDiff = Math.abs((target - (nums[i] + nums[j] + nums[k])));
                closestTwoSum = nums[j] + nums[k];
            }
            if ((nums[i] + nums[j] + nums[k]) < target) {
                j++;
            } else if ((target - (nums[i] + nums[j] + nums[k])) == 0) {
                return nums[j] + nums[k];
            } else {
                k--;
            }

        }
        return closestTwoSum;
    }

    // [-1,2,1,-4]
    public static void main(String[] args) {
        int[] intArray = new int[4];
        intArray[0] = -1;
        intArray[1] = 2;
        intArray[2] = 1;
        intArray[3] = -4;
        // intArray[4] = -1;
        // intArray[5] = -4;
        // intArray[6] = 1;
        // intArray[7] = -5;
        // intArray[8] = 4;
        int returnValue = ThreeSumClosest.threeSumClosest(intArray, 1);
        System.out.println(returnValue);

    }
}
