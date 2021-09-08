package View.Admin;

import Controller.Account.AccountManagement;
import Controller.SellOrderManagement;
import Model.Account.Account;
import Model.SellOrder;

import java.util.Scanner;

public class AdminSellOrderMenu {
    public static Scanner scanner = new Scanner(System.in);
    private static SellOrderManagement sellOrderManagement = new SellOrderManagement();
    private static AccountManagement accountManagement = AccountManagement.getAccountManager();

    public void run() {
        int option;
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    sellOrderManagement.showAllSellOrder();
                    break;
                case 2:
                    showSellOrderByUsername();
                    break;
                case 3:
                    removeOrderById();
                    int orderIndex;
                    break;
                case 4:
                    changeOrderPrice();
                    break;
                case 5:
                    sellOrderManagement.removeAllSellOrder();
                    System.out.println("Remove all order successfully");
                    break;
                case 6:
                    sellOrderManagement.sortByPrice();
                    break;
                case 0:
                    AdminMenu adminMenu = new AdminMenu();
                    adminMenu.run();
                    break;
            }
        } while (option != 0);
    }

    private void changeOrderPrice() {
        sellOrderManagement.showAllSellOrder();
        System.out.println("Please input your option");

        int orderIndex = scanner.nextInt();
        while (orderIndex < 1 || orderIndex > SellOrderManagement.getSellOrderList().size()){
            System.out.println("Please choose valid option");
            orderIndex = scanner.nextInt();
        }
        SellOrder sellOrder = SellOrderManagement.getSellOrderList().get(orderIndex - 1);
        System.out.println("Please input new price");
        int newPrice = scanner.nextInt();
        sellOrder.setPrice(newPrice);
        System.out.println("Change price successfully");
    }

    private void removeOrderById() {
        sellOrderManagement.showAllSellOrder();
        System.out.println("Please input your option");

        int orderIndex = scanner.nextInt();
        while (orderIndex < 1 || orderIndex > SellOrderManagement.getSellOrderList().size()){
            System.out.println("Please choose valid option");
            orderIndex = scanner.nextInt();
        }
        SellOrder sellOrder = SellOrderManagement.getSellOrderList().get(orderIndex - 1);
        sellOrderManagement.removeOrderByObject(sellOrder);
        System.out.println("Remove sell order successfully");
    }

    private void showSellOrderByUsername() {
        System.out.println("Please input username");
        String username = scanner.nextLine();
        int index = accountManagement.findAccountByUsername(username);
        if (index == -1) {
            System.out.println("Can not found this account, please try again");
        } else {
            Account account = accountManagement.getAccountList().get(index);
            sellOrderManagement.showSellOrderByAccount(account);
        }
    }

    private int getOrderIndex() {
        int id;
        int orderIndex;
        System.out.println("Please input sell order id");
        id = scanner.nextInt();
        orderIndex = sellOrderManagement.findOrderById(id);
        return orderIndex;
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
