package _Login;

import _Admin.RunByAdmin;
import TestMain.RunByUser;
import _User.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    Scanner scanner = new Scanner(System.in);
    RunByAdmin runByAdmin = new RunByAdmin();
    RunByUser runByUser = new RunByUser();

    public void loginSystem() {
        try {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("0. Thoát");
            System.out.println("Nhập vào lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    setLogin();
                    break;
                case 2:
                    setRegistration();
                    break;
                case 0:
                    System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            scanner.nextLine();
            loginSystem();
        }
    }

    private void setLogin() throws InputMismatchException {
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
                    loginSystem();
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
            loginSystem();
        }
    }

    private void setRegistration() throws InputMismatchException {
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
        AccountUserManger accountUserManager = new AccountUserManger();
        ArrayList<AccountUser> accountUserList = accountUserManager.getAccountUserList();
        if(accountUserManager.checkFile()){
            accountUserManager.setListUser(accountUser, passwordUser);
            userManager.setListUser(name, phonenumber, address);
            System.out.println("Đăng ký thành công! Mời đăng nhập hệ thống!");
            loginSystem();
        }else if ((new AccountUserManger().getAccountUserList().size() == 0)) {
            accountUserManager.setListUser(accountUser, passwordUser);
            userManager.setListUser(name, phonenumber, address);
            System.out.println("Đăng ký thành công! Mời đăng nhập hệ thống!");
        } else {
            for (int i = 0; i < accountUserList.size(); i++) {
                boolean checkAccountUser = accountUser.equals(accountUserList.get(i).getAccount());
                if (checkAccountUser) {
                    System.out.println("Tài khoản đã tồn tại! Vui lòng đăng ký lại!");
                    break;
                } else {
                    accountUserManager.setListUser(accountUser, passwordUser);
                    userManager.setListUser(name, phonenumber, address);
                    System.out.println("Đăng ký thành công! Mời đăng nhập hệ thống!");
                }
            }
        }
        loginSystem();
    }
}
