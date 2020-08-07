package TestMain;

import _Login.Login;
import _Product.Product;
import _ReadWriteFile.IOFile;
import _User.AccountUser;
import _User.AccountUserManger;
import _User.User;
import _User.UserManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByAdmin {
    private Scanner scanner = new Scanner(System.in);
    private NewProductManager newProductManager;

    public RunByAdmin() {
        newProductManager = new NewProductManager();
    }

    public void menuProductOfAdmin() {
        try {
            boolean count = true;
            do {
                System.out.println("----------HỆ THỐNG ADMIN---------");
                System.out.println("1. Thêm sản phẩm");
                System.out.println("2. Xóa sản phẩm");
                System.out.println("3. Sửa sản phẩm");
                System.out.println("4. Hiển thị kho sản phẩm");
                System.out.println("5. Kiểm tra người dùng");
                System.out.println("0. Đăng xuất");
                System.out.println("Mời bạn nhập lựa chọn: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        ADD();
                        break;
                    case 2:
                        if (newProductManager.checkFile()) {
                            System.out.println("Hiện không có sản phẩm");
                            break;
                        } else {
                            newProductManager.deleteNewProduct();
                            System.out.println("Xóa thành công!");
                            break;
                        }
                    case 3:
                        if (newProductManager.checkFile()) {
                            System.out.println("Hiện không có sản phẩm");
                            break;
                        } else {
                            boolean check = true;
                            do {
                                System.out.println("Nhập ID: ");
                                int idedit = scanner.nextInt();
                                if (newProductManager.checkToEditProduct(idedit)) {
                                    editProduct(idedit);
                                    check = false;
                                } else {
                                    System.out.println("Nhập sai ID, mời nhập lại!");
                                }
                            } while (check);
                        }
                        break;
                    case 4:
                        if (newProductManager.checkFile()) {
                            System.out.println("Hiện không có sản phẩm");
                            break;
                        } else {
                            ArrayList<Product> list = newProductManager.display();
                            for (Product product : list) {
                                product.display();
                            }
                        }
                        break;
                    case 5:
                        if ((new AccountUserManger()).checkFile()) {
                            System.out.println("Hiện không có người dùng nào!");
                        } else {
                            boolean check = true;
                            do {
                                System.out.println("1. Hiện thị");
                                System.out.println("2. Xóa user");
                                System.out.println("0. Thoát");
                                System.out.println("Mời bạn nhập vào lựa chọn: ");
                                int display = scanner.nextInt();
                                switch (display) {
                                    case 1:
                                        displayUser();
                                        break;
                                    case 2:
                                        scanner.nextLine();
                                        System.out.println("Nhập vào accountuser: ");
                                        String acc = scanner.nextLine();
                                        deleteUser(acc);
                                        System.out.println("Xóa người dùng thành công!");
                                        break;
                                    case 0:
                                        menuProductOfAdmin();
                                        break;
                                }
                            } while (check);
                        }
                        break;
                    case 0:
                        System.out.println("Đã thoát khỏi hệ thống ADMIN");
                        (new Login()).loginSystem();
                        System.out.println();
                }
            } while (count);
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            scanner.nextLine();
            menuProductOfAdmin();
        }
    }

    private void ADD() {
        try {
            boolean checkAdd = true;
            do {
                System.out.println("----------SẢN PHẨM---------");
                System.out.println("1. Laptop");
                System.out.println("2. Smartphone");
                System.out.println("3. Tablet");
                System.out.println("4. Product");
                System.out.println("0. Thoát");
                System.out.println("Mời bạn nhập vào lựa chọn: ");
                int choiceAdd = scanner.nextInt();
                addByProduct(choiceAdd);
                checkAdd = false;
            } while (checkAdd);
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            scanner.nextLine();
            ADD();
        }
    }

    private ArrayList<AccountUser> getAccountUser() {
        return ((new AccountUserManger())).getAccountUserList();
    }

    private ArrayList<User> getUser() {
        return ((new UserManager())).getUserList();
    }

    private void displayUser() {
        ArrayList<AccountUser> accountUserList = getAccountUser();
        ArrayList<User> userList = getUser();
        if (accountUserList.size() == 0) {
            System.out.println("Hiện không có người dùng nào");
        } else {
            for (int i = 0; i < accountUserList.size(); i++) {
                System.out.println(userList.get(i));
                System.out.println(accountUserList.get(i));
            }
        }
    }

    private void deleteUser(String acc) {
        ArrayList<AccountUser> accountUserList = getAccountUser();
        ArrayList<User> userList = getUser();
        for (int i = 0; i < accountUserList.size(); i++) {
            if (accountUserList.get(i).getAccount().equals(acc)) {
                accountUserList.remove(accountUserList.get(i));
                userList.remove(userList.get(i));
            }
        }
        (new IOFile<AccountUser>()).writerFileData(accountUserList, "FileData/accountuser");
        (new IOFile<User>()).writerFileData(userList, "FileData/userinfo");
    }

    private void addByRunmanager(int choiceAdd) throws InputMismatchException {
        scanner.nextLine();
        System.out.println("Nhập ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập hãng: ");
        String brand = scanner.nextLine();
        System.out.println("Nhập giá: ");
        int price = scanner.nextInt();
        newProductManager.addList(id, name, brand, price, choiceAdd);
        System.out.println("Thêm thành công!");
    }

    private void addByProduct(int choiceAdd) {
        switch (choiceAdd) {
            case 1:
                addByRunmanager(1);
                break;
            case 2:
                addByRunmanager(2);
                break;
            case 3:
                addByRunmanager(3);
                break;
            case 4:
                addByRunmanager(4);
                break;
            case 0:
                menuProductOfAdmin();
                break;
        }
    }

    private void editProduct(int id) {
        try {
            System.out.println("1. Sửa tên");
            System.out.println("2. Sửa hãng");
            System.out.println("3. Sửa giá");
            System.out.println("0. Thoát");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    editNameByRunmanager(id);
                    break;
                case 2:
                    editBrandByRunmanager(id);
                    break;
                case 3:
                    editPriceByRunmanager(id);
                    break;
                case 0:
                    menuProductOfAdmin();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            scanner.nextLine();
            editProduct(id);
        }
    }

    private void editPriceByRunmanager(int id) throws InputMismatchException {
        scanner.nextLine();
        System.out.println("Nhập giá mới của sản phẩm: ");
        int price = scanner.nextInt();
        newProductManager.editPrice(id, price);
        System.out.println("Sửa giá sản phẩm có id: " + id + " thành công!");
    }

    private void editBrandByRunmanager(int id) throws InputMismatchException {
        scanner.nextLine();
        System.out.println("Nhập hãng mới của sản phẩm: ");
        String brand = scanner.nextLine();
        newProductManager.editBrand(id, brand);
        System.out.println("Sửa hãng sản phẩm có id: " + id + " thành công!");
    }

    private void editNameByRunmanager(int id) throws InputMismatchException {
        scanner.nextLine();
        System.out.println("Nhập tên mới của sản phẩm: ");
        String name = scanner.nextLine();
        newProductManager.editName(id, name);
        System.out.println("Sửa tên sản phẩm có id: " + id + " thành công!");
    }
}
