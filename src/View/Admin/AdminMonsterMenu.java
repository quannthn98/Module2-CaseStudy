package View.Admin;

import Controller.Monster.MonsterManagement;
import Model.Monster.MonsterTypes.Monster;
import View.Admin.AdminMenu;

import java.util.Scanner;

public class AdminMonsterMenu {
    public static Scanner scanner = new Scanner(System.in);
    private MonsterManagement monsterManager = new MonsterManagement();

    public void run() {
        int option;
        do {
            monsterMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    monsterManager.updateMonsterList();
                    monsterManager.showMonsterList();
                    break;
                case 2:
                    monsterManager.sortByPower();
                    monsterManager.showMonsterList();
                    break;
                case 3:
                    findMonsterById();
                    break;
                case 4:
                    removeMonsterById();
                    break;
                case 0:
                    AdminMenu adminMenu = new AdminMenu();
                    adminMenu.run();
                    break;
            }
        } while (option != 0);
    }

    private void removeMonsterById() {
        int id;
        int index;
        System.out.println("Please input id you want to find");
        id = scanner.nextInt();
        index = monsterManager.findMonsterById(id);
        if (index == -1) {
            System.out.println("Can not found this Monster, please try again");
        } else {
            System.out.println("Remove monster successfully");
            monsterManager.removeMonsterById(id);
        }
    }

    private void findMonsterById() {
        int id;
        int index;
        System.out.println("Please input id you want to find");
        id = scanner.nextInt();
        index = monsterManager.findMonsterById(id);
        if (index == -1) {
            System.out.println("Can not found this Monster, please try again");
        } else {
            Monster monster = monsterManager.getMonsterList().get(index);
            System.out.println("Found this monster");
            System.out.println(monster);
        }
    }

    public void monsterMenu() {
        System.out.println("----------------------------");
        System.out.println("1. Show All Monster");
        System.out.println("2. Sort by Power");
        System.out.println("3. Find Monster by Id");
        System.out.println("4. Remove Monster by Id");
        System.out.println("0. Return to Main menu");
        System.out.println("----------------------------");
    }
}
