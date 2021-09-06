package Controller.Monster.Factory;

import Model.Monster.BodyPart.*;
import Controller.Tools.RarityClassifier;
import Controller.Tools.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFactory {
    private final String[] RARITYLEVEL = {"Legend", "Rare", "UnCommon", "Common"};
    private final String[] COLOR = {"Fade", "Blue gem", "Rainbow", "White"};
    private final int[] POWERLEVEL = {3200, 1800, 1000, 700};

    public List<BodyPart> createBodyPartList(RandomNumberGenerator rng) {
        List<BodyPart> bodyPartList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            double rarityNumber = rng.generateNumber();

            int rarityLevel = RarityClassifier.classifyRarityLevel(rarityNumber);
            String rarity = RARITYLEVEL[rarityLevel];
            String color = COLOR[rarityLevel];
            int power = POWERLEVEL[rarityLevel];

            if (i == 0) {

                bodyPartList.add(new Wing(rarity, color, power, rarityLevel));

            } else if (i == 1) {

                bodyPartList.add(new Horn(rarity, color, power, rarityLevel));

            } else if (i == 2) {

                bodyPartList.add(new Armor(rarity, color, power, rarityLevel));

            } else if (i == 3) {

                bodyPartList.add(new Pendant(rarity, color, power, rarityLevel));

            }
        }
        return bodyPartList;
    }
}
