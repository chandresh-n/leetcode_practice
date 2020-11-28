import java.util.Arrays;

public class TrappingRainwater {
    public static int trap(int[] height) {
        int[] limits = new int[height.length];
        int waterTrapped = 0;
        for (int i = 0; i < height.length; i++) {
            int greatestToTheLeft = 0;
            int greatestToTheRight = 0;
            greatestToTheLeft = findGreatestInRange(0, Math.max(0, i - 1), height[i], height);
            greatestToTheRight = findGreatestInRange(Math.min(height.length - 1, i + 1), (height.length - 1), height[i],
                    height);

            limits[i] = Math.min(greatestToTheLeft, greatestToTheRight);
        }
        System.out.println(Arrays.toString(limits));
        for (int j = 0; j < limits.length; j++) {
            waterTrapped = waterTrapped + Math.max((limits[j] - height[j]), 0);
        }
        return waterTrapped;
    }

    public static int findGreatestInRange(int startRange, int endRange, int inputNumber, int[] height) {
        int greatestNo = inputNumber;
        for (int i = startRange; i <= endRange; i++) {
            if (height[i] > greatestNo) {
                greatestNo = height[i];
            }
        }
        if (greatestNo == inputNumber) {
            return 0;
        }
        return greatestNo;
    }

    public static void main(String[] args) {
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        int[] intArray = new int[12];
        intArray[0] = 0;
        intArray[1] = 1;
        intArray[2] = 0;
        intArray[3] = 2;
        intArray[4] = 1;
        intArray[5] = 0;
        intArray[6] = 1;
        intArray[7] = 3;
        intArray[8] = 2;
        intArray[9] = 1;
        intArray[10] = 2;
        intArray[11] = 1;

        // int[] intArray = new int[6];
        // intArray[0] = 4;
        // intArray[1] = 2;
        // intArray[2] = 0;
        // intArray[3] = 3;
        // intArray[4] = 2;
        // intArray[5] = 5;

        int returnValue = TrappingRainwater.trap(intArray);
        System.out.println("solution is:");
        System.out.println(returnValue);
    }
}
