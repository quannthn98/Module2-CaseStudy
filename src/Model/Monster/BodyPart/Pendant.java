package Model.Monster.BodyPart;

public class Pendant extends BodyPart {
    private final String[] PENDATETYPE = {"Ruby pendant", "Emeral pendant", "Silver pendant", "Bones pendant"};
    private String type;

    public Pendant(String rarity, String colo, double power, int rarityLevel) {
        super(rarity, colo, power);
        this.type = PENDATETYPE[rarityLevel];
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pendant type: '" + type + '\'' +
                super.toString();
    }
}
