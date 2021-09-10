package Controller;

import Controller.DataHandler.AccountDataHandler;
import Model.Account.Account;

import java.util.*;

public class AccountManagement {
    private static List<Account> accountList = new ArrayList<>();

    private static final AccountManagement accountManager = new AccountManagement();

    private AccountManagement() {
    }

//    static {
//        boolean isHavingAdmin = false;
//        for (Account account: accountList){
//            if (account.getUsername().equals("admin")){
//                isHavingAdmin = true;
//                break;
//            }
//        }
//        if (!isHavingAdmin){
//            accountList.add(new Account("admin", "admin"));
//            AccountDataHandler.writeToFile();
//        }
//    }

    public static void setAccountList(List<Account> accountList) {
        AccountManagement.accountList = accountList;
    }

    public static AccountManagement getAccountManager() {
        return accountManager;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void showAccountList() {
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    public void addNewAccount(Account account) {
        accountList.add(account);
        AccountDataHandler.writeToFile();
    }

    public Account login(String username, String password) {
        for (Account account : accountList) {
            if (username.equals(account.getUsername()) && password.equals(account.getPassword())) {
                return account;
            }
        }
        return null;
    }

    public int getAccountIndexByUsername(String username) {
        int index = -1;
        for (int i = 0; i < accountList.size(); i++) {
            if (username.equals(accountList.get(i).getUsername())) {
                index = i;
            }
        }
        return index;
    }

    public Account getAccountByIndex(int index){
        return accountList.get(index);
    }

    public Account getAccountByUsername(String username){
        int index = getAccountIndexByUsername(username);
        return accountList.get(index);
    }

    public boolean isAccountExist(String username) {
        boolean isExist = false;
        int index = getAccountIndexByUsername(username);
        if (index != -1) {
            isExist = true;
        }
        return isExist;
    }

    public void removeAccount(int index) {
        accountList.remove(index);
        AccountDataHandler.writeToFile();
    }

}
