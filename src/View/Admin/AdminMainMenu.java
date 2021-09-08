package View.Admin;

import View.User.GuestMenu;

import java.util.Scanner;

public class AdminMainMenu {
    public static Scanner scanner = new Scanner(System.in);

    public void run() {
        int option;
        AdminAccountMenu adminAccountMenu = new AdminAccountMenu();
        AdminMonsterMenu adminMonsterMenu = new AdminMonsterMenu();
        AdminTransactionMenu adminTransactionMenu = new AdminTransactionMenu();
        AdminSellOrderMenu adminSellOrderMenu = new AdminSellOrderMenu();
        GuestMenu guestMenu = new GuestMenu();
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
                case 4:
                    adminSellOrderMenu.run();
                    break;
                case 0:
                    guestMenu.run();
                    break;
            }
        } while (option != 0);
    }

    public void menu() {
        System.out.println("1. Account Management");
        System.out.println("2. Monster Management");
        System.out.println("3. Transaction Management");
        System.out.println("4. Sell order Management");
        System.out.println("0. Logout");
    }
}
