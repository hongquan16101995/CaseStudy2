package TestMain;

import java.util.ArrayList;

public class RunByUser extends NewProductManager {
    public void menuProductOfUser() {
        boolean count = true;
        do {
            System.out.println("----------HỆ THỐNG---------");
            System.out.println("1. Hiển thị sản phẩm");
            System.out.println("2. Tìm kiếm sản phẩm");
            System.out.println("3. Mua sản phẩm");
            System.out.println("0. Đăng xuất");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    menuProduct();
                    break;
                case 2:

                case 3:

                case 0:
                    System.out.println("Đã thoát khỏi hệ thống");
                    System.exit(0);
            }
        } while (count);
    }

    private void menuProduct() {
        boolean count = true;
        do {
            System.out.println("----------SẢN PHẨM---------");
            System.out.println("1. Laptop");
            System.out.println("2. SmartPhone");
            System.out.println("3. Tablet");
            System.out.println("4. SmartWatch");
            System.out.println("5. Accessories");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 0:
                    menuProductOfUser();
                    break;
            }
        } while (count);
    }
}
