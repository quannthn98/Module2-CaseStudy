package Model.Monster.BodyPart;

public class Armor extends BodyPart {
   private final String[] ARMORTYPE = {"Diamond Armor", "Platinum Armor", "Gold Armor", "Bronze Armor" };
   private String type;
    public Armor(String rarity, String colo, double power, int rarityLevel) {
        super(rarity, colo, power);
        this.type = ARMORTYPE[rarityLevel];
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return " Armor type: '" + this.getType() + '\'' +
                super.toString();
    }
}
