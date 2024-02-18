package buontyhunter.common;

import buontyhunter.common.Logger.AppLogger;
import buontyhunter.common.Logger.LogType;

public class ExponentialProbability implements Probability {
    private final double lambda;

    public ExponentialProbability(double lambda) {
        this.lambda = lambda;
    }

    @Override
    public double p(double event) {
        var result = 1 - Math.exp(-lambda * event);
        // AppLogger.getLogger().log("With Lambda =" + lambda + ", and event = " + event
        // + ", probability are =" + result,
        // LogType.COMMON);
        return result;
    }
}
