package Model.Transaction;

import Model.Account.Account;

import java.io.Serializable;

abstract public class Transaction  implements Serializable {
    private Account fromAccount;
    private Account toAccount;
    private boolean isDone;
    public static int count = 0;
    private int id;

    public Transaction() {
    }

    public Transaction(Account fromAccount, Account toAccount) {
        id = ++count;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        isDone = false;
    }

    abstract public void execute();

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public boolean isDone() {
        return isDone;
    }

    public final void changeStatus(){
        isDone = true;
    }

    public static void setCount(int count) {
        Transaction.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    @Override
    public String toString() {
        return  "tx Id: " + id + "; fromAccount: " + fromAccount.getUsername() +
                " - toAccount: " + toAccount.getUsername() + "; ";
    }
}
