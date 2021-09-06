package Controller.Tools;

public class RarityClassifier {

    public RarityClassifier() {
    }

    public static int classifyRarityLevel(double result) {
        int rarityLevel = -1;

        if (result < 3) {
            //3% Legend
            rarityLevel = 0;

        } else if (result < 17) {
            //14% Rare
            rarityLevel = 1;

        } else if (result < 50) {
            //33% Uncommon
            rarityLevel = 2;

        } else {
            //50% Common
            rarityLevel = 3;

        }

        return rarityLevel;
    }
}
