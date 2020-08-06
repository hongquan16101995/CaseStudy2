package TestMain;

import _User.AccountAdmin;
import _User.AccountUser;
import _User.AccountUserManger;
import _User.UserManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    Scanner scanner = new Scanner(System.in);
    RunManager runManager = new RunManager();
    public void loginSystem() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("Nhập vào lựa chọn của bạn: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                setLogin();
                break;
            case 2:
                setRegistration();
                break;
        }
    }

    private void setLogin() {
        scanner.nextLine();
        System.out.println("Nhập account: ");
        String account = scanner.nextLine();
        System.out.println("Nhập password: ");
        String passwword = scanner.nextLine();

        checkAccount(account, passwword);
    }

    private void checkAccount(String account, String passwword) {
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
                runManager.menuProductOfAdmin();
            } else if (accountUserManger.checkFile()) {
                System.out.println("Tài khoản USER chưa tồn tại! Vui lòng kiểm tra lại!");
                loginSystem();
            } else if (!accountUserManger.checkFile()) {
                boolean checkAccountUser = account.equals(accountUsers.get(i).getAccount()) && passwword.equals(accountUsers.get(i).getPassword());
                if (checkAccountUser) {
                    System.out.println("Đăng nhập hệ thống bởi USER thành công!");
                    runManager.menuProductOfAdmin();
                }
            } else {
                System.out.println("Đăng nhập thất bại! Vui lòng kiểm tra lại!");
                loginSystem();
            }
        }
    }

    private void setRegistration() {
        scanner.nextLine();
        System.out.println("Mời bạn nhập thông tin: ");
        System.out.println("Họ tên: ");
        String name = scanner.nextLine();
        System.out.println("SĐT: ");
        long phonenumber = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Tên tài khoản: ");
        String accountUser = scanner.nextLine();
        System.out.println("Password: ");
        String passwordUser = scanner.nextLine();

        checkAndWriteUser(name, phonenumber, address, accountUser, passwordUser);
    }

    private void checkAndWriteUser(String name, long phonenumber, String address, String accountUser, String passwordUser) {
        UserManager userManager = new UserManager();
        AccountUserManger accountUserManger1 = new AccountUserManger();
        ArrayList<AccountUser> accountUserList = accountUserManger1.getAccountUserList();
        if(accountUserManger1.checkFile()){
            accountUserManger1.setListUser(accountUser, passwordUser);
        }else {
            for (int i = 0; i < accountUserList.size(); i++){
                boolean checkAccountUser = accountUser.equals(accountUserList.get(i).getAccount()) && passwordUser.equals(accountUserList.get(i).getPassword());
                if (checkAccountUser) {
                    System.out.println("Tài khoản đã tồn tại! Vui lòng đăng ký lại!");
                    loginSystem();
                }else {
                    accountUserManger1.setListUser(accountUser, passwordUser);
                    userManager.setListUser(name, phonenumber, address);
                }
            }
        }
        System.out.println("Đăng ký thành công! Mời đăng nhập hệ thống!");
        loginSystem();
    }
}
