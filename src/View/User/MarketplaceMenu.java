package View.User;

import Controller.UserFunctions.MarketFunctionManagement;
import Model.Account.Account;

import java.util.Scanner;

public class MarketplaceMenu {
    public static Scanner scanner = new Scanner(System.in);
    private MarketFunctionManagement marketFunctionManagement = new MarketFunctionManagement();

    public void run(Account account) {
        int option;
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    marketFunctionManagement.buyMonster(account);
                    break;
                case 2:
                    marketFunctionManagement.sellMonster(account);
                    break;
                case 3:
                    marketFunctionManagement.showAllSellOrder();
                    break;
                case 4:
                    marketFunctionManagement.showMySellOrder(account);
                    break;
                case 5:
                    marketFunctionManagement.setOrderPriceByAccount(account);
                    break;
                case 6:
                    marketFunctionManagement.removeOrderByAccount(account);
                    break;
                case 0:
                    UserMenu userMenu = new UserMenu(account);
                    userMenu.run();
                    break;
            }
        } while (option != 0);

    }

    public void menu() {
        System.out.println("----------------------------");
        System.out.println("Welcome to Marketplace");
        System.out.println("1. Buy Monster");
        System.out.println("2. Sell Monster");
        System.out.println("3. Show All Monster Sell order");
        System.out.println("4. Show my Sell order");
        System.out.println("5. Set my Order price");
        System.out.println("6. Cancel my sell Order");
        System.out.println("0. Back to user menu");
        System.out.println("----------------------------");
        System.out.println("Please input your option");
    }
}
