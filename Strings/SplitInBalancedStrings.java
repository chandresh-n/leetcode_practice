public class SplitInBalancedStrings {
    public static int numberOfBalancedStrings(String inputString) {
        int balanceCounter = 0;
        int numberOfBalancedStrings = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == 'L') {
                balanceCounter -= 1;
                if (balanceCounter == 0) {
                    numberOfBalancedStrings++;
                }
            } else if (inputString.charAt(i) == 'R') {
                balanceCounter += 1;
                if (balanceCounter == 0) {
                    numberOfBalancedStrings++;
                }
            }

        }
        return numberOfBalancedStrings;
    }

    public static void main(String[] args) {

        int returnValue = SplitInBalancedStrings.numberOfBalancedStrings("RLLLLRRRLR");
        System.out.println("solution is:");
        System.out.println(returnValue);
    }
}
