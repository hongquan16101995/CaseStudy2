package _Login;

import _Account.AccountAdmin;
import _Account.AccountUser;
import _Account.AccountUserManager;
import _Account.UserManager;
import _Systems.RunByAdmin;
import _Systems.RunByUser;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    private final Scanner scanner = new Scanner(System.in);
    private final RunByAdmin runByAdmin = new RunByAdmin();
    private final RunByUser runByUser = new RunByUser();
    private final AccountAdmin accountAdmin = new AccountAdmin();
    private final AccountUserManager accountUserManager = new AccountUserManager();
    private final UserManager userManager = new UserManager();

    public Login() {
    }

    public void loginSystems() {
        try {
            menuLogin();
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            scanner.nextLine();
            loginSystems();
        }
    }


    //menu
    private void menuLogin() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("0. Thoát");
        System.out.println("MỜi nhập vào lựa chọn của bạn");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                loginManager();
                break;
            case 2:
                registrationManager();
                break;
            case 0:
                System.exit(0);
        }
    }


    //đăng nhập
    private void loginManager() throws InputMismatchException {
        scanner.nextLine();
        System.out.println("Nhập account: ");
        String account = scanner.nextLine();
        System.out.println("Nhập password: ");
        String passwword = scanner.nextLine();

        checkAccount(account, passwword);
    }

    private void checkAccount(String account, String password) {
        try {
            if (checkAccountAdminInLogin(account, password)) {
                System.out.println("Đăng nhập hệ thống bởi ADMIN thành công!");
                runByAdmin.menuProductOfAdmin();
            } else {
                System.out.println("Đăng nhập thất bại! Vui lòng kiểm tra lại!");
                loginSystems();
            }

            if (accountUserManager.checkFile()) {
                System.out.println("Tài khoản USER chưa tồn tại! Vui lòng kiểm tra lại!");
                loginSystems();
            } else if (checkAccountUserInLogin(account, password)) {
                System.out.println("Đăng nhập hệ thống bởi USER thành công!");
                runByUser.menuProductOfUser();
            } else {
                System.out.println("Đăng nhập thất bại! Vui lòng kiểm tra lại!");
                loginSystems();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Đăng nhập thất bại! Vui lòng kiểm tra lại!");
            loginSystems();
        }
    }

    private boolean checkAccountAdminInLogin(String account, String password) {
        for (AccountAdmin accountAdmin : accountAdmin.getAdminAccountList()) {
            boolean checkAccountUser = account.equals(accountAdmin.getAdminAcc()) && password.equals(accountAdmin.getAdminPass());
            if (checkAccountUser) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAccountUserInLogin(String account, String password) {
        for (AccountUser accountUser : accountUserManager.getAccountUserList()) {
            boolean checkAccountUser = account.equals(accountUser.getAccount()) && password.equals(accountUser.getPassword());
            if (checkAccountUser) {
                return true;
            }
        }
        return false;
    }


    //đăng ký
    private void registrationManager() throws InputMismatchException {
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

        checkAccountUser(name, phonenumber, address, accountUser, passwordUser);
    }

    private void checkAccountUser(String name, long phonenumber, String address, String accountUser, String passwordUser) {
        if (accountUserManager.checkFile()) {
            writerAccountUserAndUser(name, phonenumber, address, accountUser, passwordUser);
            System.out.println("Đăng ký thành công! Mời đăng nhập hệ thống!");
        } else if (checkAccount(accountUser)) {
            System.out.println("Tài khoản đã tồn tại! Vui lòng đăng ký lại!");
        } else {
            writerAccountUserAndUser(name, phonenumber, address, accountUser, passwordUser);
            System.out.println("Đăng ký thành công! Mời đăng nhập hệ thống!");
        }
        loginSystems();
    }

    private boolean checkAccount(String accountUser) {
        for (AccountUser accountUser1 : accountUserManager.getAccountUserList()) {
            boolean checkAccountUser = accountUser.equals(accountUser1.getAccount());
            if (checkAccountUser) {
                return true;
            }
        }
        return false;
    }

    private void writerAccountUserAndUser(String name, long phonenumber, String address, String accountUser, String passwordUser) {
        accountUserManager.setListUser(accountUser, passwordUser);
        userManager.setListUser(name, phonenumber, address);
    }
}
