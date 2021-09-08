import Controller.Account.AccountManagement;
import Controller.Monster.Factory.MonsterFactory;
import Controller.Tools.RandomNumberGenerator;
import Model.Battle.Battle;
import Model.Creep.Creep;
import Model.Creep.DarkLord;
import Model.Creep.Minion;
import Model.Monster.MonsterTypes.Monster;
import View.User.GuestMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SystemInputOnRun.getData();
        AccountManagement.getAccountManager().showAccountList();
        GuestMenu guestMenu = new GuestMenu();
        guestMenu.run();

    }
}
