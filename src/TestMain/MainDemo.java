package TestMain;

import _Login.Login;

public class MainDemo {
    public static void main(String[] args) {
        Login login = new Login();
        RunByUser runByUser = new RunByUser();
        RunByAdmin runByAdmin = new RunByAdmin();
//        login.loginSystem();
//        runByUser.menuProductOfUser();
        runByAdmin.menuProductOfAdmin();
    }
}
