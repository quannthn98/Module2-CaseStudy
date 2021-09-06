package Model.Battle;

import Model.Creep.Creep;
import Model.Monster.MonsterTypes.Monster;
import Controller.Tools.RandomNumberGenerator;

public class Battle {
    private Monster monster;
    private Creep creep;
    private boolean isWin;

    public Battle() {
    }

    public Battle(Monster monster, Creep creep) {
        this.monster = monster;
        this.creep = creep;
    }

    public Monster getMonster() {
        return monster;
    }

    public Creep getCreep() {
        return creep;
    }

    public boolean getResult(RandomNumberGenerator rng) {
        boolean battleResult;
        double winRate = WinRateCalculator.winRateCalculating(monster, creep);
        double result = rng.generateNumber();
        if (result > winRate) {
            battleResult = false;
        } else {
            battleResult = true;
        }
        return battleResult;
    }


}
