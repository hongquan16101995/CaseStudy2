package TestMain;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NewProductManager {

    public Scanner sc = new Scanner(System.in);
    public ArrayList<NewProduct> newProductList = new ArrayList<>();


    public NewProductManager() {
    }


    public void writerFileData(ArrayList<NewProduct> list) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("test.txt")));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public ArrayList<NewProduct> readFileData() {
        ArrayList<NewProduct> list = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.txt"));
            if (objectInputStream.readObject() == null) {
                return null;
            }
            list = (ArrayList<NewProduct>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("");
        }
        return list;
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


    public boolean newEditProduct(int id) {
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
