package Model.Monster.MonsterTypes;

import Model.Monster.BodyPart.BodyPart;

public class Cerberus  extends Monster {
    private final double basePower = 3500;

    public Cerberus(BodyPart wing, BodyPart horn, BodyPart armor, BodyPart pendant) {
        super(wing, horn, armor, pendant, 3500);
    }

    public double getBasePower() {
        return basePower;
    }

    @Override
    public String toString() {
        return "Cerberus (Rare): " + super.toString();
    }
}
