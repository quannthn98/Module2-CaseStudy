package Controller.UserFunctions;

import Controller.*;
import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;
import Model.SellOrder;
import Model.Transaction.*;

import java.util.List;
import java.util.Scanner;

public class MarketFunctionManagement {
    public static Scanner scanner = new Scanner(System.in);
    private static SellOrderManagement sellOrderManagement = new SellOrderManagement();
    private static TransactionManagement transactionManagement = new TransactionManagement();

    public void showAllSellOrder(){
        sellOrderManagement.showAllSellOrder();
    }

    public void showMySellOrder(Account account){
        sellOrderManagement.showSellOrderByAccount(account);
    }

    public void buyMonster(Account account) {
        sellOrderManagement.showAllSellOrder();
        System.out.println("----------------------------");
        System.out.println("Please choose 1 order to buy");

        int buyOrderIndex = scanner.nextInt();
        while (buyOrderIndex < 1 || buyOrderIndex > SellOrderManagement.getSellOrderList().size()){
            System.out.println("Please input valid option");
            buyOrderIndex = scanner.nextInt();
        }

        SellOrder chosenSellOrder = SellOrderManagement.getSellOrderList().get(buyOrderIndex - 1);
        if (chosenSellOrder.getSeller().getUsername().equals(account.getUsername())){
            System.out.println("----------------------------");
            System.out.println("You can not purchase your own Order");
            return;
        }
        System.out.println("----------------------------");
        if (account.getBalance() < chosenSellOrder.getPrice()){
            System.out.println("Insufficient balance, please chose another order");
        } else {
            System.out.println("You had successfully purchased new Monster");
            Account seller = chosenSellOrder.getSeller();
            Account buyer = account;

            Transaction buyMonsterTransaction = new BuyMonsterTransaction(buyer, seller, chosenSellOrder);
            transactionManagement.newTransaction(buyMonsterTransaction);
            buyMonsterTransaction.execute();

            sellOrderManagement.removeOrderByObject(chosenSellOrder);

        }
    }

    public void sellMonster(Account account) {
        System.out.println("----------------------------");
        List<Monster> myMonsterList = account.getMonsterList();
        if (myMonsterList.size() == 0){
            System.out.println("----------------------------");
            System.out.println("You dont have any monster ");
            return;
        }

        for (int i = 0; i < myMonsterList.size(); i++) {
            System.out.println((i + 1) + ". " + myMonsterList.get(i));
        }

        System.out.println("----------------------------");
        System.out.println("Please pick 1 monster to sell");
        int monsterIndex = scanner.nextInt();

        while (monsterIndex < 1 || monsterIndex > myMonsterList.size()) {
            System.out.println("----------------------------");
            System.out.println("Please pick valid option");
            monsterIndex = scanner.nextInt();
        }

        Monster chosenMonster = myMonsterList.get(monsterIndex - 1);

        if (isListed(account, chosenMonster)) return;

        System.out.println("----------------------------");
        System.out.println("Please set selling price");
        int price = scanner.nextInt();

        System.out.println("Your Sell order has been placed successfully");
        SellOrder sellOrder = new SellOrder(chosenMonster, account, price);
        sellOrderManagement.newSellOrder(sellOrder);
    }

    private boolean isListed(Account account, Monster chosenMonster) {
        List<SellOrder> mySellOrder = sellOrderManagement.getSellOrderByAccount(account);
        for (SellOrder sellOrder: mySellOrder){
            if (chosenMonster.equals(sellOrder.getMonster())) {
                System.out.println("----------------------------");
                System.out.println("You has already have an sell order for this monster");
                return true;
            }
        }
        return false;
    }

    public void removeOrderByAccount(Account account) {
        SellOrder chosenSellOrder;
        if (!sellOrderManagement.isHavingSellOrder(account)) {
            System.out.println("You dont have any sell order");
        } else {
            chosenSellOrder = getChosenSellOrderFromAccount(account);
            sellOrderManagement.removeOrderByObject(chosenSellOrder);
        }
    }

    public void setOrderPriceByAccount(Account account) {
        if (!sellOrderManagement.isHavingSellOrder(account)) {
            System.out.println("You dont have any sell order");
        } else {
            SellOrder chosenSellOrder = getChosenSellOrderFromAccount(account);
            System.out.println("Please input new Price");
            int newPrice = scanner.nextInt();
            sellOrderManagement.setOrderPrice(chosenSellOrder, newPrice);
        }
    }

    public SellOrder getChosenSellOrderFromAccount(Account account) {
        List<SellOrder> mySellOrder = sellOrderManagement.getSellOrderByAccount(account);
        System.out.println("----------------------------");
        for (int i = 0; i < mySellOrder.size(); i++) {
            System.out.println((i + 1) + ". " + mySellOrder.get(i));
        }
        System.out.println("----------------------------");
        System.out.println("Please choose 1 sell order");

        int mySellOrderIndex = scanner.nextInt();

        while (mySellOrderIndex < 1 || mySellOrderIndex > mySellOrder.size()) {
            System.out.println("----------------------------");
            System.out.println("Please input valid option");
            mySellOrderIndex = scanner.nextInt();
        }
        System.out.println("Remove Order successfully");
        SellOrder chosenSellOrder = mySellOrder.get(mySellOrderIndex - 1);
        return chosenSellOrder;
    }

}
