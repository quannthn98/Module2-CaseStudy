package View.Admin;

import Controller.Account.AccountManagement;
import Controller.AdminFunctions.AdminTransactionManagementFunctions;
import Controller.TransactionManagement;

import java.util.Scanner;

public class AdminTransactionMenu {
    public static Scanner scanner = new Scanner(System.in);
    private TransactionManagement transactionManagement = new TransactionManagement();
    private AccountManagement accountManagement = AccountManagement.getAccountManager();
    private AdminTransactionManagementFunctions adminTransactionManagementFunctions = new AdminTransactionManagementFunctions();

    public void run() {
        int option;
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    adminTransactionManagementFunctions.showAllTransaction();
                    break;
                case 2:
                    adminTransactionManagementFunctions.showTransactionByUsername();
                    break;
                case 3:
                    adminTransactionManagementFunctions.showTypeOfTransaction();
                    break;
                case 4:
                    adminTransactionManagementFunctions.findTransactionById();
                    break;
                case 0:
                    adminTransactionManagementFunctions.openMainMenu();
                    break;
            }
        } while (option != 0);
    }

    public void menu() {
        System.out.println("----------------------------");
        System.out.println("1. Show all Transaction");
        System.out.println("2. Show Transaction by Username");
        System.out.println("3. Show Transaction by Type of Transaction");
        System.out.println("4. Find Transaction by Id");
        System.out.println("0. Back to admin menu");
        System.out.println("----------------------------");
    }

}
