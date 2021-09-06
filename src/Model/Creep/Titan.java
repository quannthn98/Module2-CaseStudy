package Model.Creep;

public class Titan extends Creep{
    private final int REWARD = 1000;
    private static final int BASEPOWER = 20000;

    public Titan() {
        super(BASEPOWER);
    }

    public int getREWARD() {
        return REWARD;
    }

    public int getBasePower() {
        return BASEPOWER;
    }

    @Override
    public String toString() {
        return "Titan {" +
                "Power: " + BASEPOWER +
                ", reward: " + REWARD +
                '}';
    }
}
