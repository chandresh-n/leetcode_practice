
import java.util.Arrays;

public class TrappingRainwaterFaster {
    public static int trap(int[] height) {
        int[] limits = new int[height.length];
        int[] maximumsToLeft = new int[height.length];
        int[] maximumsToRight = new int[height.length];

        int waterTrapped = 0;
        int currentGreatest = 0;
        for (int i = 0; i < height.length; i++) {
            maximumsToLeft[i] = currentGreatest;
            if (height[i] > currentGreatest) {
                currentGreatest = height[i];
            }
        }
        currentGreatest = 0;
        for (int i = height.length - 1; i > 0; i--) {
            maximumsToRight[i] = currentGreatest;
            if (height[i] > currentGreatest) {
                currentGreatest = height[i];
            }
            limits[i] = Math.min(maximumsToRight[i], maximumsToLeft[i]);
        }
        System.out.println(Arrays.toString(maximumsToLeft));
        System.out.println(Arrays.toString(maximumsToRight));

        for (int j = 0; j < limits.length; j++) {
            waterTrapped = waterTrapped + Math.max((limits[j] - height[j]), 0);
        }
        return waterTrapped;

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

        int returnValue = TrappingRainwaterFaster.trap(intArray);
        System.out.println("solution is:");
        System.out.println(returnValue);
    }
}
