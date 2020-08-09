package _ProductManager;

import _Admin.RunByAdmin;
import _Data._OIDataByTGDD.ListProducts;
import _Product.Laptop;
import _Product.Product;
import _Product.SmartPhone;
import _Product.Tablet;
import _ReadWriteFile.IOFile;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ProductManager {
    public Scanner scanner = new Scanner(System.in);
    private final ArrayList<Product> newProductList = new ArrayList<>();
    private final IOFile<Product> ioFile = new IOFile<>();
    private final ListProducts listProducts = new ListProducts();
    private final String PATHNAME_OF_PRODUCT = "FileData/product";
    private final String PATHNAME_OF_LAPTOP = "FileData/laptop";
    private final String PATHNAME_OF_SMARTPHONE = "FileData/smartphone";
    private final String PATHNAME_OF_TABLET = "FileData/tablet";

    public ProductManager() {
        createListProduct();
    }

    public void createListProduct() {
        ArrayList<Laptop> listLaptop = listProducts.getListLaptop();
        ArrayList<SmartPhone> listSmartPhone = listProducts.getListSmartphone();
        ArrayList<Tablet> listTablet = listProducts.getListTablet();
        newProductList.addAll(listLaptop);
        newProductList.addAll(listSmartPhone);
        newProductList.addAll(listTablet);
    }

    public void writerFileData(ArrayList<Product> arrayData) {
        ioFile.writerFileData(arrayData, PATHNAME_OF_PRODUCT);
    }

    public ArrayList<Product> readFileData() {
        return ioFile.readFileData(PATHNAME_OF_PRODUCT);
    }


    public ArrayList<Product> display() {
        return readFileData();
    }


    public void addList(int id, String name, String brand, int price, int choiceAdd) {
        if (choiceAdd == 1) {
            addLaptopAndProduct(id, name, brand, price);
        } else if (choiceAdd == 2) {
            addSmartphoneAndProduct(id, name, brand, price);
        } else if (choiceAdd == 3) {
            addTabletAndProduct(id, name, brand, price);
        } else {
            ArrayList<Product> list = readFileData();
            Product product = new Product(id, name, brand, price);
            product.setTitle("Product: ");
            list.add(product);
            writerFileData(list);
        }
    }

    private void addLaptopAndProduct(int id, String name, String brand, int price) {
        ArrayList<Product> list = readFileData();
        ArrayList<Laptop> laptops = listProducts.getListLaptop();
        Product product = new Product(id, name, brand, price);
        product.setTitle("Laptop: ");
        list.add(product);
        laptops.add(new Laptop(id, name, brand, price));
        writerFileData(list);
        ((new IOFile<Laptop>())).writerFileData(laptops, PATHNAME_OF_LAPTOP);
    }

    private void addSmartphoneAndProduct(int id, String name, String brand, int price) {
        ArrayList<Product> list = readFileData();
        ArrayList<SmartPhone> smartPhones = listProducts.getListSmartphone();
        Product product = new Product(id, name, brand, price);
        product.setTitle("Smartphone: ");
        list.add(product);
        smartPhones.add(new SmartPhone(id, name, brand, price));
        writerFileData(list);
        ((new IOFile<SmartPhone>())).writerFileData(smartPhones, PATHNAME_OF_SMARTPHONE);
    }

    private void addTabletAndProduct(int id, String name, String brand, int price) {
        ArrayList<Product> list = readFileData();
        ArrayList<Tablet> tablets = listProducts.getListTablet();
        Product product = new Product(id, name, brand, price);
        product.setTitle("Tablet: ");
        list.add(product);
        tablets.add(new Tablet(id, name, brand, price));
        writerFileData(list);
        ((new IOFile<Tablet>())).writerFileData(tablets, PATHNAME_OF_TABLET);
    }


    public void deleteNewProduct() throws InputMismatchException {
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
                    list.removeIf(Product -> Product.getId() == id);
                    writerFileData(list);
                    deleteLap(id);
                    deleteSmartPhone(id);
                    deleteTablet(id);
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

    public void deleteLap(int id) {
        ArrayList<Laptop> laptops = listProducts.getListLaptop();
        for (int i = 0; i < laptops.size(); i++) {
            if (laptops.get(i).getId() == id) {
                laptops.remove(laptops.get(i));
                ((new IOFile<Laptop>())).writerFileData(laptops, PATHNAME_OF_LAPTOP);
            }
        }
    }

    public void deleteSmartPhone(int id) {
        ArrayList<SmartPhone> smartPhones = listProducts.getListSmartphone();
        for (int i = 0; i < smartPhones.size(); i++) {
            if (smartPhones.get(i).getId() == id) {
                smartPhones.remove(smartPhones.get(i));
                ((new IOFile<SmartPhone>())).writerFileData(smartPhones, PATHNAME_OF_SMARTPHONE);
            }
        }
    }

    public void deleteTablet(int id) {
        ArrayList<Tablet> tablets = listProducts.getListTablet();
        for (int i = 0; i < tablets.size(); i++) {
            if (tablets.get(i).getId() == id) {
                tablets.remove(tablets.get(i));
                ((new IOFile<Tablet>())).writerFileData(tablets, PATHNAME_OF_TABLET);
            }
        }
    }

    public void deleteAll() {
        ArrayList<Product> listProduct = readFileData();
        ArrayList<Laptop> laptops = listProducts.getListLaptop();
        ArrayList<SmartPhone> smartPhones = listProducts.getListSmartphone();
        ArrayList<Tablet> tablets = listProducts.getListTablet();
        listProduct.clear();
        laptops.clear();
        smartPhones.clear();
        tablets.clear();
        writerFileData(listProduct);
        ((new IOFile<Laptop>())).writerFileData(laptops, PATHNAME_OF_LAPTOP);
        ((new IOFile<SmartPhone>())).writerFileData(smartPhones, PATHNAME_OF_SMARTPHONE);
        ((new IOFile<Tablet>())).writerFileData(tablets, PATHNAME_OF_TABLET);
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


    public void backupProduct() {
        listProducts.setListTablet();
        listProducts.setListLaptop();
        listProducts.setListSmartphone();
        ArrayList<Product> listbackup = new ArrayList<>();
        listbackup.addAll(listProducts.getListLaptop());
        listbackup.addAll(listProducts.getListSmartphone());
        listbackup.addAll(listProducts.getListTablet());
        writerFileData(listbackup);
    }


    public boolean checkFile() {
        if (readFileData() == null) {
            return true;
        }
        ArrayList<Product> list = readFileData();
        Iterator<Product> iterator = list.iterator();
        return !iterator.hasNext();
    }
}
