package Controller.UserFunctions;

import Controller.*;
import Controller.Tools.OptionValidator;
import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;
import Model.SellOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarketFunctionManagement {
    public static Scanner scanner = new Scanner(System.in);
    private  SellOrderManagement sellOrderManagement = new SellOrderManagement();
    private TransactionExecutor transactionExecutor = new TransactionExecutor();

    public void showAllSellOrder(){
        sellOrderManagement.showAllSellOrder();
    }

    public void showMySellOrder(Account account){
        sellOrderManagement.showSellOrderListByAccount(account);
    }

    public void buyMonster(Account account) {
        List<SellOrder> sellOrderList = SellOrderManagement.getSellOrderList();
        System.out.println("----------------------------");
        if (!sellOrderManagement.isHavingSellOrder()){
            System.out.println("Marketplace has no Sell order at the moment");
        } else {
            sellOrderManagement.showAllSellOrder();
            System.out.println("Please choose 1 order to buy");

            int sellOrderIndex = OptionValidator.getOption(1, sellOrderList.size());
            SellOrder chosenSellOrder = sellOrderList.get(sellOrderIndex - 1);

            if (isMyOrder(account, chosenSellOrder)) return;

            System.out.println("----------------------------");
            if (account.getBalance() < chosenSellOrder.getPrice()) {
                System.out.println("Insufficient balance, please chose another order");
            } else {
                System.out.println("You had successfully purchased new Monster");
                Account seller = chosenSellOrder.getSeller();
                Account buyer = account;
                transactionExecutor.buyMonster(buyer, seller, chosenSellOrder);
            }
        }
    }

    public void sellMonster(Account account) {
        System.out.println("----------------------------");
        List<Monster> myMonsterList = account.getMonsterList();
        List<Monster> unlistedMonster = getUnlistedMonster(myMonsterList, account);
        if (isAccountHaveMonster(myMonsterList)) return;

        for (int i = 0; i < unlistedMonster.size(); i++) {
            System.out.println((i + 1) + ". " + unlistedMonster.get(i));
        }

        Monster chosenMonster = getMonsterToSell(unlistedMonster);

        if (isListed(account, chosenMonster)) {
            System.out.println("You has already have an sell order for this monster");
            return;
        }

        int price = setSellPrice();

        System.out.println("Your Sell order has been placed successfully");
        SellOrder sellOrder = new SellOrder(chosenMonster, account, price);
        sellOrderManagement.newSellOrder(sellOrder);
    }



    private boolean isAccountHaveMonster(List<Monster> myMonsterList) {
        if (myMonsterList.size() == 0){
            System.out.println("----------------------------");
            System.out.println("You dont have any monster ");
            return true;
        }
        return false;
    }

    public void removeOrderByAccount(Account account) {
        SellOrder chosenSellOrder;
        if (!sellOrderManagement.isHavingSellOrder(account)) {
            System.out.println("You dont have any sell order");
        } else {
            chosenSellOrder = getSellOrderFromAccount(account);
            sellOrderManagement.removeOrderByObject(chosenSellOrder);
            System.out.println("Remove order successfully");
        }
    }

    public void setOrderPriceByAccount(Account account) {
        if (!sellOrderManagement.isHavingSellOrder(account)) {
            System.out.println("You dont have any sell order");
        } else {
            SellOrder chosenSellOrder = getSellOrderFromAccount(account);

            int newPrice = setSellPrice();
            sellOrderManagement.setOrderPrice(chosenSellOrder, newPrice);
            System.out.println("Set order price successfully");
        }
    }

    public SellOrder getSellOrderFromAccount(Account account) {
        List<SellOrder> mySellOrderList = sellOrderManagement.getSellOrderListByAccount(account);

        System.out.println("----------------------------");
        for (int i = 0; i < mySellOrderList.size(); i++) {
            System.out.println((i + 1) + ". " + mySellOrderList.get(i));
        }

        System.out.println("----------------------------");
        System.out.println("Please choose 1 sell order");
        int mySellOrderIndex = OptionValidator.getOption(1, mySellOrderList.size());

        SellOrder chosenSellOrder = mySellOrderList.get(mySellOrderIndex - 1);
        return chosenSellOrder;
    }

    private Monster getMonsterToSell(List<Monster> unlistedMonster) {
        System.out.println("----------------------------");
        System.out.println("Please pick 1 monster to sell");
        int monsterIndex = OptionValidator.getOption(1, unlistedMonster.size());
        Monster chosenMonster = unlistedMonster.get(monsterIndex - 1);
        return chosenMonster;
    }

    private boolean isMyOrder(Account account, SellOrder chosenSellOrder) {
        if (chosenSellOrder.getSeller().getUsername().equals(account.getUsername())) {
            System.out.println("----------------------------");
            System.out.println("You can not purchase your own Order");
            return true;
        }
        return false;
    }

    private boolean isListed(Account account, Monster chosenMonster) {
        List<SellOrder> mySellOrder = sellOrderManagement.getSellOrderListByAccount(account);
        for (SellOrder sellOrder: mySellOrder){
            if (chosenMonster.getId() == sellOrder.getMonster().getId()) {
                return true;
            }
        }
        return false;
    }

    private List<Monster> getUnlistedMonster(List<Monster> myMonster, Account account){
        List<Monster> unlistedMonster = new ArrayList<>();
        for (Monster monster: myMonster){
            if (!isListed(account, monster )){
                unlistedMonster.add(monster);
            }
        }
        return unlistedMonster;
    }

    private int setSellPrice() {
        System.out.println("----------------------------");
        System.out.println("Please set selling price");
        return scanner.nextInt();
    }

}
