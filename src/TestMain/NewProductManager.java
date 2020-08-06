package TestMain;

import _Data._OIDataByTGDD.ListProducts;
import _Product.Laptop;
import _Product.Product;
import _Product.SmartPhone;
import _Product.Tablet;
import _ReadWriteFile.IOFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NewProductManager {

    public Scanner scanner = new Scanner(System.in);
    public ArrayList<Product> newProductList = new ArrayList<>();
    IOFile<Product> ioFile;
    ListProducts listProducts;


    public NewProductManager() {
        ioFile = new IOFile<>();
        creatListProduct();
    }

    public void creatListProduct() {
        listProducts = new ListProducts();
        ArrayList<Laptop> listLaptop = listProducts.getListLaptop();
        ArrayList<SmartPhone> listSmartPhone = listProducts.getListSmartphone();
        ArrayList<Tablet> listTablet = listProducts.getListTablet();
        newProductList.addAll(listLaptop);
        newProductList.addAll(listSmartPhone);
        newProductList.addAll(listTablet);
    }


    public void writerFileData(ArrayList<Product> arrayData) {
        ioFile.writerFileData(arrayData, "product");
    }


    public ArrayList<Product> readFileData() {
        return ioFile.readFileData("product");
    }


    public ArrayList<Product> display() {
        return readFileData();
    }


    public void addList(int id, String name, String brand, int price) {
            ArrayList<Product> list;
            if (readFileData() != null) {
                list = readFileData();
            } else
                list = newProductList;
            list.add(new Product(id, name, brand, price));
            writerFileData(list);
    }


    public void deleteNewProduct() {
        System.out.println("Nhập ID: (Nhập 0 nếu không muốn xóa)");
        int id = scanner.nextInt();
        boolean check = true;
        ArrayList<Product> list = readFileData();
        for (Product product : list) {
            if (id == 0) {
                RunByAdmin runByAdmin1 = new RunByAdmin();
                runByAdmin1.menuProductOfAdmin();
            } else {
                if (product.getId() == id) {
                    list.removeIf(allProduct -> allProduct.getId() == id);
                    writerFileData(list);
                    check = false;
                    break;
                }
            }
        }
        if (check) {
            System.out.println("Nhập sai ID, mời nhập lại!");
            deleteNewProduct();
        }
    }


    public boolean checkToEditProduct(int id) {
        ArrayList<Product> list = readFileData();
        for (Product product : list) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }


    public void editName(int id, String name) {
        ArrayList<Product> list = readFileData();
        for (Product product : list) {
            if (product.getId() == id) {
                product.setName(name);
            }
        }
        writerFileData(list);
    }


    public void editBrand(int id, String brand) {
        ArrayList<Product> list = readFileData();
        for (Product product : list) {
            if (product.getId() == id) {
                product.setBrand(brand);
            }
        }
        writerFileData(list);
    }


    public void editPrice(int id, int price) {
        ArrayList<Product> list = readFileData();
        for (Product product : list) {
            if (product.getId() == id) {
                product.setPrice(price);
            }
        }
        writerFileData(list);
    }


    public boolean checkFile() {
        if (readFileData() == null) {
            return true;
        }
        ArrayList<Product> list = readFileData();
        Iterator<Product> iterator = list.iterator();
        if (iterator.hasNext()) {
            return false;
        }
        return true;
    }
}
