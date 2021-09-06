package Model.Transaction;

import Controller.DataHandler.AccountDataHandler;
import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;

public class SendMonsterTransaction extends Transaction {
    private Monster monster;

    public SendMonsterTransaction(Account fromAccount, Account toAccount, Monster monster) {
        super(fromAccount, toAccount);
        this.monster = monster;
    }

    @Override
    public void execute(){
        if (isDone()) {
            System.out.println("Transaction has been executed");
        } else {
            Account fromAccount = getFromAccount();
            Account toAccount = getToAccount();
            fromAccount.getMonsterList().remove(monster);
            toAccount.getMonsterList().add(monster);
            changeStatus();
            AccountDataHandler.writeToFile();
        }
    }

    public Monster getMonster() {
        return monster;
    }

    @Override
    public String toString() {
        return "sendMonsterTransaction: " + super.toString() +
                "; Monster:" + monster;
    }
}
