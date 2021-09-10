package Controller.DataHandler;

import Controller.SellOrderManagement;
import Model.SellOrder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SellOrderDataHandler{
    private final static String filePath ="src/Data/sellOrderList.txt";
    public static void writeToFile() {
        try {
            List<SellOrder> sellOrderList = SellOrderManagement.getSellOrderList();
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sellOrderList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    public static List<SellOrder> readDataFromFile() {
        List<SellOrder> sellOrderList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            sellOrderList = (List<SellOrder>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
        }
        return sellOrderList;
    }
}
