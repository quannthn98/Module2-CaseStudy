package Controller.UserFunctions;

import Controller.*;
import Controller.Tools.OptionValidator;
import Controller.Monster.Factory.MonsterFactory;
import Model.Account.Account;
import Model.Creep.Creep;
import Model.Monster.MonsterTypes.Monster;
import View.User.*;

import java.util.List;
import java.util.Scanner;

public class MainUserFunctionsManagement {
    private Account account;

    private TransactionExecutor transactionExecutor = new TransactionExecutor();
    private static MonsterFactory monsterFactory = MonsterFactory.getInstance();
    private static TransactionManagement transactionManagement = new TransactionManagement();
    private AccountManagement accountManagement = AccountManagement.getAccountManager();
    private SellOrderManagement sellOrderManagement = new SellOrderManagement();

    public static Scanner scanner = new Scanner(System.in);

    public MainUserFunctionsManagement(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public int getTotalNumberMonster() {
        return account.getMonsterList().size();
    }

    public void showBalance() {
        System.out.println("----------------------------");
        System.out.println("Your balance is: " + account.getBalance() + " coins");
    }

    public void showMonster() {
        System.out.println("----------------------------");
        System.out.println("Your Monster List:");

        List<Monster> monsterList = account.getMonsterList();
        for (int i = 1; i <= monsterList.size(); i++) {
            System.out.println(i + ". " + monsterList.get(i - 1).toString());
        }
    }

    public void createNewMonster() {
        if (account.getBalance() >= Monster.getCOST()) {
            Account fromAccount = account;
            Monster newMonster = monsterFactory.createNewMonster();
            transactionExecutor.generateMonster(fromAccount, newMonster);
        } else {
            System.out.println("----------------------------");
            System.out.println("Insufficient balance, please deposit");
        }
    }

    public void battle() throws NullPointerException {
        BattleFunctionManagement battleFunctionManagement = new BattleFunctionManagement(account);
        Monster chosenMonster = getMonsterFromYourList();

        if (chosenMonster == null) {
            System.out.println("You must have at least 1 monster to fight");
            return;
        }

        Creep chosenCreep = battleFunctionManagement.getCreepForBattle(chosenMonster);
        boolean battleResult = battleFunctionManagement.fight(chosenMonster, chosenCreep);
        battleFunctionManagement.finalizeBattle(chosenCreep, battleResult);
    }

    public void openMarketplace() {
        MarketplaceMenu marketplaceMenu = new MarketplaceMenu();
        marketplaceMenu.run(account);
    }

    public void sendMoney() {
        int index = getAccountIndex();
        System.out.println("----------------------------");
        if (index == -1) {
            System.out.println("Can not found this username");
        } else {
            Account fromAccount = account;
            Account toAccount = accountManagement.getAccountList().get(index);
            transactionExecutor.sendMoney(fromAccount, toAccount);
        }
    }

    public void sendMonster() {
        int index = getAccountIndex();
        if (index == -1) {
            System.out.println("Can not found this username");
        } else {
            Monster chosenMonster = getMonsterFromYourList();
            Account fromAccount = account;
            Account toAccount = accountManagement.getAccountList().get(index);

            int sellOrderContainMonsterIndex = sellOrderManagement.findOrderByMonster(chosenMonster);
            if (sellOrderContainMonsterIndex != -1) {
                System.out.println("This monster is currently in your Sell order");
                System.out.println("Do you want to remove this sell order to Send this monster?");
                System.out.println("Press Y to remove / N to cancel");
                String option = scanner.nextLine();
                switch (option) {
                    case "Y":
                        sellOrderManagement.removeOrderByMonster(chosenMonster);
                        transactionExecutor.sendMonster(fromAccount, toAccount, chosenMonster);
                        break;
                    case "N":
                        UserMenu userMenu = new UserMenu(account);
                        userMenu.run();
                        break;
                }
            } else {
                transactionExecutor.sendMonster(fromAccount, toAccount, chosenMonster);
            }
        }
    }

    public void showTransactionHistory() {
        transactionManagement.showTransactionByAccount(account.getUsername());
    }

    public Monster getMonsterFromYourList() {
        Monster chosenMonster = null;

        if (account.getMonsterList().size() == 0) {
            System.out.println("----------------------------");
            System.out.println("You dont have any monster");
        } else {
            showMonster();
            System.out.println("----------------------------");
            System.out.println("Please pick 1 Monster from your List");

            int index = OptionValidator.getOption(1, getTotalNumberMonster());

            chosenMonster = getAccount().getMonsterList().get(index - 1);
        }
        return chosenMonster;
    }

    private int getAccountIndex(){
        System.out.println("Please input destination username");
        String username = scanner.nextLine();
        int index = accountManagement.getAccountIndexByUsername(username);
        return index;
    }

}