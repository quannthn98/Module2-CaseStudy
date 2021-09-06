package Model.Creep;

public class DarkLord extends Creep {
    private static final int BASEPOWER = 10000;
    private final int REWARD = 100;
    public DarkLord() {
        super(BASEPOWER);
    }

    public int getReward() {
        return REWARD;
    }

    public int getBASEPOWER(){
        return BASEPOWER;
    }

    @Override
    public String toString() {
        return "DarkLord {" +
                "Power: " + BASEPOWER +
                ", reward: " + REWARD +
                '}';
    }
}
