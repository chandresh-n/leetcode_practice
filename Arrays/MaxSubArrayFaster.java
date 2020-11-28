public class MaxSubArrayFaster {
    public static int maxSubArray(int[] nums) {
        int currentGreatestSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentGreatestSum = Math.max(nums[i], currentGreatestSum + nums[i]);
            greatestSum = Math.max(greatestSum, currentGreatestSum);
        }
        return greatestSum;
    }

    // [-2,1,-3,4,-1,2,1,-5,4]
    public static void main(String[] args) {
        int[] intArray = new int[9];
        intArray[0] = -2;
        intArray[1] = 1;
        intArray[2] = -3;
        intArray[3] = 4;
        intArray[4] = -1;
        intArray[5] = 2;
        intArray[6] = 1;
        intArray[7] = -5;
        intArray[8] = 4;
        int returnValue = MaxSubArrayFaster.maxSubArray(intArray);
        System.out.println("solution is:");
        System.out.println(returnValue);
    }
}
