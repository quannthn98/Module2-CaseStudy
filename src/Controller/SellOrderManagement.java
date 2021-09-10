package Controller;

import Controller.DataHandler.SellOrderDataHandler;
import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;
import Model.SellOrder;

import java.util.ArrayList;
import java.util.Collections;
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
        if (sellOrderList.size() == 0) {
            System.out.println("There is no sell order at the moment");
        } else {
            System.out.println("----------------------------");
            System.out.println("Sell order List:");
            for (int i = 0; i < sellOrderList.size(); i++) {
                System.out.println((i + 1) + ". " + sellOrderList.get(i));
            }
        }
    }

    public List<SellOrder> getSellOrderListByAccount(Account account) {
        List<SellOrder> accountSellOrder = new ArrayList<>();
        for (int i = 0; i < sellOrderList.size(); i++) {
            if (account.getUsername().equals(sellOrderList.get(i).getSeller().getUsername())) {
                accountSellOrder.add(sellOrderList.get(i));
            }
        }
        if (accountSellOrder.size() == 0) {
            System.out.println("You dont have any order");
        }
        return accountSellOrder;
    }

    public void showSellOrderListByAccount(Account account) {
        int count = 0;
        List<SellOrder> accountSellOrder = getSellOrderListByAccount(account);
        if (accountSellOrder.size() == 0) {
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

    public boolean isHavingSellOrder() {
        boolean isHavingSellOrder = false;
        if (sellOrderList.size() > 0) {
            isHavingSellOrder = true;
        }
        return isHavingSellOrder;
    }

    public boolean isHavingSellOrder(Account account) {
        boolean isHavingSellOrder = false;
        for (int i = 1; i <= sellOrderList.size(); i++) {
            if (account.getUsername().equals(sellOrderList.get(i - 1).getSeller().getUsername())) {
                isHavingSellOrder = true;
                break;
            }
        }
        return isHavingSellOrder;
    }

    public int findOrderByMonster(Monster monster){
        int index = -1;
        for (int i = 0; i < sellOrderList.size(); i++) {
            if (sellOrderList.get(i).getMonster().getId() == monster.getId()){
                index = i;
            }
        }
        return index;
    }

    public void removeOrderByObject(SellOrder sellOrder) {
        sellOrderList.remove(sellOrder);
        SellOrderDataHandler.writeToFile();
    }

    public void removeOrderByMonster(Monster monster){
        int index = findOrderByMonster(monster);
        sellOrderList.remove(index);
        SellOrderDataHandler.writeToFile();
    }

    public void sortByPrice() {
        Collections.sort(sellOrderList);
    }

    public void removeAllSellOrder() {
        sellOrderList = new ArrayList<>();
    }


}
