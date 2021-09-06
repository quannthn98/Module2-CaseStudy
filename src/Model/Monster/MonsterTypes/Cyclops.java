package Model.Monster.MonsterTypes;

import Model.Monster.BodyPart.BodyPart;

public class Cyclops extends Monster {
    private final double basePower = 800;
    public Cyclops(BodyPart wing, BodyPart horn, BodyPart armor, BodyPart pendant) {
        super(wing, horn, armor, pendant, 800);
    }

    public double getBasePower() {
        return basePower;
    }

    @Override
    public String toString() {
        return "Cyclops (Common): " + super.toString();
    }
}
