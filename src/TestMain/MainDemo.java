package TestMain;

import _Account.AccountUser;
import _Account.AccountUserManager;
import _Login.Login;
import _Systems.RunByAdmin;
import _Systems.RunByUser;

public class MainDemo {
    public static void main(String[] args) {
//        Login login = new Login();
//        login.loginSystems();
        RunByAdmin runByAdmin = new RunByAdmin();
        runByAdmin.menuProductOfAdmin();
    }
}
