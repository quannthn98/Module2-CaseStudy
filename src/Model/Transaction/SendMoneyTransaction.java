package Model.Transaction;

import Controller.DataHandler.AccountDataHandler;
import Model.Account.Account;

public class SendMoneyTransaction extends Transaction {
    private int amount;

    public SendMoneyTransaction(Account fromAccount, Account toAccount, int amount) {
        super(fromAccount, toAccount);
        this.amount = amount;
    }

    @Override
    public void execute() {
        Account fromAccount = getFromAccount();
        Account toAccount = getToAccount();
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        changeStatus();
        AccountDataHandler.writeToFile();
    }

    @Override
    public String toString() {
        return "SendMoneyTransaction: " +
                super.toString() +
                "; amount: " + amount + " coins";
    }
}
