package TestMain;

import ReadWriteFile.IOFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NewProductManager {

    public Scanner sc = new Scanner(System.in);
    public ArrayList<NewProduct> newProductList = new ArrayList<>();
    IOFile<NewProduct> ioFile;


    public NewProductManager() {
        ioFile = new IOFile<>();
    }


    public void writerFileData(ArrayList<NewProduct> arrayData) {
        ioFile.writerFileData(arrayData,"test.txt");
    }


    public ArrayList<NewProduct> readFileData() {
        return ioFile.readFileData("test.txt");
    }


    public ArrayList<NewProduct> display() {
        return readFileData();
    }


    public void addList(int id, String name, String brand, int price) {
        ArrayList<NewProduct> list;
        if (readFileData() != null) {
            list = readFileData();
        } else
            list = newProductList;
        list.add(new NewProduct(id, name, brand, price));
        writerFileData(list);
    }


    public void deleteNewProduct() {
        System.out.println("Nhập ID: ");
        int id = sc.nextInt();
        boolean check = true;
        ArrayList<NewProduct> list = readFileData();
        for (NewProduct newProduct1 : list) {
            if (newProduct1.getID() == id) {
                list.removeIf(newProduct -> newProduct.getID() == id);
                writerFileData(list);
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Nhập sai ID, mời nhập lại!");
            deleteNewProduct();
        }
    }


    public boolean checkToEditProduct(int id) {
        ArrayList<NewProduct> list = readFileData();
        for (NewProduct newProduct : list) {
            if (newProduct.getID() == id) {
                return true;
            }
        }
        return false;
    }


    public void editName(int id, String name) {
        ArrayList<NewProduct> list = readFileData();
        for (NewProduct newProduct : list) {
            if (newProduct.getID() == id) {
                newProduct.setName(name);
            }
        }
        writerFileData(list);
    }


    public void editBrand(int id, String brand) {
        ArrayList<NewProduct> list = readFileData();
        for (NewProduct newProduct : list) {
            if (newProduct.getID() == id) {
                newProduct.setBrand(brand);
            }
        }
        writerFileData(list);
    }


    public void editPrice(int id, int price) {
        ArrayList<NewProduct> list = readFileData();
        for (NewProduct newProduct : list) {
            if (newProduct.getID() == id) {
                newProduct.setPrice(price);
            }
        }
        writerFileData(list);
    }


    public boolean check() {
        if (readFileData() == null) {
            return true;
        }
        ArrayList<NewProduct> list = readFileData();
        Iterator<NewProduct> iterator = list.iterator();
        if (iterator.hasNext()) {
            return false;
        }
        return true;
    }
}