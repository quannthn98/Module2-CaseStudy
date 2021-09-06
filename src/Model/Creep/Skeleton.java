package Model.Creep;

public class Skeleton extends Creep {
    private final int REWARD = 20;
    private static final int BASEPOWER = 7000;
    public Skeleton() {
        super(BASEPOWER);
    }

    public int getReward() {
        return REWARD;
    }


    public int getBASEPOWER() {
        return BASEPOWER;
    }

    @Override
    public String toString() {
        return "Skeleton {" +
                "Power: " + BASEPOWER +
                ", reward: " + REWARD +
                '}';
    }
}
