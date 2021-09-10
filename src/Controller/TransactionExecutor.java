package Controller;

import Controller.DataHandler.AccountDataHandler;
import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;
import Model.SellOrder;
import Model.Transaction.*;

import java.util.Scanner;

public class TransactionExecutor {
    private SellOrderManagement sellOrderManagement = new SellOrderManagement();
    public static Scanner scanner = new Scanner(System.in);
    private TransactionManagement transactionManagement = new TransactionManagement();

    public void sendMoney(Account fromAccount, Account toAccount){
        if (toAccount.getUsername().equals(fromAccount.getUsername())) {
            System.out.println("----------------------------");
            System.out.println("You can not send money to your self");
            return;
        }
        System.out.println("----------------------------");
        System.out.println("Please input Amount of Coins you want to transfer");
        int transferAmount = scanner.nextInt();

        if (transferAmount > fromAccount.getBalance()) {
            System.out.println("----------------------------");
            System.out.println("Insufficient balance, please try again");
        } else {
            Transaction sendMoneyTransaction = new SendMoneyTransaction(fromAccount, toAccount, transferAmount);
            sendMoneyTransaction.execute();
            transactionManagement.newTransaction(sendMoneyTransaction);
            System.out.println("----------------------------");
            System.out.println("You sent " + transferAmount + " coins to account " + toAccount.getUsername());
        }
    }

    public void sendMonster(Account fromAccount, Account toAccount, Monster monster){
        Transaction sendMonsterTransaction = new SendMonsterTransaction(fromAccount, toAccount, monster);
        sendMonsterTransaction.execute();
        System.out.println("----------------------------");
        System.out.println("You have sent your monster to account " + toAccount.getUsername());
        transactionManagement.newTransaction(sendMonsterTransaction);
    }

    public void generateMonster(Account creator, Monster monster){
        Transaction generateMonsterTransaction = new GenerateMonsterTransaction(creator, null, monster);
        generateMonsterTransaction.execute();

        transactionManagement.newTransaction(generateMonsterTransaction);
        AccountDataHandler.writeToFile();

        System.out.println("----------------------------");
        System.out.println("Congratulation, you have received new Monster");
        System.out.println(monster);
    }

    public void buyMonster(Account buyer, Account seller, SellOrder sellOrder){
        Transaction buyMonsterTransaction = new BuyMonsterTransaction(buyer, seller, sellOrder);
        buyMonsterTransaction.execute();

        transactionManagement.newTransaction(buyMonsterTransaction);
        sellOrderManagement.removeOrderByObject(sellOrder);
    }
}
