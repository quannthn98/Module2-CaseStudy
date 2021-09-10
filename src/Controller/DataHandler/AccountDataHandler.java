package Controller.DataHandler;

import Controller.AccountManagement;
import Model.Account.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDataHandler{
    private final static String filePath = "src/Data/accountList.txt";

    public static void writeToFile() {
        try {
            List<Account> accountList = AccountManagement.getAccountManager().getAccountList();
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accountList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    public static List<Account> readDataFromFile() {
        List<Account> accountList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            accountList = (List<Account>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
        }
        return accountList;
    }

}
