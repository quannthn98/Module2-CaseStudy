package View.Admin;

import Controller.AdminFunctions.AdminMonsterManagementFunctions;

import java.util.Scanner;

public class AdminMonsterMenu {
    public static Scanner scanner = new Scanner(System.in);
    AdminMonsterManagementFunctions adminMonsterManagementFunctions = new AdminMonsterManagementFunctions();

    public void run() {
        int option;
        do {
            monsterMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    adminMonsterManagementFunctions.showMonsterList();
                    break;
                case 2:
                    adminMonsterManagementFunctions.sortByPower();
                    break;
                case 3:
                    adminMonsterManagementFunctions.findMonsterById();
                    break;
                case 4:
                    adminMonsterManagementFunctions.removeMonsterById();
                    break;
                case 0:
                    adminMonsterManagementFunctions.openMainMenu();
                    break;
            }
        } while (option != 0);
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
