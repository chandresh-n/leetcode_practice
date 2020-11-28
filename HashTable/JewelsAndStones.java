
import java.util.ArrayList;
import java.util.List;

// You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

// The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

public class JewelsAndStones {
    public static int numOfJewelsInStones(String jewels, String stones) {
        int numberOfJewels = 0;
        int iterator = 0;
        List charMap = new ArrayList<Character>(jewels.length());
        for (iterator = 0; iterator < jewels.length(); iterator++) {
            charMap.add(jewels.charAt(iterator));
        }
        for (iterator = 0; iterator < stones.length(); iterator++) {
            if (charMap.contains(stones.charAt(iterator))) {
                numberOfJewels++;
            }
        }
        return numberOfJewels;
    }

    public static void main(String[] args) {
        int returnValue = JewelsAndStones.numOfJewelsInStones("aA", "aAAbbbb");
        System.out.println("solution is:");
        System.out.println(returnValue);
    }
}
