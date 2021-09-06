package Model.Monster.BodyPart;

import java.io.Serializable;

abstract public class BodyPart  implements Serializable {
    private String rarity, colo;
    private double power;

    public BodyPart() {
    }

    public BodyPart(String rarity, String colo, double power) {
        this.rarity = rarity;
        this.colo = colo;
        this.power = power;
    }

    public String getRarity() {
        return rarity;
    }

    public String getColo() {
        return colo;
    }

    public double getPower() {
        return power;
    }

    @Override
    public String toString() {
        return ", rarity: '" + this.getRarity() + '\''+
                ", colo: '" + this.getColo() + '\'' +
                ", power: " + this.getPower();
    }
}
