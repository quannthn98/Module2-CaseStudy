import Controller.AccountManagement;
import Data.SystemInputOnRun;
import View.User.GuestMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SystemInputOnRun.getData();
        GuestMenu guestMenu = new GuestMenu();
        guestMenu.run();
    }
}
