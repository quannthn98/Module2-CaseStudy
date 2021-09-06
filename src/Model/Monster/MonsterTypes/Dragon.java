package Model.Monster.MonsterTypes;

import Model.Monster.BodyPart.BodyPart;

public class Dragon extends Monster {
    private final double basePower = 5000;

    public Dragon(BodyPart wing, BodyPart horn, BodyPart armor, BodyPart pendant) {
        super(wing, horn, armor, pendant, 5000);
    }

    public double getBasePower() {
        return basePower;
    }

    @Override
    public String toString() {
        return "Dragon (Legend): " + super.toString();
    }
}
