// Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
// package BitManipulation;

public class StepsToReduceToZero {
    public static int numberOfSteps(int inputNumber) {
        int steps = 0;
        while (inputNumber > 0) {
            steps = steps + ((inputNumber & 1) == 0 ? 1 : 2);
            inputNumber = inputNumber >> 1;
        }
        return Math.max(steps - 1, 0);

    }

    public static void main(String[] args) {
        int returnValue = StepsToReduceToZero.numberOfSteps(1);
        System.out.println("solution is:");
        System.out.println(returnValue);
    }
}
