package _Admin;

import _Login.Login;
import _Product.Product;
import _ProductManager.ProductManager;
import _ReadWriteFile.IOFile;
import _User.AccountUser;
import _User.AccountUserManger;
import _User.User;
import _User.UserManager;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByAdmin {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductManager productManager = new ProductManager();

    public RunByAdmin() {
    }

    public void menuProductOfAdmin() {
        try {
            do {
                int choice = choiceOfAdmin();
                if(choice < 0 || choice > 6){
                    System.out.println("Lựa chọn không tồn tại! Mời bạn nhập lại!");
                }
                switch (choice) {
                    case 1:
                        menuAddProduct();
                        break;
                    case 2:
                        deleteProductOfAdmin();
                        break;
                    case 3:
                        editProductOfAdmin();
                        break;
                    case 4:
                        displayProductOfAdmin();
                        break;
                    case 5:
                        displayUserOfAdmin();
                        break;
                    case 6:
                        backupOfAdmin();
                        break;
                    case 0:
                        exitOfAdmin();
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            scanner.nextLine();
            menuProductOfAdmin();
        }
    }



    //menu của hệ thống ADMIN
    private int choiceOfAdmin() {
        System.out.println("----------HỆ THỐNG ADMIN---------");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Xóa sản phẩm");
        System.out.println("3. Sửa sản phẩm");
        System.out.println("4. Hiển thị sản phẩm");
        System.out.println("5. Kiểm tra người dùng");
        System.out.println("6. Khôi phục dữ liệu từ kho");
        System.out.println("0. Đăng xuất");
        System.out.println("Mời bạn nhập lựa chọn: ");
        int choice = scanner.nextInt();
        return choice;
    }

    private void deleteProductOfAdmin() {
        if (productManager.checkFile()) {
            System.out.println("Hiện không có sản phẩm");
        } else {
            menuDeleteProduct();
        }
    }

    private void editProductOfAdmin() {
        if (productManager.checkFile()) {
            System.out.println("Hiện không có sản phẩm");
        } else {
            menuEditProduct();
        }
    }

    private void displayProductOfAdmin() {
        if (productManager.checkFile()) {
            System.out.println("Hiện không có sản phẩm");
        } else {
            menuDisplayProduct();
        }
    }

    private void displayUserOfAdmin() {
        if ((new AccountUserManger()).checkFile()) {
            System.out.println("Hiện không có người dùng nào!");
        } else if ((new AccountUserManger()).getAccountUserList().size() == 0) {
            System.out.println("Hiện không có người dùng nào!");
        } else {
            menuCheckUser();
        }
    }

    private void backupOfAdmin() {
        productManager.backupProduct();
        System.out.println("Khôi phục dữ liệu thành công!");
        System.out.println();
    }

    private void exitOfAdmin() {
        (new Login()).loginSystem();
        System.out.println("Đã thoát khỏi hệ thống ADMIN");
        System.out.println();
    }
    //hết menu



    //chức năng thêm sản phẩm
    private void menuAddProduct() {
        try {
            do {
                System.out.println("----------SẢN PHẨM---------");
                System.out.println("1. Laptop");
                System.out.println("2. Smartphone");
                System.out.println("3. Tablet");
                System.out.println("4. Product");
                System.out.println("0. Thoát");
                System.out.println("Mời bạn nhập vào lựa chọn: ");
                int choiceAdd = scanner.nextInt();
                if(choiceAdd < 0 || choiceAdd > 4){
                    System.out.println("Lựa chọn không tồn tại! Mời bạn nhập lại!");
                    menuAddProduct();
                }
                addByProduct(choiceAdd);
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            scanner.nextLine();
            menuAddProduct();
        }
    }

    private void addByProduct(int choiceAdd) {
        switch (choiceAdd) {
            case 1:
                inputAdd(1);
                break;
            case 2:
                inputAdd(2);
                break;
            case 3:
                inputAdd(3);
                break;
            case 4:
                inputAdd(4);
                break;
            case 0:
                menuProductOfAdmin();
                break;
        }
    }

    private void inputAdd(int choiceAdd) throws InputMismatchException {
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
        productManager.addList(id, name, brand, price, choiceAdd);
        System.out.println("Thêm thành công!");
    }
    //hết thêm sản phẩm


    //chức năng xóa sản phẩm
    private void menuDeleteProduct() {
        try {
            do {
                System.out.println("1. Xóa theo ID");
                System.out.println("2. Xóa tất cả sản phẩm");
                System.out.println("0. Thoát");
                System.out.println("Mời bạn nhập vào lựa chọn: ");
                choiceToDeleteProduct();
            } while (true);
        }catch (InputMismatchException e){
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            scanner.nextLine();
        }
    }

    private void choiceToDeleteProduct() {
        int delete = scanner.nextInt();
        if (delete != 1 && delete != 2) {
            System.out.println("Lựa chọn không tồn tại! Mời bạn nhập lại!");
        }
        switch (delete) {
            case 1:
                scanner.nextLine();
                productManager.deleteNewProduct();
                System.out.println("Xóa thành công!");
                break;
            case 2:
                confirmDelete();
                break;
            case 0:
                menuProductOfAdmin();
                break;
        }
    }

    private void confirmDelete() {
        scanner.nextLine();
        System.out.println("Nhập 'Y' để xác nhận xóa hoặc 'N' để hủy thao tác!");
        String del = scanner.nextLine();
        switch (del) {
            case "Y":
                productManager.deleteAll();
                System.out.println("Đã xóa tất cả sản phẩm!");
            case "N":
                System.out.println("Đã hủy thao tác!");
                menuProductOfAdmin();
        }
    }
    //hết xóa sản phẩm


    //chức năng sửa sản phẩm
    private void menuEditProduct() {
        boolean check = true;
        do {
            System.out.println("Nhập ID: ");
            int idedit = scanner.nextInt();
            if (productManager.checkToEditProduct(idedit)) {
                editProduct(idedit);
                displayProductEdit(idedit);
                check = false;
            } else {
                System.out.println("Nhập sai ID, mời nhập lại!");
            }
        } while (check);
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
                    editNameByProduct(id);
                    break;
                case 2:
                    editBrandByProduct(id);
                    break;
                case 3:
                    editPriceByProduct(id);
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

    private void editPriceByProduct(int id) throws InputMismatchException {
        scanner.nextLine();
        System.out.println("Nhập giá mới của sản phẩm: ");
        int price = scanner.nextInt();
        productManager.editPrice(id, price);
        System.out.println("Sửa giá sản phẩm có id: " + id + " thành công!");
    }

    private void editBrandByProduct(int id) throws InputMismatchException {
        scanner.nextLine();
        System.out.println("Nhập hãng mới của sản phẩm: ");
        String brand = scanner.nextLine();
        productManager.editBrand(id, brand);
        System.out.println("Sửa hãng sản phẩm có id: " + id + " thành công!");
    }

    private void editNameByProduct(int id) throws InputMismatchException {
        scanner.nextLine();
        System.out.println("Nhập tên mới của sản phẩm: ");
        String name = scanner.nextLine();
        productManager.editName(id, name);
        System.out.println("Sửa tên sản phẩm có id: " + id + " thành công!");
    }

    private void displayProductEdit(int idedit) {
        for (Product product : (productManager.readFileData())){
            if(product.getId() == idedit){
                System.out.println("Sản phẩm đã sửa: ");
                product.display();
            }
        }
    }
    //hết sửa sản phẩm


    //chức năng hiển thị sản phẩm
    private void menuDisplayProduct() {
        ArrayList<Product> list = productManager.display();
        for (Product product : list) {
            product.display();
        }
    }
    //hét hiển thị sản phẩm


    //chức năng kiểm tra người dùng
    private void menuCheckUser() {
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
                    deleteUserByCheck();
                    break;
                case 0:
                    menuProductOfAdmin();
                    break;
            }
        } while (true);
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

    private void deleteUserByCheck() {
        if ((new AccountUserManger()).getAccountUserList().size() == 0) {
            System.out.println("Hiện không có người dùng nào");
        } else {
            scanner.nextLine();
            System.out.println("Nhập vào accountuser: ");
            String acc = scanner.nextLine();
            if (deleteUser(acc)) {
                System.out.println("Xóa người dùng thành công!");
            } else {
                System.out.println("Không tồn tại người dùng có account là: " + acc);
            }
        }
    }

    private boolean deleteUser(String acc) {
        ArrayList<AccountUser> accountUserList = getAccountUser();
        ArrayList<User> userList = getUser();
        boolean checkDel = false;
        for (int i = 0; i < accountUserList.size(); i++) {
            if (accountUserList.get(i).getAccount().equals(acc)) {
                accountUserList.remove(accountUserList.get(i));
                userList.remove(userList.get(i));
                checkDel = true;
            } else {
                checkDel = false;
            }
        }
        (new IOFile<AccountUser>()).writerFileData(accountUserList, "FileData/accountuser");
        (new IOFile<User>()).writerFileData(userList, "FileData/userinfo");
        return checkDel;
    }
    //hết kiểm tra người dùng
}
