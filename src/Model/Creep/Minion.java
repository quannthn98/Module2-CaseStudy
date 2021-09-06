package Model.Creep;

public class Minion extends Creep {
    private final int REWARD = 10;
    private static final int BASEPOWER = 5500;

    public Minion() {
        super(BASEPOWER);
    }

    public int getBasePower() {
        return BASEPOWER;
    }

    public int getReward() {
        return REWARD;
    }

    @Override
    public String toString() {
        return "Minion {" +
                "Power: " + BASEPOWER +
                ", reward: " + REWARD +
                '}';
    }
}
