package View.Admin;

import Controller.AdminFunctions.AccountFunctionsManagement;
import java.util.Scanner;

public class AdminAccountMenu {
    public static Scanner scanner = new Scanner(System.in);
    private AccountFunctionsManagement adminAccountManagementFunctions = new AccountFunctionsManagement();

    public void run() {
        int option;
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    adminAccountManagementFunctions.showAccountList();
                    break;
                case 2:
                    adminAccountManagementFunctions.deleteAccountByUsername();
                    break;
                case 3:
                    adminAccountManagementFunctions.AddNewAccount();
                    break;
                case 4:
                    adminAccountManagementFunctions.changeAccountBalance();
                    break;
                case 5:
                    adminAccountManagementFunctions.deleteMonsterOfAccount();
                    break;
                case 6:
                    adminAccountManagementFunctions.sortByBalance();
                    break;
                case 0:
                    adminAccountManagementFunctions.openMainMenu();
                    break;
            }
        } while (option != 0);
    }

    public void menu() {
        System.out.println("----------------------------");
        System.out.println("1. Show Account list");
        System.out.println("2. Remove Account");
        System.out.println("3. Add Account");
        System.out.println("4. Change Account balance");
        System.out.println("5. Delete Monster of 1 account");
        System.out.println("6. Sort by Balance");
        System.out.println("0. Return to Main menu");
        System.out.println("----------------------------");
        System.out.println("Please input your option");
    }

}
