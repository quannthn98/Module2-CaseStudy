package Controller.UserFunctions;

import Controller.CreepManagement;
import Controller.DataHandler.AccountDataHandler;
import Controller.Tools.OptionValidator;
import Controller.Tools.RandomNumberGenerator;
import Model.Account.Account;
import Model.Battle.Battle;
import Model.Creep.Creep;
import Model.Monster.MonsterTypes.Monster;

import java.util.Scanner;

public class BattleFunctionManagement {
    public static Scanner scanner = new Scanner(System.in);
    private static RandomNumberGenerator rng = RandomNumberGenerator.getRng();
    private CreepManagement creepManagement = CreepManagement.getInstance();


    private Account account;

    public BattleFunctionManagement(Account account) {
        this.account = account;
    }

    public boolean fight(Monster monster, Creep creep) {
        Battle battle = new Battle(monster, creep);
        boolean battleResult = battle.getResult(rng);
        return battleResult;
    }

    public void finalizeBattle(Creep chosenCreep, boolean battleResult) {
        if (battleResult) {
            int reward = chosenCreep.getReward();
            distributeReward(chosenCreep);

            System.out.println("----------------------------");
            System.out.println("----------VICTORY-----------");
            System.out.println("Your monster had defeated the creep, you are rewarded " + reward + " coins");

        } else {
            System.out.println("----------------------------");
            System.out.println("----------DEFEATED----------");
            System.out.println("Your monster had been defeated, try next time");
        }
    }

    public Creep getCreepForBattle(Monster chosenMonster) {
        System.out.println("----------------------------");
        System.out.println("Please pick 1 Creep to fight");

        Creep chosenCreep;
        creepManagement.showCreepForBattle(chosenMonster);
        int index = OptionValidator.getOption(1 , creepManagement.getTotalNumberCreep());

        chosenCreep = creepManagement.getCreepByIndex(index - 1);
        return chosenCreep;
    }

    public void distributeReward(Creep creep) {
        int reward = creep.getReward();
        account.setBalance(account.getBalance() + reward);
        AccountDataHandler.writeToFile();
    }



}
