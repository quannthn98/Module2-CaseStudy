package Controller;

import Controller.DataHandler.SellOrderDataHandler;
import Model.Account.Account;
import Model.SellOrder;

import java.util.ArrayList;
import java.util.List;

public class SellOrderManagement {
    private static List<SellOrder> sellOrderList = new ArrayList<>();

    public static List<SellOrder> getSellOrderList() {
        return sellOrderList;
    }

    public static void setSellOrderList(List<SellOrder> sellOrderList) {
        SellOrderManagement.sellOrderList = sellOrderList;
    }

    public void newSellOrder(SellOrder sellOrder) {
        sellOrderList.add(sellOrder);
        SellOrderDataHandler.writeToFile();
    }

    public void showAllSellOrder() {
        System.out.println("----------------------------");
        if (sellOrderList.size() == 0){
            System.out.println("There is no Sell order at the moment");
            return;
        }
        System.out.println("Sell order List:");
        for (int i = 1; i <= sellOrderList.size(); i++) {
            System.out.println(i + ". " + sellOrderList.get(i - 1));

        }
    }

    public List<SellOrder> getSellOrderByAccount(Account account) {
        List<SellOrder> accountSellOrder = new ArrayList<>();
        for (int i = 0; i < sellOrderList.size(); i++) {
            if (account.getUsername().equals(sellOrderList.get(i).getSeller().getUsername())) {
                accountSellOrder.add(sellOrderList.get(i));
            }
        }
        if (accountSellOrder.size() == 0){
            System.out.println("You dont have any order");
        }
        return accountSellOrder;
    }

    public void showSellOrderByAccount(Account account){
        int count = 0;
        List<SellOrder> accountSellOrder = getSellOrderByAccount(account);
        if (accountSellOrder.size() == 0){
            return;
        } else {
            System.out.println("----------------------------");
            System.out.println("My Sell order: ");
            for (SellOrder sellOrder : accountSellOrder) {
                System.out.println(++count + ". " + sellOrder);
            }
        }
    }

    public void setOrderPrice(SellOrder sellOrder, int price) {
        sellOrder.setPrice(price);
        SellOrderDataHandler.writeToFile();
    }

    public boolean isHavingSellOrder(Account account){
        boolean isHavingSellOrder = false;
        for (int i = 1; i <= sellOrderList.size(); i++) {
            if (account.getUsername().equals(sellOrderList.get(i - 1).getSeller().getUsername())) {
                isHavingSellOrder = true;
                break;
            }
        }
        return isHavingSellOrder;
    }

    public int findOrderById(int id) {
        int index = -1;
        for (int i = 0; i < sellOrderList.size(); i++) {
            if (id == sellOrderList.get(i).getId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void removeOrderById(int id) {
        int index = findOrderById(id);
        if (index == -1) {
            System.out.println("Can not found this order");
        } else {
            System.out.println("Remove order successfully");
            ;
            sellOrderList.remove(index);
        }
        SellOrderDataHandler.writeToFile();
    }

    public void removeOrderByObject(SellOrder sellOrder){
        sellOrderList.remove(sellOrder);
        SellOrderDataHandler.writeToFile();
    }


}
