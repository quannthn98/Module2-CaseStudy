package Controller.DataHandler;

import Controller.TransactionManagement;
import Model.Transaction.Transaction;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDataHandler {
    private final static String filePath = "/Users/quans/Desktop/module2/CaseStudyM2/src/Server/transactionList.txt";

    public static void writeToFile() {
        try {
            List<Transaction> transactionList = TransactionManagement.getTransactionList();
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(transactionList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    public static List<Transaction> readDataFromFile() {
        List<Transaction> transactionList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            transactionList = (List<Transaction>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            System.err.println("Transaction Data is empty");
        }
        return transactionList;
    }
}
