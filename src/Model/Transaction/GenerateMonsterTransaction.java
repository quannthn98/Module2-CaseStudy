package Model.Transaction;

import Controller.DataHandler.TransactionDataHandler;
import Controller.Monster.Factory.MonsterFactory;
import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;

public class GenerateMonsterTransaction extends Transaction {
    private Monster newMonster;
    public GenerateMonsterTransaction() {
    }

    public GenerateMonsterTransaction(Account fromAccount, Account toAccount, Monster newMonster) {
        super(fromAccount, null);
        this.newMonster = newMonster;
    }

    @Override
    public void execute() {
        Account creator = getFromAccount();
        creator.setBalance(creator.getBalance() - Monster.getCOST());
        getFromAccount().getMonsterList().add(newMonster);
        TransactionDataHandler.writeToFile();
    }

    @Override
    public String toString() {
        return "Generate Monster Transaction: " +
                "creator: " + getFromAccount().getUsername() +
                ", newMonster: " + newMonster;
    }
}
