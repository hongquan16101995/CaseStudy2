package _Login;

import _User.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    private final Scanner scanner = new Scanner(System.in);
    private final LoginManager loginManager = new LoginManager();

    public Login() {
    }

    public void loginSystem() {
        try {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("0. Thoát");
            System.out.println("Nhập vào lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    loginManager.setLogin();
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

        checkUser(name, phonenumber, address, accountUser, passwordUser);
    }

    private void checkUser(String name, long phonenumber, String address, String accountUser, String passwordUser) {
        UserManager userManager = new UserManager();
        AccountUserManger accountUserManager = new AccountUserManger();
        ArrayList<AccountUser> accountUserList = accountUserManager.getAccountUserList();
        if (accountUserManager.checkFile()) {
            accountUserManager.setListUser(accountUser, passwordUser);
            userManager.setListUser(name, phonenumber, address);
            System.out.println("Đăng ký thành công! Mời đăng nhập hệ thống!");
            loginSystem();
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
    }


    private void checkAndWriteUser(String name, long phonenumber, String address, String accountUser, String passwordUser) {
        UserManager userManager = new UserManager();
        AccountUserManger accountUserManager = new AccountUserManger();
        ArrayList<AccountUser> accountUserList = accountUserManager.getAccountUserList();
        if (accountUserManager.checkFile()) {
            accountUserManager.setListUser(accountUser, passwordUser);
            userManager.setListUser(name, phonenumber, address);
            System.out.println("Đăng ký thành công! Mời đăng nhập hệ thống!");
            loginSystem();
        } else if ((new AccountUserManger().getAccountUserList().size() == 0)) {
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
