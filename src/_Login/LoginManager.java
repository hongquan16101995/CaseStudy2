package _Login;

import TestMain.RunByUser;
import _Admin.RunByAdmin;
import _User.AccountAdmin;
import _User.AccountUser;
import _User.AccountUserManger;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginManager {
    Scanner scanner = new Scanner(System.in);
    RunByAdmin runByAdmin = new RunByAdmin();
    RunByUser runByUser = new RunByUser();
    Login login = new Login();

    public void setLogin() throws InputMismatchException {
        scanner.nextLine();
        System.out.println("Nhập account: ");
        String account = scanner.nextLine();
        System.out.println("Nhập password: ");
        String passwword = scanner.nextLine();

        checkAccount(account, passwword);
    }

    private void checkAccount(String account, String passwword) {
        try {
            ArrayList<AccountAdmin> accountAdmins = (new AccountAdmin()).getAdminAccountList();
            AccountUserManger accountUserManger = new AccountUserManger();
            ArrayList<AccountUser> accountUsers = accountUserManger.getAccountUserList();
            int sizeAll;
            if (accountUserManger.checkFile()) {
                sizeAll = accountAdmins.size();
            } else {
                sizeAll = accountAdmins.size() + accountUsers.size();
            }
            for (int i = 0; i < sizeAll; i++) {
                boolean checkAccountAdmin = account.equals(accountAdmins.get(i).getAdminAcc()) && passwword.equals(accountAdmins.get(i).getAdminPass());
                if (checkAccountAdmin) {
                    System.out.println("Đăng nhập hệ thống bởi ADMIN thành công!");
                    runByAdmin.menuProductOfAdmin();
                } else if (accountUserManger.checkFile()) {
                    System.out.println("Tài khoản USER chưa tồn tại! Vui lòng kiểm tra lại!");
                    login.loginSystem();
                } else if (!accountUserManger.checkFile()) {
                    boolean checkAccountUser = account.equals(accountUsers.get(i).getAccount()) && passwword.equals(accountUsers.get(i).getPassword());
                    if (checkAccountUser) {
                        System.out.println("Đăng nhập hệ thống bởi USER thành công!");
                        runByUser.menuProductOfUser();
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Đăng nhập thất bại! Vui lòng kiểm tra lại!");
            login.loginSystem();
        }
    }
}
