import Controller.Monster.MonsterManagement;
import Controller.DataHandler.*;
import Controller.*;
import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;
import Model.SellOrder;
import Model.Transaction.Transaction;

import java.util.List;

public class SystemInputOnRun {
    private static AccountManagement accountManagement = AccountManagement.getAccountManager();
    private static MonsterManagement monsterManagement = new MonsterManagement();

    public static void getData() {
        List<Account> accountList = AccountDataHandler.readDataFromFile();
        AccountManagement.setAccountList(accountList);

        List<SellOrder> sellOrderList = SellOrderDataHandler.readDataFromFile();
        SellOrderManagement.setSellOrderList(sellOrderList);
        SellOrder.count = sellOrderList.size();

        MonsterManagement.getMonsterListOnRun();
        Monster.count = monsterManagement.getMonsterList().size();

        List<Transaction> transactionList = TransactionDataHandler.readDataFromFile();
        TransactionManagement.setTransactionList(transactionList);
        Transaction.count = transactionList.size();

    }
}
