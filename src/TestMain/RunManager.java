package TestMain;

import java.util.ArrayList;
import java.util.Scanner;

public class RunManager extends NewProductManager {


    public void loginSystem() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("Nhập vào lựa chọn: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                sc.nextLine();
                System.out.println("Nhập account: ");
                String account = sc.nextLine();
                System.out.println("Nhập password: ");
                String passwword = sc.nextLine();
//                if (checkAccount(account, passwword) == 1) {
//                    System.out.println("Đăng nhập thành công!");
//                    menuProduct();
//                } else if (checkAccount(account, passwword) == -1) {
//                    System.out.println("Đăng nhập thành công!");
//                    menuProduct();
//                } else
//                    System.out.println("Đăng nhập thất bại!");
                break;
            case 2:
                sc.nextLine();
                System.out.println("Mời bạn nhập thông tin: ");
                System.out.println("Họ tên: ");
                String name = sc.nextLine();
                System.out.println("Tuổi: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.println("SĐT: ");
                long phonenumber = sc.nextLong();
                sc.nextLine();
                System.out.println("Địa chỉ: ");
                String address = sc.nextLine();
                System.out.println("Tên tài khoản: ");
                String accountUser = sc.nextLine();
                System.out.println("Password: ");
                String passwordUser = sc.nextLine();

                System.out.println("Đăng ký thành công!");
        }
    }


//    public int checkAccount(String account, String pass) {
//        Account accountObj = new Account();
//        ArrayList<String> accountAdminList = accountObj.getAccountAdminList();
//        ArrayList<String> passwordAdminList = accountObj.getPasswordAdminList();
//        ArrayList<String> accountUserList = accountObj.getAccountUserList();
//        ArrayList<String> passwordUserList = accountObj.getPasswordUserList();
//        for (int i = 0; i < accountAdminList.size(); i++) {
//            if (account.equals(accountAdminList.get(i)) && pass.equals(passwordAdminList.get(i))) {
//                return 1;
//            }
//        }
//        for (int i = 0; i < accountUserList.size(); i++) {
//            if (account.equals(accountUserList.get(i)) && pass.equals(passwordUserList.get(i))) {
//                return -1;
//            }
//        }
//        return 0;
//    }


    public void menuProduct() {
        boolean count = true;
        do {
            System.out.println("----------HỆ THỐNG---------");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Hiển thị kho sản phẩm");
            System.out.println("0. Đăng xuất");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addByRunmanager();
                    break;
                case 2:
                    if (super.check()) {
                        System.out.println("Hiện không có sản phẩm");
                        break;
                    } else {
                        super.deleteNewProduct();
                        System.out.println("Xóa thành công!");
                        break;
                    }
                case 3:
                    if (super.check()) {
                        System.out.println("Hiện không có sản phẩm");
                        break;
                    } else {
                        boolean check = true;
                        do {
                            System.out.println("Nhập ID: ");
                            int idedit = sc.nextInt();
                            if (super.checkToEditProduct(idedit)) {
                                editProduct(idedit);
                                check = false;
                            } else {
                                System.out.println("Nhập sai ID, mời nhập lại!");
                            }
                        } while (check);
                    }
                    break;
                case 4:
                    if (super.check()) {
                        System.out.println("Hiện không có sản phẩm");
                        break;
                    } else {
                        ArrayList<NewProduct> list = super.display();
                        for (NewProduct newProduct : list) {
                            System.out.println(newProduct);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Đã thoát khỏi hệ thống");
                    System.exit(0);
            }
        } while (count);
    }

    private void addByRunmanager() {
        sc.nextLine();
        System.out.println("Nhập ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập hãng: ");
        String brand = sc.nextLine();
        System.out.println("Nhập giá: ");
        int price = sc.nextInt();
        super.addList(id, name, brand, price);
        System.out.println("Thêm thành công!");
    }


    public void editProduct(int id) {
        System.out.println("1. Sửa tên");
        System.out.println("2. Sửa hãng");
        System.out.println("3. Sửa giá");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                sc.nextLine();
                System.out.println("Nhập tên mới của sản phẩm: ");
                String name = sc.nextLine();
                super.editName(id, name);
                System.out.println("Sửa tên sản phẩm có id: " + id + " thành công!");
                break;
            case 2:
                sc.nextLine();
                System.out.println("Nhập hãng mới của sản phẩm: ");
                String brand = sc.nextLine();
                super.editBrand(id, brand);
                System.out.println("Sửa hãng sản phẩm có id: " + id + " thành công!");
                break;
            case 3:
                sc.nextLine();
                System.out.println("Nhập giá mới của sản phẩm: ");
                int price = sc.nextInt();
                super.editPrice(id, price);
                System.out.println("Sửa giá sản phẩm có id: " + id + " thành công!");
                break;
        }
    }
}
