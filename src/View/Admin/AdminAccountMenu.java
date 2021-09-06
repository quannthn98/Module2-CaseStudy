package View.Admin;

import Controller.DataHandler.AccountDataHandler;
import Controller.Account.AccountManagement;
import Model.Account.Account;
import Controller.Tools.AccountValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminAccountMenu {
    public static Scanner scanner = new Scanner(System.in);
    private AccountManagement accountManager = AccountManagement.getAccountManager();
    private AccountValidator validator = new AccountValidator();

    public void run() {
        int option;
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    accountManager.showAccountList();
                    break;
                case 2:
                    deleteAccountByUsername();
                    break;
                case 3:
                    AddNewAccount();
                    break;
                case 4:
                    changeAccountBalance();
                    break;
                case 5:
                    deleteMonsterOfAccount();
                    break;
                case 0:
                    AdminMenu adminMenu = new AdminMenu();
                    System.out.println("Back to Main menu");
                    adminMenu.run();
                    break;
            }
        } while (option != 0);
    }

    private void deleteMonsterOfAccount() {
        int index;
        String username;
        System.out.println("Please input username you want to delete monster");
        username = scanner.nextLine();
        index = accountManager.findAccountByUsername(username);
        if (index == -1) {
            System.out.println("Can not found this account, please try again");
        } else {
            Account account = accountManager.getAccountList().get(index);
            account.setMonsterList(new ArrayList<>());
            System.out.println("Delete MonsterList successfully");
            AccountDataHandler.writeToFile();
        }
    }

    private void changeAccountBalance() {
        int index;
        String username;
        System.out.println("Please input username you want to change balance");
        username = scanner.nextLine();
        index = accountManager.findAccountByUsername(username);
        if (index == -1) {
            System.out.println("Can not found this account, please try again");
        } else {
            Account account = accountManager.getAccountList().get(index);
            System.out.println("Please input new Balance");
            int newBalance = scanner.nextInt();
            account.setBalance(newBalance);
            AccountDataHandler.writeToFile();
        }
    }

    private void AddNewAccount() {
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

    private void deleteAccountByUsername() {
        System.out.println("Please input username you want to delete");
        String username = scanner.nextLine();
        int index = accountManager.findAccountByUsername(username);
        if (index == -1) {
            System.out.println("Can not found this username, please try again");
        } else {
            if (username.equals("admin")) {
                System.out.println("Can not remove this account");
            } else {
                System.out.println("Remove account successfully");
                accountManager.removeAccount(index);
            }
        }
    }

    public void menu() {
        System.out.println("----------------------------");
        System.out.println("1. Show Account list");
        System.out.println("2. Remove Account");
        System.out.println("3. Add Account");
        System.out.println("4. Change Account balance");
        System.out.println("5. Delete Monster of 1 account");
        System.out.println("0. Return to Main menu");
        System.out.println("----------------------------");
    }

}
