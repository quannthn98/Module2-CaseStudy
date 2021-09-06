package Model.Battle;

import Model.Creep.Creep;
import Model.Monster.MonsterTypes.Monster;

public class WinRateCalculator {
    public static double winRateCalculating(Monster monster, Creep creep){
        double ratio = monster.getPower() / creep.getPower();
        double winRate;
        if (ratio > 1) {
            winRate = (ratio - 1) * 50 + 50;
        } else {
            winRate = 50 - (1 - ratio) * 50;
        }
        if (winRate > 100){
            winRate = 100;
        } else if (winRate < 0){
            winRate = 1;
        }
        return winRate;
    }
}

