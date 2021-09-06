package View.Admin;

import Controller.Account.AccountManagement;
import Controller.Monster.MonsterManagement;
import Controller.Tools.AccountValidator;
import View.User.GuestMenu;

import java.util.Scanner;

public class AdminMenu {
    private AccountManagement accountManager = AccountManagement.getAccountManager();
    private MonsterManagement monsterManager = new MonsterManagement();
    public static AccountValidator validator = new AccountValidator();
    public static Scanner scanner = new Scanner(System.in);

    public void run() {
        int option;
        AdminAccountMenu adminAccountMenu = new AdminAccountMenu();
        AdminMonsterMenu adminMonsterMenu = new AdminMonsterMenu();
        AdminTransactionMenu adminTransactionMenu = new AdminTransactionMenu();
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    adminAccountMenu.run();
                    break;
                case 2:
                    adminMonsterMenu.run();
                    break;
                case 3:
                    adminTransactionMenu.run();
                    break;
                case 0:
                    GuestMenu guestMenu = new GuestMenu();
                    guestMenu.run();
                    break;
            }
        } while (option != 0);
    }

    public void menu() {
        System.out.println("1. Account Management");
        System.out.println("2. Monster Management");
        System.out.println("3. Transaction Management");
        System.out.println("0. Logout");
    }
}
