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
        for (int i = 0; i < transactionList.size(); i++) {
            System.out.println((i + 1) +  ". " + transactionList.get(i));
        }
    }

    public void showSendMoneyTransaction() {
        int count = 0;
        for (int i = 0; i < transactionList.size(); i++) {
            if (transactionList.get(i) instanceof SendMoneyTransaction) {
                System.out.println(++count + ". " + transactionList.get(i));
            }
        }
    }

    public void showSendMonsterTransaction() {
        int count = 0;
        for (int i = 0; i < transactionList.size(); i++) {
            if (transactionList.get(i) instanceof SendMonsterTransaction) {
                System.out.println(++count + ". " + transactionList.get(i));
            }
        }
    }

    public void showBuyMonsterTransaction() {
        int count = 0;
        for (int i = 0; i < transactionList.size(); i++) {
            if (transactionList.get(i) instanceof BuyMonsterTransaction) {
                System.out.println(++count + ". " + transactionList.get(i));
            }
        }
    }
    public void showGenerateMonsterTransaction() {
        int count = 0;
        for (int i = 0; i < transactionList.size(); i++) {
            if (transactionList.get(i) instanceof GenerateMonsterTransaction) {
                System.out.println(++count + ". " + transactionList.get(i));
            }
        }
    }

    public Transaction getTransactionById(int id) {
        for (Transaction transaction : transactionList) {
            if (id == transaction.getId()) {
                return transaction;
            }
        }
        return null;
    }

    public List<Transaction> getTransactionListByUsername(String username) throws NullPointerException{
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

    public void showTransactionByAccount(String username){
        List<Transaction> transactionList = getTransactionListByUsername(username);
        for (int i = 0; i < transactionList.size(); i++) {
            System.out.println((i + 1) + ". " + transactionList.get(i));
        }
    }
}
