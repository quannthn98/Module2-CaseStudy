package Controller.AdminFunctions;

import Controller.Account.AccountManagement;
import Controller.SellOrderManagement;
import Model.Account.Account;
import Model.SellOrder;
import View.Admin.AdminMainMenu;

import java.util.Scanner;

public class AdminSellOrderManagementFunctions {
    public static Scanner scanner = new Scanner(System.in);
    private static SellOrderManagement sellOrderManagement = new SellOrderManagement();
    private static AccountManagement accountManagement = AccountManagement.getAccountManager();

    public void showAllSellOrder(){
        sellOrderManagement.showAllSellOrder();
    }

    public void showSellOrderByUsername() {
        System.out.println("Please input username");
        String username = scanner.nextLine();
        int index = accountManagement.getAccountIndexByUsername(username);

        if (index == -1) {
            System.out.println("Can not found this account, please try again");
        } else {
            Account account = accountManagement.getAccountByUsername(username);
            sellOrderManagement.showSellOrderByAccount(account);
        }
    }

    public void removeOrderBySelect() {
        SellOrder sellOrder = getSellOrder();
        sellOrderManagement.removeOrderByObject(sellOrder);
        System.out.println("Remove sell order successfully");
    }

    public void changeOrderPrice() {
        SellOrder sellOrder = getSellOrder();
        setNewPrice(sellOrder);
    }

    public void removeAllSellOrder(){
        sellOrderManagement.removeAllSellOrder();
        System.out.println("Remove all order successfully");
    }

    public void sortByPrice(){
        sellOrderManagement.sortByPrice();
        sellOrderManagement.showAllSellOrder();
    }

    public void openMainMenu(){
        AdminMainMenu adminMenu = new AdminMainMenu();
        adminMenu.run();
    }

    private SellOrder getSellOrder() {
        sellOrderManagement.showAllSellOrder();
        System.out.println("Please input your option");
        int orderIndex = scanner.nextInt();
        while (orderIndex < 1 || orderIndex > SellOrderManagement.getSellOrderList().size()) {
            System.out.println("Please choose valid option");
            orderIndex = scanner.nextInt();
        }
        SellOrder sellOrder = SellOrderManagement.getSellOrderList().get(orderIndex - 1);
        return sellOrder;
    }

    private void setNewPrice(SellOrder sellOrder) {
        System.out.println("Please input new price");
        int newPrice = scanner.nextInt();
        sellOrder.setPrice(newPrice);
        System.out.println("Change price successfully");
    }



}
