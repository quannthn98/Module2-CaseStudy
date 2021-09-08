package Controller.Monster;

import Controller.AccountManagement;
import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonsterManagement {
    private static List<Monster> monsterList = new ArrayList<>();
    public static AccountManagement accountManagement = AccountManagement.getAccountManager();

    public MonsterManagement() {
    }

    public void updateMonsterList() {
        List<Account> temp = accountManagement.getAccountList();
        List<Monster> tempMonster = new ArrayList<>();
        for (Account account : temp) {
            tempMonster.addAll(account.getMonsterList());
        }
        monsterList = tempMonster;
    }

    public static void getMonsterListOnRun() {
        List<Account> temp = accountManagement.getAccountList();
        List<Monster> tempMonster = new ArrayList<>();
        for (Account account : temp) {
            tempMonster.addAll(account.getMonsterList());
        }
        monsterList = tempMonster;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public static int getTotalNumberOfMonster() {
        return monsterList.size();
    }

    public void showMonsterList() {
        for (Monster monster : monsterList) {
            System.out.println(monster);
        }
    }

    public void sortByPower() {
        Collections.sort(monsterList);
    }

    public int findMonsterById(int id) {
        int index = -1;
        for (int i = 0; i < monsterList.size(); i++) {
            if (id == monsterList.get(i).getId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void removeMonsterById(int id) {
        int index = findMonsterById(id);
        if (index == -1) {
            System.out.println("Can not found this Model.Monster");
        } else {
            Account containAccount = null;
            Monster targetMonster = null;
            for (Account account : accountManagement.getAccountList()) {
                for (Monster monster : account.getMonsterList()) {
                    if (id == monster.getId()) {
                        targetMonster = monster;
                        containAccount = account;
                        break;
                    }
                }
                if (containAccount != null) {
                    break;
                }
            }
            containAccount.getMonsterList().remove(targetMonster);
        }
    }
}
