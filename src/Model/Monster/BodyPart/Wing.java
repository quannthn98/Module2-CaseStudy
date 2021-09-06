package Model.Monster.BodyPart;

public class Wing extends BodyPart {
    private final String[] wingType = {"Angel Wing", "Demon Wing", "Bat Wing", "Feather Wing"};
    private String type;
    public Wing(String rarity, String colo, double power, int rarityLevel) {
        super(rarity, colo, power);
        this.type = wingType[rarityLevel];
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return
                "Wing type:'" + type + '\'' +
                super.toString();
    }
}
