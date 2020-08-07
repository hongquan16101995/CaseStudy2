package TestMain;

import _Data._OIDataByTGDD.ListProducts;
import _Product.Laptop;
import _Product.Product;
import _Product.SmartPhone;
import _Product.Tablet;
import _ProductManager.ProductManager;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByUser {
    private Scanner scanner = new Scanner(System.in);
    private ProductManager productManager = new ProductManager();
    private ListProducts listProducts = new ListProducts();
    private ArrayList<Laptop> laptopsList;
    private ArrayList<SmartPhone> smartPhonesList;
    private ArrayList<Tablet> tabletsList;
    private ArrayList<Product> productsList;

    public RunByUser() {
        laptopsList = listProducts.getListLaptop();
        smartPhonesList = listProducts.getListSmartphone();
        tabletsList = listProducts.getListTablet();
        productsList = productManager.readFileData();
    }

    public void menuProductOfUser() {
        boolean count = true;
        do {
            System.out.println("----------HỆ THỐNG USER---------");
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
                    boolean checkBuy = true;
                    int sumprice = 0;
                    do {
                        System.out.println("1. Mua sản phẩm");
                        System.out.println("2. Thoát");
                        System.out.println("Nhập vào lựa chọn của bạn: ");
                        int choiceBuy = scanner.nextInt();
                        switch (choiceBuy){
                            case 1:
                                int price = buyProduct();
                                sumprice +=price;
                                break;
                            case 2:
                                System.out.println("Tổng số tiền cần thanh toán là: " + sumprice);
                                menuProductOfUser();
                                break;
                        }
                    }while (checkBuy);
                case 0:
                    System.out.println("Đã thoát khỏi hệ thống");
                    System.exit(0);
            }
        } while (count);
    }

    private void menuProduct() {
        System.out.println("----------SẢN PHẨM---------");
        System.out.println("1. Laptop");
        System.out.println("2. SmartPhone");
        System.out.println("3. Tablet");
        System.out.println("4. Product");
        System.out.println("0. Thoát");
        System.out.println("Mời bạn nhập lựa chọn: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                for (Laptop laptop : laptopsList) {
                    laptop.display();
                }
                menuProductOfUser();
                break;
            case 2:
                for (SmartPhone smartPhone : smartPhonesList) {
                    smartPhone.display();
                }
                menuProductOfUser();
                break;
            case 3:
                for (Tablet tablet : tabletsList) {
                    tablet.display();
                }
                menuProductOfUser();
                break;
            case 4:
                getProductList();
                break;
            case 0:
                menuProductOfUser();
                break;
        }
    }

    private void getProductList() {
        for (Product product : productsList) {
            product.display();
        }
    }

    private int buyProduct() {
        getProductList();
        int price = 0;
        System.out.println("Nhập vào id sản phẩm: ");
        int id = scanner.nextInt();
        for (Product product : productsList) {
            if(product.getId() == id){
                price = product.getPrice();
            }
        }
        if(deleteNewProduct(id)){
            System.out.println("Mua hàng thành công, số tiền cần thanh toán là: " + price);
        }else
            System.out.println("Mua hàng thất bại, sản phẩm không tồn tại!");
        return price;
    }

    public boolean deleteNewProduct(int id) {
        boolean check = false;
        for (Product product : ((new ProductManager()).readFileData())) {
            if (product.getId() == id) {
                productsList.removeIf(Product -> Product.getId() == id);
                productManager.writerFileData(productsList);
                productManager.deleteLap(id);
                productManager.deleteSmartPhone(id);
                productManager.deleteTablet(id);
                check = true;
            }
        }
        return check;
    }
}

