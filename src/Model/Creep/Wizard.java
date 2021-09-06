package Model.Creep;

public class Wizard extends Creep {
    private final static int BASEPOWER = 8000;
    private final int REWARD = 50;
    public Wizard() {
        super(BASEPOWER);
    }

    public int getReward() {
        return REWARD;
    }


    public int getBasepower(){
        return BASEPOWER;
    }

    @Override
    public String toString() {
        return "Wizard {" +
                "Power: " + BASEPOWER +
                ", reward: " + REWARD +
                '}';
    }
}
