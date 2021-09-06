import Controller.Account.AccountManagement;
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
