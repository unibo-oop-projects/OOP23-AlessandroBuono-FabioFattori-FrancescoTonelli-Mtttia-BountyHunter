package buontyhunter.common;

import java.util.Random;

public abstract class PercentageHelper {

    private static Random random = new Random();

    /**
     * @param percentageToMatch the percentage to match
     * @return true if the random number is less than or equal to the given percentage
     */
    public static boolean match(double percentageToMatch) {
        var choose = random.nextInt(100);
        return choose <= percentageToMatch;
    }

}
