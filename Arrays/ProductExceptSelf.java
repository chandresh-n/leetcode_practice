import java.util.Arrays;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        int iterator;
        int runningProduct = 1;
        for (iterator = 1; iterator < nums.length; iterator++) {

            leftProduct[iterator] = runningProduct * nums[iterator - 1];
            runningProduct = runningProduct * nums[iterator - 1];
        }
        product[nums.length - 1] = leftProduct[nums.length - 1];
        runningProduct = 1;
        for (iterator = nums.length - 2; iterator >= 0; iterator--) {
            product[iterator] = leftProduct[iterator] * (runningProduct * nums[iterator + 1]);
            runningProduct = runningProduct * nums[iterator + 1];
        }
        return product;
    }

    public static void main(String[] args) {
        int[] intArray = new int[4];
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;
        intArray[3] = 4;
        // intArray[4] = -1;
        // intArray[5] = -4;
        // intArray[6] = 1;
        // intArray[7] = -5;
        // intArray[8] = 4;
        int[] returnValue = ProductExceptSelf.productExceptSelf(intArray);
        System.out.println(Arrays.toString(returnValue));

    }
}
