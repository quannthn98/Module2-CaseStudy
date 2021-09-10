package Controller.AdminFunctions;

import Controller.AccountManagement;
import Controller.Tools.OptionValidator;
import Controller.TransactionManagement;
import View.Admin.AdminMainMenu;
import View.Admin.AdminTransactionMenu;

import java.util.Scanner;

public class TransactionFunctionsManagement {
    public static Scanner scanner = new Scanner(System.in);
    private TransactionManagement transactionManagement = new TransactionManagement();
    private AccountManagement accountManagement = AccountManagement.getAccountManager();

    public void showAllTransaction(){
        transactionManagement.showAllTransaction();
    }

    public void showTransactionByUsername() {
        System.out.println("----------------------------");
        System.out.println("Please input username your want to get Transaction");
        String username = scanner.nextLine();
        int index = accountManagement.getAccountIndexByUsername(username);
        if (index == -1){
            System.out.println("Dont find this username");
        } else {
            transactionManagement.showTransactionByAccount(username);
        }
    }

    public void findTransactionById(){
        System.out.println("Please input transaction Id");
        int id = scanner.nextInt();
        System.out.println(transactionManagement.getTransactionById(id));
    }

    public void showTypeOfTransaction() {
        int option;
        typeOfTransactionMenu();
        System.out.println("Please choose type of Transaction");
        option = OptionValidator.getOption(0, 4);
        switch (option) {
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
                AdminTransactionMenu adminTransactionMenu = new AdminTransactionMenu();
                adminTransactionMenu.run();
                break;
        }
    }

    public void openMainMenu(){
        AdminMainMenu adminMainMenu = new AdminMainMenu();
        adminMainMenu.run();
    }

    public void typeOfTransactionMenu() {
        System.out.println("----------------------------");
        System.out.println("1. Send Money Transaction");
        System.out.println("2. Send Monster Transaction");
        System.out.println("3. Buy Monster Transaction");
        System.out.println("4. Generate Monster Transaction");
        System.out.println("----------------------------");
    }


}
