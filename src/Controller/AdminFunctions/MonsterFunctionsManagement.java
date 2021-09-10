package Controller.AdminFunctions;

import Controller.Monster.MonsterManagement;
import Controller.SellOrderManagement;
import Model.Monster.MonsterTypes.Monster;
import View.Admin.AdminMainMenu;

import java.util.Scanner;

public class MonsterFunctionsManagement {
    public static Scanner scanner = new Scanner(System.in);
    private MonsterManagement monsterManager = new MonsterManagement();
    private SellOrderManagement sellOrderManagement = new SellOrderManagement();

    public void showMonsterList(){
        monsterManager.updateMonsterList();
        monsterManager.showMonsterList();
    }

    public void sortByPower(){
        monsterManager.sortByPower();
        monsterManager.showMonsterList();
    }
    public void removeMonsterById() {
        int id = inputMonsterId();
        int index = getMonsterIndexById(id);
        if (index == -1) {
            System.out.println("Can not found this Monster, please try again");
        } else {
            System.out.println("Remove monster successfully");
            Monster monster = monsterManager.getMonsterList().get(index);
            int sellOrderContainMonsterIndex = sellOrderManagement.findOrderByMonster(monster);
            if (sellOrderContainMonsterIndex != -1){
                sellOrderManagement.removeOrderByMonster(monster);
            }
            monsterManager.removeMonsterById(id);
        }
    }

    public void openMainMenu(){
        AdminMainMenu adminMenu = new AdminMainMenu();
        adminMenu.run();
    }

    public void findMonsterById() {
        int id = inputMonsterId();
        int index = getMonsterIndexById(id);
        if (index == -1) {
            System.out.println("Can not found this Monster, please try again");
        } else {
            Monster monster = monsterManager.getMonsterList().get(index);
            System.out.println("Found this monster");
            System.out.println(monster);
        }
    }

    private int inputMonsterId(){
        System.out.println("Please input Id");
        int id = scanner.nextInt();
        return id;
    }

    private int getMonsterIndexById(int id){
        int index = monsterManager.findMonsterById(id);
        return index;
    }
}
