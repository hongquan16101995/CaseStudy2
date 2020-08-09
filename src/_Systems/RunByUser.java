package _Systems;

import _Data._OIDataByTGDD.ListProducts;
import _Login.Login;
import _Product.Laptop;
import _Product.Product;
import _Product.SmartPhone;
import _Product.Tablet;
import _ProductManager.ProductManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunByUser {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductManager productManager = new ProductManager();
    private final ListProducts listProducts = new ListProducts();
    private final ArrayList<Product> productsList = productManager.readFileData();

    public RunByUser() {
    }

    public void menuProductOfUser() {
        try {
            do {
                ArrayList<Product> arrayList = new ArrayList<>();
                int choice = choiceOfUser();
                if (choice < 0 || choice > 3) {
                    System.out.println();
                    System.out.println("Lựa chọn không tồn tại! Mời bạn nhập lại!");
                }
                switch (choice) {
                    case 1:
                        displayProductOfUser();
                        break;
                    case 2:
                        searchProductOfUser();
                        break;
                    case 3:
                        menuBuyProduct(arrayList);
                    case 0:
                        exitOfUser();
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println();
            scanner.nextLine();
            menuProductOfUser();
        }
    }


    //menu của hệ thống USER
    private int choiceOfUser() throws InputMismatchException {
        System.out.println("----------HỆ THỐNG USER---------");
        System.out.println("1. Hiển thị sản phẩm");
        System.out.println("2. Tìm kiếm sản phẩm");
        System.out.println("3. Mua sản phẩm");
        System.out.println("0. Đăng xuất");
        System.out.println("Mời bạn nhập lựa chọn: ");
        return scanner.nextInt();
    }

    private void displayProductOfUser() {
        if (productManager.checkFile()) {
            System.out.println();
            System.out.println("Hiện không có sản phẩm");
            System.out.println();
        } else {
            menuProduct();
        }
    }

    private void searchProductOfUser() {
        if (productManager.checkFile()) {
            System.out.println();
            System.out.println("Hiện không có sản phẩm");
            System.out.println();
        } else {
            menuSearchProduct();
        }
    }

    private void exitOfUser() {
        System.out.println();
        System.out.println("Đã thoát khỏi hệ thống USER");
        System.out.println();
        (new Login()).loginSystems();
        System.out.println();
    }
    //hết menu


    //chức năng hiển thị sản phẩm
    private void getProductList() {
        for (Product product : productsList) {
            product.display();
        }
    }

    private void menuProduct() {
        try {
            int choice = inputChoiceToMenuDisplay();
            switch (choice) {
                case 1:
                    if (listProducts.checkFile()) {
                        System.out.println();
                        System.out.println("Hiện không có sản phẩm");
                        System.out.println();
                    } else {
                        for (Laptop laptop : listProducts.getListLaptop()) {
                            laptop.display();
                        }
                        System.out.println();
                    }
                    menuProductOfUser();
                    break;
                case 2:
                    if (listProducts.checkFile()) {
                        System.out.println();
                        System.out.println("Hiện không có sản phẩm");
                        System.out.println();
                    } else {
                        for (SmartPhone smartPhone : listProducts.getListSmartphone()) {
                            smartPhone.display();
                        }
                        System.out.println();
                    }
                    menuProductOfUser();
                    break;
                case 3:
                    if (listProducts.checkFile()) {
                        System.out.println();
                        System.out.println("Hiện không có sản phẩm");
                        System.out.println();
                    } else {
                        for (Tablet tablet : listProducts.getListTablet()) {
                            tablet.display();
                        }
                        System.out.println();
                    }
                    menuProductOfUser();
                    break;
                case 4:
                    getProductList();
                    System.out.println();
                    break;
                case 0:
                    menuProductOfUser();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println();
            scanner.nextLine();
            menuProduct();
        }
    }

    private int inputChoiceToMenuDisplay() throws InputMismatchException {
        System.out.println("----------SẢN PHẨM---------");
        System.out.println("1. Laptop");
        System.out.println("2. SmartPhone");
        System.out.println("3. Tablet");
        System.out.println("4. Product");
        System.out.println("0. Thoát");
        System.out.println("Mời bạn nhập lựa chọn: ");
        return scanner.nextInt();
    }
    //hết hiển thị sản phẩm


    //chức năng tìm kiếm sản phẩm
    private void menuSearchProduct() {
        try {
            do {
                int choiceSearch = inputToMenuSearchProduct();
                if (choiceSearch < 0 || choiceSearch > 2) {
                    System.out.println();
                    System.out.println("Lựa chọn không tồn tại! Mời bạn nhập lại!");
                    System.out.println();
                }
                switch (choiceSearch) {
                    case 1:
                        searchProductByKey();
                        break;
                    case 2:
                        searchProductByPrice();
                        break;
                    case 0:
                        menuProductOfUser();
                        break;
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println();
            scanner.nextLine();
            menuSearchProduct();
        }
    }

    private int inputToMenuSearchProduct() throws InputMismatchException {
        System.out.println("1. Tìm kiếm theo key");
        System.out.println("2. Tìm kiếm theo khoảng giá");
        System.out.println("0. Thoát");
        return scanner.nextInt();
    }

    private void searchProductByKey() throws InputMismatchException {
        scanner.nextLine();
        System.out.println("Nhập vào key cần tìm kiếm: ");
        String key = scanner.nextLine();
        ArrayList<Product> arrayList = searchProduct(key);
        for (Product product : arrayList) {
            product.display();
        }
        System.out.println();
    }

    private boolean checkKey(String key, String input) {
        key = key.toUpperCase();
        String regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toUpperCase());
        return matcher.matches();
    }

    private ArrayList<Product> searchProduct(String key) {
        Iterator<Product> iterator = productsList.iterator();
        ArrayList<Product> listBySearch = new ArrayList<>();
        while (iterator.hasNext()) {
            Product current = iterator.next();
            if (checkKey(key, current.getName()) || checkKey(key, current.getBrand())) {
                listBySearch.add(current);
            }
        }
        return listBySearch;
    }

    private void searchProductByPrice() throws InputMismatchException {
        scanner.nextLine();
        System.out.println("Nhập vào giá thấp nhất: ");
        int lowprice = scanner.nextInt();
        System.out.println("Nhập vào giá cao nhất: ");
        int hightprice = scanner.nextInt();
        if (hightprice < lowprice) {
            System.out.println();
            System.out.println("Bạn đã nhập sai khoảng giá! Xin mời nhập lại!");
            searchProductByPrice();
        } else {
            ArrayList<Product> arrayList = productSearchByPrice(lowprice, hightprice);
            if (arrayList.isEmpty()) {
                System.out.println();
                System.out.println("Không có sản phẩm trong khoảng giá!");
                System.out.println();
                menuProductOfUser();
            } else {
                for (Product product : arrayList) {
                    product.display();
                }
                System.out.println();
            }
        }
    }

    private ArrayList<Product> productSearchByPrice(int lowprice, int hightprice) {
        Iterator<Product> iterator = productsList.iterator();
        ArrayList<Product> listBySearch = new ArrayList<>();
        while (iterator.hasNext()) {
            Product current = iterator.next();
            if (current.getPrice() > lowprice && current.getPrice() < hightprice) {
                listBySearch.add(current);
            }
        }
        return listBySearch;
    }
    //hết tìm kiếm sản phẩm


    //chức năng bán sản phẩm
    private void menuBuyProduct(ArrayList<Product> arrayList) {
        try {
            do {
                int choiceBuy = inputChoiceToMenuBuy();
                switch (choiceBuy) {
                    case 1:
                        setIdToDisplayBuyProduct(arrayList);
                        break;
                    case 0:
                        displayBuyProduct(arrayList);
                        break;
                }
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println();
            scanner.nextLine();
            menuSearchProduct();
        }
    }

    private int inputChoiceToMenuBuy() throws InputMismatchException {
        System.out.println("1. Mua sản phẩm");
        System.out.println("0. Thoát");
        System.out.println("Nhập vào lựa chọn của bạn: ");
        return scanner.nextInt();
    }

    private void setIdToDisplayBuyProduct(ArrayList<Product> arrayList) {
        try {
            getProductList();
            System.out.println();
            System.out.println("Nhập vào id sản phẩm: ");
            int id = scanner.nextInt();
            Product product = buyProductById(id);
            if (product == null) {
                arrayList.add(new Product(0, "O", "O", 0));
            } else {
                arrayList.add(product);
            }
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println();
            inputChoiceToMenuBuy();
        }
    }

    private void displayBuyProduct(ArrayList<Product> arrayList) {
        System.out.println("Các sản phẩm đã mua: ");
        System.out.println();
        int sumprice = 0;
        for (Product product1 : arrayList) {
            if (product1.getId() != 0) {
                sumprice += product1.getPrice();
                product1.display();
            }
        }
        System.out.println();
        System.out.println("Tổng số tiền cần thanh toán là: " + sumprice);
        System.out.println();
        menuProductOfUser();
    }

    private Product buyProductById(int id) {
        int price = 0;
        Product productByBuy = null;
        for (Product product : productsList) {
            if (product.getId() == id) {
                price = product.getPrice();
                productByBuy = product;
            }
        }
        if (deleteNewProduct(id)) {
            System.out.println();
            System.out.println("Mua hàng thành công, số tiền cần thanh toán là: " + price);
            System.out.println();
            assert productByBuy != null;
            productByBuy.display();
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Mua hàng thất bại, sản phẩm không tồn tại!");
            System.out.println();
        }
        return productByBuy;
    }


    private boolean deleteNewProduct(int id) {
        boolean check = false;
        for (Product product : productManager.readFileData()) {
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
    //hết bán sản phẩm
}

