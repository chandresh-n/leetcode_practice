import java.util.Arrays;

// divide and conquor
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        return findMaxSubArray(0, nums.length - 1, nums);
    }

    public static int findMaxSubArray(int left, int right, int[] nums) {
        if (left == right) {
            return nums[left];
        }
        int center = (left + right) / 2;
        int findMaxLeft = findMaxSubArray(left, center, nums);
        int findMaxRight = findMaxSubArray(center + 1, right, nums);
        int maxInclusive = maxInclusive(left, right, center, nums);
        return Math.max(findMaxLeft, Math.max(findMaxRight, maxInclusive));
    }

    public static int maxInclusive(int left, int right, int center, int[] nums) {
        if (left == right) {
            return nums[left];
        }
        int runningSum = 0;
        int maxCenterLeft = Integer.MIN_VALUE;
        for (int i = center; i > left - 1; i--) {
            runningSum = runningSum + nums[i];
            maxCenterLeft = Math.max(maxCenterLeft, runningSum);
        }
        int maxCenterRight = Integer.MIN_VALUE;
        runningSum = 0;
        for (int i = center + 1; i < right + 1; i++) {
            runningSum = runningSum + nums[i];
            maxCenterRight = Math.max(maxCenterRight, runningSum);
        }

        return maxCenterRight + maxCenterLeft;
    }

    // [-2,1,-3,4,-1,2,1,-5,4]
    public static void main(String[] args) {
        int[] intArray = new int[2];
        intArray[0] = -2;
        intArray[1] = -1;
        // intArray[2] = -3;
        // intArray[3] = 4;
        // intArray[4] = -1;
        // intArray[5] = 2;
        // intArray[6] = 1;
        // intArray[7] = -5;
        // intArray[8] = 4;
        int returnValue = MaxSubArray.maxSubArray(intArray);
        System.out.println("solution is:");
        System.out.println(returnValue);
    }
}
