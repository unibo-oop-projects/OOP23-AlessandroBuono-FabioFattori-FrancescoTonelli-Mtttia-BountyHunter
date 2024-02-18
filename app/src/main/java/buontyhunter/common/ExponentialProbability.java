package buontyhunter.common;

public class ExponentialProbability implements Probability {
    private final double lambda;

    /**
     * Create a new ExponentialProbability with the given lambda 
     * @param lambda the lambda value for the exponential distribution
     */
    public ExponentialProbability(double lambda) {
        this.lambda = lambda;
    }

    /**
     * @return calculate the exponential probability of the given event
     */
    @Override
    public double p(double event) {
        var result = 1 - Math.exp(-lambda * event);
        // AppLogger.getLogger().log("With Lambda =" + lambda + ", and event = " + event
        // + ", probability are =" + result,
        // LogType.COMMON);
        return result;
    }
}
