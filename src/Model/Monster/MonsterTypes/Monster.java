package Model.Monster.MonsterTypes;

import Model.Monster.BodyPart.BodyPart;

import java.io.Serializable;

abstract public class Monster implements Serializable, Comparable<Monster> {
    private BodyPart wing, horn, armor, pendant;
    private double power;
    private static final int COST = 50;
    public static int count;
    private int id;

    public Monster(BodyPart wing, BodyPart horn, BodyPart armor, BodyPart pendant, double basePower) {
        id = ++count;
        this.wing = wing;
        this.horn = horn;
        this.armor = armor;
        this.pendant = pendant;
        this.power = basePower + wing.getPower() + horn.getPower() + armor.getPower() + pendant.getPower();
    }

    public int getId() {
        return id;
    }

    public BodyPart getWing() {
        return wing;
    }

    public BodyPart getHorn() {
        return horn;
    }

    public BodyPart getArmor() {
        return armor;
    }

    public BodyPart getPendant() {
        return pendant;
    }

    public static int getCOST() {
        return COST;
    }

    public double getPower() {
        return power;
    }

    @Override
    public String toString() {
        return
                "id: " + id + "; " +
                        "power: " + power + "; " +
                        wing + "; " +
                        horn + "; " +
                        armor + "; " +
                        pendant + "; ";
    }

    @Override
    public int compareTo(Monster o) {
        return (int) (o.getPower() - this.power);
    }
}
