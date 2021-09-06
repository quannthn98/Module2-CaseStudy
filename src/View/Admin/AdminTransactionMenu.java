package View.Admin;

import Controller.Account.AccountManagement;
import Controller.TransactionManagement;
import Model.Account.Account;
import Model.Transaction.Transaction;

import java.util.List;
import java.util.Scanner;

public class AdminTransactionMenu {
    public static Scanner scanner = new Scanner(System.in);
    private TransactionManagement transactionManagement = new TransactionManagement();
    private AccountManagement accountManagement = AccountManagement.getAccountManager();

    public void run(){
        int option;
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 0:
                    AdminMenu adminMenu = new AdminMenu();
                    adminMenu.run();
                    break;
                case 1:
                    transactionManagement.showAllTransaction();
                    break;
                case 2:
                    showTransactionByUsername();
                    break;
                case 3:
                    showTypeOfTransaction();
                    break;


            }
        } while (option != 0);
    }

    private void showTypeOfTransaction(){
        int option;
        typeOfTransactionMenu();
        System.out.println("Please choose type of Transaction");
        option = scanner.nextInt();
        while (option < 0 || option > 4){
            System.out.println("Please input valid option");
            option = scanner.nextInt();
        }
        switch (option){
            case 1:
                transactionManagement.showSendMoneyTransaction();
                break;
            case 2:
                transactionManagement.showSendMonsterTransaction();
                break;
            case 3:
                transactionManagement.showBuyMonsterTransaction();
                break;
            case 4:
                transactionManagement.showGenerateMonsterTransaction();
                break;
            case 0:
                run();
                break;
        }
    }

    private void showTransactionByUsername() {
        System.out.println("----------------------------");
        System.out.println("Please input username your want to get Transaction");
        String username = scanner.nextLine();
        int index = accountManagement.findAccountByUsername(username);
        if (index == -1){
            System.out.println("Dont find this username");
        } else {
            Account account = accountManagement.getAccountList().get(index);
            transactionManagement.showTransactionByAccount(account);
        }
    }

    public void menu(){
        System.out.println("----------------------------");
        System.out.println("1. Show all Transaction");
        System.out.println("2. Show Transaction by Username");
        System.out.println("3. Show Transaction by Type of Transaction");
        System.out.println("0. Back to admin menu");
        System.out.println("----------------------------");
    }

    public void typeOfTransactionMenu(){
        System.out.println("----------------------------");
        System.out.println("1. Send Money Transaction");
        System.out.println("2. Send Monster Transaction");
        System.out.println("3. Buy Monster Transaction");
        System.out.println("4. Generate Monster Transaction");
        System.out.println("----------------------------");
    }
}
