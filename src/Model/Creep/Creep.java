package Model.Creep;

abstract public class Creep {
    private int power;
    private int reward;

    public Creep(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public int getReward() {
        return reward;
    }
}
