package Controller.AdminFunctions;

import Controller.AccountManagement;
import Controller.DataHandler.AccountDataHandler;
import Controller.Tools.AccountValidator;
import Model.Account.Account;
import View.Admin.AdminMainMenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdminAccountManagementFunctions {
    public static Scanner scanner = new Scanner(System.in);
    private AccountManagement accountManager = AccountManagement.getAccountManager();
    private AccountValidator validator = new AccountValidator();

    public void showAccountList(){
        accountManager.showAccountList();
    }

    public void openMainMenu() {
        AdminMainMenu adminMenu = new AdminMainMenu();
        adminMenu.run();
    }

    private int getAccountIndex(String display){
        System.out.println("Please input username you want to " + display);
        String username = scanner.nextLine();
        int index = accountManager.getAccountIndexByUsername(username);
        return index;
    }

    public void deleteAccountByUsername() {
        final String DISPLAY = "to Delete";
        int index = getAccountIndex(DISPLAY);
        if (index == -1) {
            System.out.println("Can not found this username, please try again");
        } else {
            Account account = accountManager.getAccountByIndex(index);

            if (account.getUsername().equals("admin")) {
                System.out.println("Can not remove this account");
            } else {
                System.out.println("Remove account successfully");
                accountManager.removeAccount(index);
            }
        }
    }


    public void deleteMonsterOfAccount() {
        final String DISPLAY = "delete Monster";
        int index = getAccountIndex(DISPLAY);

        if (index == -1) {
            System.out.println("Can not found this account, please try again");
        } else {
            Account account = accountManager.getAccountByIndex(index);
            account.setMonsterList(new ArrayList<>());
            System.out.println("Delete MonsterList successfully");
            AccountDataHandler.writeToFile();
        }
    }

    public void changeAccountBalance() {
        final String DISPLAY = "change balance";
        int index = getAccountIndex(DISPLAY);

        if (index == -1) {
            System.out.println("Can not found this account, please try again");
        } else {
            System.out.println("Please input new Balance");
            int newBalance = scanner.nextInt();

            Account account = accountManager.getAccountList().get(index);
            account.setBalance(newBalance);
            AccountDataHandler.writeToFile();
        }
    }

    public void AddNewAccount() {
        String username;
        String password;

        do {
            System.out.println("Please input your username");
            username = scanner.nextLine();
        } while (!validator.isValidated(username) || validator.isDuplicated(username));

        do {
            System.out.println("Please input your password");
            password = scanner.nextLine();
        } while (!validator.isValidated(password));

        System.out.println("Add new account successfully");
        Account newAccount = new Account(username, password);
        accountManager.addNewAccount(newAccount);
    }

    public void sortByBalance(){
        Collections.sort(accountManager.getAccountList());
    }

}
