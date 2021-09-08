package View.Admin;

import Controller.Account.AccountManagement;
import Controller.AdminFunctions.AdminSellOrderManagementFunctions;
import Controller.SellOrderManagement;

import java.util.Scanner;

public class AdminSellOrderMenu {
    public static Scanner scanner = new Scanner(System.in);
    private AdminSellOrderManagementFunctions adminSellOrderManagementFunctions = new AdminSellOrderManagementFunctions();

    public void run() {
        int option;
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    adminSellOrderManagementFunctions.showAllSellOrder();
                    break;
                case 2:
                    adminSellOrderManagementFunctions.showSellOrderByUsername();
                    break;
                case 3:
                    adminSellOrderManagementFunctions.removeOrderBySelect();
                    break;
                case 4:
                    adminSellOrderManagementFunctions.changeOrderPrice();
                    break;
                case 5:
                    adminSellOrderManagementFunctions.removeAllSellOrder();
                    break;
                case 6:
                    adminSellOrderManagementFunctions.sortByPrice();
                    break;
                case 0:
                    adminSellOrderManagementFunctions.openMainMenu();
                    break;
            }
        } while (option != 0);
    }

    public void menu() {
        System.out.println("----------------------------");
        System.out.println("1. Show all Sell Order");
        System.out.println("2. Show sell order by username");
        System.out.println("3. Remove 1 sell order");
        System.out.println("4. Edit sell order price");
        System.out.println("5. Remove All Sell order");
        System.out.println("6. Short order by Price");
        System.out.println("0. Back to admin menu");
        System.out.println("----------------------------");
        System.out.println("Please input your option");

    }
}
