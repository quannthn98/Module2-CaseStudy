package Model.Transaction;

import Controller.DataHandler.AccountDataHandler;
import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;
import Model.SellOrder;

public class BuyMonsterTransaction extends Transaction {
    private SellOrder sellOrder;

    public BuyMonsterTransaction(Account fromAccount, Account toAccount, SellOrder sellOrder) {
        super(fromAccount, toAccount);
        this.sellOrder = sellOrder;
    }

    @Override
    public void execute() {
        Account buyer = getFromAccount();
        Account seller = getToAccount();
        int price = sellOrder.getPrice();
        Monster monster = sellOrder.getMonster();
//Transfer Monster
        seller.getMonsterList().remove(monster);
        buyer.getMonsterList().add(monster);
//Transfer Money
        buyer.setBalance(buyer.getBalance() - price);
        seller.setBalance(seller.getBalance() + price);
        changeStatus();
        AccountDataHandler.writeToFile();
    }

    @Override
    public String toString() {
        return "Buy Monster: " + super.toString() +
                " Sell order: " + sellOrder;
    }
}
