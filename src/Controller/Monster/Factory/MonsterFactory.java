package Controller.Monster.Factory;

import Model.Monster.BodyPart.BodyPart;
import Controller.Tools.RarityClassifier;
import Controller.Tools.RandomNumberGenerator;
import Model.Monster.MonsterTypes.*;

import java.util.List;

public class MonsterFactory {
    private BodyPartFactory bodyPartFactory = new BodyPartFactory();
    private RandomNumberGenerator rng = RandomNumberGenerator.getRng();

    private static final MonsterFactory monsterFactory = new MonsterFactory();

    private MonsterFactory(){};

    public static MonsterFactory getInstance(){
        return monsterFactory;
    }

    public Monster createNewMonster(){
        Monster newMonster = null;
        List<BodyPart> bodyPartList = bodyPartFactory.createBodyPartList(rng);

        BodyPart wing = bodyPartList.get(0);
        BodyPart horn = bodyPartList.get(1);
        BodyPart armor = bodyPartList.get(2);
        BodyPart pendant = bodyPartList.get(3);

        double monsterRarityNumber = rng.generateNumber();
        int monsterType = RarityClassifier.classifyRarityLevel(monsterRarityNumber);
        switch (monsterType){
            case 0:
                newMonster = new Dragon(wing, horn, armor, pendant);
                break;
            case 1:
                newMonster = new Cerberus(wing, horn, armor, pendant);
                break;
            case 2:
                newMonster = new Dinosaur(wing, horn, armor, pendant);
                break;
            case 3:
                newMonster = new Cyclops(wing, horn, armor, pendant);
                break;
        }
        return newMonster;
    }

}
