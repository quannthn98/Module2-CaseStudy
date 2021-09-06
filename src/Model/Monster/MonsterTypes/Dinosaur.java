package Model.Monster.MonsterTypes;

import Model.Monster.BodyPart.BodyPart;

public class Dinosaur extends Monster {
    private final double basePower = 1500;
    public Dinosaur(BodyPart wing, BodyPart horn, BodyPart armor, BodyPart pendant) {
        super(wing, horn, armor, pendant, 1500);
    }

    public double getBasePower() {
        return basePower;
    }

    @Override
    public String toString() {
        return "Dinosaur (Uncommon): " +
                super.toString();
    }
}
