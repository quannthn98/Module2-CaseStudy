package Controller;

import Model.Battle.WinRateCalculator;
import Model.Creep.*;
import Model.Monster.MonsterTypes.Monster;

import java.util.ArrayList;
import java.util.List;

public class CreepManagement {
    private static List<Creep> creepsList = new ArrayList<>();
    private static final CreepManagement creepManagement = new CreepManagement();

    private CreepManagement(){};

    public static CreepManagement getInstance(){
        return creepManagement;
    };

    static {
        creepsList.add(new Minion());
        creepsList.add(new Skeleton());
        creepsList.add(new Wizard());
        creepsList.add(new DarkLord());
        creepsList.add(new Titan());
    }

    public List<Creep> getCreepsList() {
        return creepsList;
    }

    public void showCreepForFight(){
        for (int i = 1; i <= creepsList.size(); i++) {
            System.out.println((i) + "" + creepsList.get(i-1));
        }
    }

    public int getTotalNumberCreep(){
        return creepsList.size();
    }

    public void showCreepForFight(Monster monster) {
        CreepManagement creepManagement = CreepManagement.getInstance();
        List<Creep> creeps = creepManagement.getCreepsList();
        int index = 1;
        for (Creep creep : creeps) {
            double winRate = (int) WinRateCalculator.winRateCalculating(monster, creep);
            System.out.println(index + ". " + creep + " - Win rate: " + winRate + "%");
            index++;
        }

    }
}
