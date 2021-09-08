package Data;

import Controller.Monster.MonsterManagement;
import Controller.DataHandler.*;
import Controller.*;
import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;
import Model.SellOrder;
import Model.Transaction.Transaction;

import java.util.List;

public class SystemInputOnRun {
    private static MonsterManagement monsterManagement = new MonsterManagement();

    public static void getData() {
        importAccountData();

        importSellOrderData();

        importMosterData();

        importTransactionData();

    }

    private static void importTransactionData() {
        List<Transaction> transactionList = TransactionDataHandler.readDataFromFile();
        TransactionManagement.setTransactionList(transactionList);
        Transaction.count = transactionList.size();
    }

    private static void importMosterData() {
        MonsterManagement.getMonsterListOnRun();
        Monster.count = monsterManagement.getMonsterList().size();
    }

    private static void importSellOrderData() {
        List<SellOrder> sellOrderList = SellOrderDataHandler.readDataFromFile();
        SellOrderManagement.setSellOrderList(sellOrderList);
        SellOrder.count = sellOrderList.size();
    }

    private static void importAccountData() {
        List<Account> accountList = AccountDataHandler.readDataFromFile();
        AccountManagement.setAccountList(accountList);
    }
}
