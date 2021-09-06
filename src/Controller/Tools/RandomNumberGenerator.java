package Controller.Tools;

public class RandomNumberGenerator {

    private static final RandomNumberGenerator rng = new RandomNumberGenerator();

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator getRng(){
        return rng;
    }

    public double generateNumber() {
        double result = Math.random() * 100;
        return result;
    }
}
