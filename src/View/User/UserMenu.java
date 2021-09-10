package View.User;

import Controller.UserFunctions.MainUserFunctionsManagement;
import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;

import java.util.Scanner;

public class UserMenu {
    private MainUserFunctionsManagement userFunctionManagement;
    private Account thisAccount;
    public static Scanner scanner = new Scanner(System.in);

    public UserMenu(Account account) {
        thisAccount = account;
        userFunctionManagement = new MainUserFunctionsManagement(account);
    }

    public void run() {
        System.out.println("----------------------------");
        System.out.println("Welcome back " + thisAccount.getUsername());
        int option;
        do {
            menu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    GuestMenu guestMenu = new GuestMenu();
                    guestMenu.run();
                    break;
                case 1:
                    userFunctionManagement.showBalance();
                    break;
                case 2:
                    userFunctionManagement.showMonster();
                    break;
                case 3:
                    userFunctionManagement.createNewMonster();
                    break;
                case 4:
                    userFunctionManagement.battle();
                    break;
                case 5:
                    userFunctionManagement.openMarketplace();
                    break;
                case 6:
                    userFunctionManagement.sendMoney();
                    break;
                case 7:
                    userFunctionManagement.sendMonster();
                    break;
                case 8:
                    userFunctionManagement.showTransactionHistory();
                    break;
            }

        } while (option != 0);
    }

    public void menu() {
        System.out.println("-----------MENU-------------");
        System.out.println("1. Show balance");
        System.out.println("2. Show Monster");
        System.out.println("3. Create new Monster (Cost: " + Monster.getCOST() + " coins)");
        System.out.println("4. Battle");
        System.out.println("5. Marketplace");
        System.out.println("6. Send money");
        System.out.println("7. Send Monster");
        System.out.println("8. Show Transaction History");
        System.out.println("0. Logout");
        System.out.println("----------------------------");
        System.out.println("Please input your option");
    }
}
