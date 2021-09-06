package Controller.Account;

import Controller.DataHandler.AccountDataHandler;
import Model.Account.Account;

import java.util.*;

public class AccountManagement {
    private static List<Account> accountList = new ArrayList<>();

    private static final AccountManagement accountManager = new AccountManagement();

    private AccountManagement(){};

    public static void setAccountList(List<Account> accountList) {
        AccountManagement.accountList = accountList;
    }

    public static AccountManagement getAccountManager(){
        return accountManager;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void showAccountList(){
        for (Account account: accountList){
            System.out.println(account);
        }
    }

    public void addNewAccount(Account account){
        accountList.add(account);
        AccountDataHandler.writeToFile();
    }

    public Account login(String username, String password){
        for (Account account: accountList){
            if (username.equals(account.getUsername()) && password.equals(account.getPassword())){
                return account;
            }
        }
        return null;
    }

    public int findAccountByUsername(String username){
        int index = -1;
        for (int i = 0; i < accountList.size(); i++) {
            if (username.equals(accountList.get(i).getUsername())){
                index = i;
            }
        }
        return index;
    }

    public boolean isAccountExist(String username){
        boolean isExist = false;
        int index = findAccountByUsername(username);
        if (index != -1){
            isExist = true;
        }
        return isExist;
    }

    public void removeAccount(int index){
        accountList.remove(index);
        AccountDataHandler.writeToFile();
    }

}
