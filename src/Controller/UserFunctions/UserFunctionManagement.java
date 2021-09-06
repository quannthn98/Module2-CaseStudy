package Controller.UserFunctions;

import Controller.Account.AccountManagement;
import Controller.DataHandler.AccountDataHandler;
import Controller.TransactionManagement;
import Controller.Monster.Factory.MonsterFactory;
import Model.Account.Account;
import Model.Creep.Creep;
import Model.Monster.MonsterTypes.Monster;
import Model.Transaction.*;
import View.User.MarketplaceMenu;

import java.util.List;
import java.util.Scanner;

public class UserFunctionManagement {
    private Account account;

    private static MonsterFactory monsterFactory = MonsterFactory.getInstance();
    private static TransactionManagement transactionManagement= new TransactionManagement();
    private AccountManagement accountManagement = AccountManagement.getAccountManager();

    public static Scanner scanner = new Scanner(System.in);

    public UserFunctionManagement(Account account) {
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
        if (account.getMonsterList().size() == 0) {
            System.out.println("You dont have any Monster");
        } else {
            System.out.println("Your Monster List:");
            List<Monster> monsterList = account.getMonsterList();
            for (int i = 1; i <= monsterList.size(); i++) {
                System.out.println(i + ". " + monsterList.get(i - 1).toString());
            }
        }
    }

    public void showTransactionHistory(){
        transactionManagement.showTransactionByAccount(account);
    }

    public void openMarketplace() {
        MarketplaceMenu marketplaceMenu = new MarketplaceMenu();
        marketplaceMenu.run(account);
    }

    public void createNewMonster() {
        if (account.getBalance() >= Monster.getCOST()) {

            Monster newMonster = monsterFactory.createNewMonster();
            Transaction generateMonsterTransaction = new GenerateMonsterTransaction(account,null, newMonster);
            generateMonsterTransaction.execute();
            transactionManagement.newTransaction(generateMonsterTransaction);
            AccountDataHandler.writeToFile();

            System.out.println("----------------------------");
            System.out.println("Congratulation, you have received new Monster");
            System.out.println(newMonster);

        } else {
            System.out.println("----------------------------");
            System.out.println("Insufficient balance, please deposit");
        }
    }

    public void sendMonster() {
        System.out.println("Please input destination username");
        String username = scanner.nextLine();
        int index = accountManagement.findAccountByUsername(username);
        if (index == -1) {
            System.out.println("Can not found this username");
        } else {
            Monster chosenMonster = getMonsterFromYourList();

            Account fromAccount = account;
            Account toAccount = accountManagement.getAccountList().get(index);
            System.out.println("You have sent your monster to account " + toAccount.getUsername());
            Transaction sendMonsterTransaction = new SendMonsterTransaction(fromAccount, toAccount, chosenMonster);
            sendMonsterTransaction.execute();
            transactionManagement.newTransaction(sendMonsterTransaction);
        }
    }

    public void sendMoney() {
        System.out.println("Please input destination username");
        String username = scanner.nextLine();
        int index = accountManagement.findAccountByUsername(username);
        System.out.println("----------------------------");
        if (index == -1) {
            System.out.println("Can not found this username");
        } else {
            Account fromAccount = account;
            Account toAccount = accountManagement.getAccountList().get(index);

            if (toAccount.getUsername().equals(account.getUsername())){
                System.out.println("You can not send money to your self");
                return;
            }

            System.out.println("Please input Amount of Coins you want to transfer");
            int transferAmount = scanner.nextInt();

            if (transferAmount > fromAccount.getBalance()) {
                System.out.println("Insufficient balance, please try again");
            } else {
                Transaction sendMoneyTransaction = new SendMoneyTransaction(fromAccount, toAccount,transferAmount);
                sendMoneyTransaction.execute();
                transactionManagement.newTransaction(sendMoneyTransaction);
                System.out.println("You sent " + transferAmount + " coins to account " + toAccount.getUsername());
            }
        }
    }

    public Monster getMonsterFromYourList() {

        System.out.println("----------------------------");
        System.out.println("Please pick 1 Monster from your List");
        showMonster();

        Monster chosenMonster;
        int index = scanner.nextInt();
        while (index < 1 || index > getTotalNumberMonster()) {
            System.out.println("----------------------------");
            System.out.println("Please input valid Monster option");
            index = scanner.nextInt();
        }
        chosenMonster = getAccount().getMonsterList().get(index - 1);
        return chosenMonster;
    }

    public void battle() {
        BattleFunctionManagement battleFunctionManagement = new BattleFunctionManagement(account);

        Monster chosenMonster = getMonsterFromYourList();
        Creep chosenCreep = battleFunctionManagement.getCreepForBattle(chosenMonster);

        boolean battleResult = battleFunctionManagement.fight(chosenMonster, chosenCreep);

        battleFunctionManagement.finalizeBattle(chosenCreep, battleResult);
    }
}