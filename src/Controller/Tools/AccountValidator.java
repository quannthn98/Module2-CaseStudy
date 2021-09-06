package Controller.Tools;

import Controller.Account.AccountManagement;
import Model.Account.Account;

import java.util.List;
import java.util.regex.*;

public class AccountValidator {
    private String USERNAMEREGEX = "^[a-zA-Z0-9]{4,8}$";

    public AccountValidator() {
    }

    public boolean isValidated(String string){
        Pattern pattern = Pattern.compile(USERNAMEREGEX);
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()){
            System.out.println("----------------------------");
            System.out.println("Please input again, must have 4 - 8 characters without any special one");
            System.out.println("----------------------------");
        }
        return matcher.matches();
    }

    public boolean isDuplicated(String username){
        boolean isDuplicated = false;
        List<Account> accountList = AccountManagement.getAccountManager().getAccountList();
        for (Account account: accountList){
            if (username.equals(account.getUsername())){
                System.out.println("Username has already existed, please input another username");
                isDuplicated = true;
                break;
            }
        }
        return isDuplicated;
    }
}
