
// Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.

// For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them. Notice that multiple kids can have the greatest number of candies.
import java.util.List;
import java.util.ArrayList;

class KidsCandySolution {
    static int maxCandiesWithASingleKid = 0;

    public static List<Boolean> canHaveMaxCandies(int[] candies, int extraCandies) {
        return tryMaxCandiesRecursive(candies, extraCandies, new ArrayList<>(), candies.length - 1);
    }

    public static List<Boolean> tryMaxCandiesRecursive(int[] candies, int extraCandies, List<Boolean> returnList,
            int index) {
        if (index < 0) {
            return returnList;
        }
        maxCandiesWithASingleKid = Math.max(maxCandiesWithASingleKid, candies[index]);

        tryMaxCandiesRecursive(candies, extraCandies, returnList, index - 1);
        returnList.add((candies[index] + extraCandies) >= maxCandiesWithASingleKid);
        return returnList;
    }

    public static void main(String[] args) {
        int[] intArray = new int[5];
        intArray[0] = 4;
        intArray[1] = 2;
        intArray[2] = 1;
        intArray[3] = 1;
        intArray[4] = 2;
        List<Boolean> returnValue = KidsCandySolution.canHaveMaxCandies(intArray, 1);
        System.out.println("solution is:");
        System.out.println(returnValue);
    }
}