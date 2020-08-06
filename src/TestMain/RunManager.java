package TestMain;

import java.util.ArrayList;
import java.util.Scanner;

public class RunManager extends NewProductManager {

    public void menuProductOfAdmin() {
        boolean count = true;
        do {
            System.out.println("----------HỆ THỐNG---------");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Hiển thị kho sản phẩm");
            System.out.println("0. Đăng xuất");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addByRunmanager();
                    break;
                case 2:
                    if (super.checkFile()) {
                        System.out.println("Hiện không có sản phẩm");
                        break;
                    } else {
                        super.deleteNewProduct();
                        System.out.println("Xóa thành công!");
                        break;
                    }
                case 3:
                    if (super.checkFile()) {
                        System.out.println("Hiện không có sản phẩm");
                        break;
                    } else {
                        boolean check = true;
                        do {
                            System.out.println("Nhập ID: ");
                            int idedit = scanner.nextInt();
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
                    if (super.checkFile()) {
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
        super.addList(id, name, brand, price);
        System.out.println("Thêm thành công!");
    }


    private void editProduct(int id) {
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
    }

    private void editPriceByRunmanager(int id) {
        scanner.nextLine();
        System.out.println("Nhập giá mới của sản phẩm: ");
        int price = scanner.nextInt();
        super.editPrice(id, price);
        System.out.println("Sửa giá sản phẩm có id: " + id + " thành công!");
    }

    private void editBrandByRunmanager(int id) {
        scanner.nextLine();
        System.out.println("Nhập hãng mới của sản phẩm: ");
        String brand = scanner.nextLine();
        super.editBrand(id, brand);
        System.out.println("Sửa hãng sản phẩm có id: " + id + " thành công!");
    }

    private void editNameByRunmanager(int id) {
        scanner.nextLine();
        System.out.println("Nhập tên mới của sản phẩm: ");
        String name = scanner.nextLine();
        super.editName(id, name);
        System.out.println("Sửa tên sản phẩm có id: " + id + " thành công!");
    }
}
