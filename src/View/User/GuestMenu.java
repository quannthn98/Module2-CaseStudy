package View.User;

import Controller.Account.AccountManagement;
import Model.Account.Account;
import Controller.Tools.AccountValidator;
import View.Admin.AdminMainMenu;

import java.util.Scanner;

public class GuestMenu {
    private AccountManagement accountManagement = AccountManagement.getAccountManager();
    public static AccountValidator validator = new AccountValidator();
    public static Scanner scanner = new Scanner(System.in);

    public void run(){
        int option;
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    doRegister();
                    break;
                case 2:
                    doLogin();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (option != 0);
    }

    private void doLogin() {
        System.out.println("----------------------------");
        System.out.println("Please input your username");
        String userName = scanner.nextLine();

        System.out.println("----------------------------");
        System.out.println("Please input your password");
        String password = scanner.nextLine();

        Account account =  accountManagement.login(userName, password);

        if (account == null){
            System.out.println("----------------------------");
            System.out.println("Username or password invalid, please try again");
        } else {
            if (account.getUsername().equals("admin")){
                AdminMainMenu adminMenu = new AdminMainMenu();
                adminMenu.run();
            } else {
                UserMenu userMenu = new UserMenu(account);
                userMenu.run();
            }
        }
    }

    private void doRegister() {
        String password;
        String userName;
        do {
            System.out.println("----------------------------");
            System.out.println("Please input your username");
            userName = scanner.nextLine();
        } while (!validator.isValidated(userName) || validator.isDuplicated(userName));

        do {
            System.out.println("----------------------------");
            System.out.println("Please input your password");
            password = scanner.nextLine();
        } while (!validator.isValidated(password));

        Account newAccount = new Account(userName, password);
        accountManagement.addNewAccount(newAccount);

        System.out.println("----------------------------");
        System.out.println("Register Successfully, please login to play");

    }

    public void menu(){
        System.out.println("----------------------------");
        System.out.println("Welcome to Model.Monster Infinity");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
        System.out.println("Please input your option");

    }
}
