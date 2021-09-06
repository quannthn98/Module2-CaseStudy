package Controller;

import Controller.DataHandler.TransactionDataHandler;
import Model.Account.Account;
import Model.Transaction.*;

import java.util.ArrayList;
import java.util.List;

public class TransactionManagement {
    private static List<Transaction> transactionList = new ArrayList<>();

    public TransactionManagement() {
    }

    public static List<Transaction> getTransactionList() {
        return transactionList;
    }

    public static void setTransactionList(List<Transaction> transactionList) {
        TransactionManagement.transactionList = transactionList;
        TransactionDataHandler.writeToFile();
    }

    public void newTransaction(Transaction transaction) {
        transactionList.add(transaction);
        TransactionDataHandler.writeToFile();
    }

    public void showAllTransaction() {
        for (int i = 1; i <= transactionList.size(); i++) {
            System.out.println(i + ". " + transactionList.get(i - 1));
        }
    }

    public void showSendMoneyTransaction() {
        int count = 0;
        for (int i = 1; i <= transactionList.size(); i++) {
            if (transactionList.get(i - 1) instanceof SendMoneyTransaction) {
                System.out.println(++count + ". " + transactionList.get(i - 1));
            }
        }
    }

    public void showSendMonsterTransaction() {
        int count = 0;
        for (int i = 1; i <= transactionList.size(); i++) {
            if (transactionList.get(i - 1) instanceof SendMonsterTransaction) {
                System.out.println(++count + ". " + transactionList.get(i - 1));
            }
        }
    }

    public void showBuyMonsterTransaction() {
        int count = 0;
        for (int i = 1; i <= transactionList.size(); i++) {
            if (transactionList.get(i - 1) instanceof BuyMonsterTransaction) {
                System.out.println(++count + ". " + transactionList.get(i - 1));
            }
        }
    }
    public void showGenerateMonsterTransaction() {
        int count = 0;
        for (int i = 1; i <= transactionList.size(); i++) {
            if (transactionList.get(i - 1) instanceof GenerateMonsterTransaction) {
                System.out.println(++count + ". " + transactionList.get(i - 1));
            }
        }
    }

    public Transaction findTransactionById(int id) {
        for (Transaction transaction : transactionList) {
            if (id == transaction.getId()) {
                return transaction;
            }
        }
        return null;
    }

    public List<Transaction> getTransactionByUsername(String username) throws NullPointerException{
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : getTransactionList()) {
            try {
                if (transaction.getFromAccount().getUsername().equals(username) || transaction.getToAccount().getUsername().equals(username)) {
                    transactionList.add(transaction);
                }
            } catch (NullPointerException e){}
        }
        return transactionList;
    }

    public void showTransactionByAccount(Account account) throws NullPointerException{
        int count = 0;
        System.out.println("----------------------------");
            for (Transaction transaction : getTransactionList()) {
                try {
                    if (transaction.getFromAccount().getUsername().equals(account.getUsername()) || transaction.getToAccount().getUsername().equals(account.getUsername())) {
                        System.out.println(++count + ". " + transaction);
                    }
                } catch (NullPointerException e){}
            }

        if (count == 0){
            System.out.println("You dont have any transaction");
        }
    }
}
