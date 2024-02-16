package buontyhunter.common;

public class ExponentialProbability implements Probability {
    private final double lambda;

    public ExponentialProbability(double lambda) {
        this.lambda = lambda;
    }

    @Override
    public double p(double event) {
        return lambda * Math.exp(-lambda * event);
    }
}
