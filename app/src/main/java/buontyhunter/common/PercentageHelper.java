package buontyhunter.common;

import java.util.Random;

public abstract class PercentageHelper {

    private static Random random = new Random();

    public static boolean match(double percentageToMatch) {
        var choose = random.nextDouble(100);
        return choose <= percentageToMatch;
    }

}
