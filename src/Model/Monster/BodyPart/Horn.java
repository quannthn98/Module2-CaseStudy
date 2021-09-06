package Model.Monster.BodyPart;

public class Horn extends BodyPart {
    private final String[] HORNTYPE = {"Magic horn", "Fire Horn", "Broken Horn", "Bone Horn"};
    private String type;

    public Horn(String rarity, String colo, double power, int rarityLevel) {
        super(rarity, colo, power);
        this.type = HORNTYPE[rarityLevel];
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Horn type: '" + type + '\'' +
                super.toString();
    }
}
