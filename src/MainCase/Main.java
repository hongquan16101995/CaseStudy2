package MainCase;

import Data.CreateData.*;
import Product.Laptop;
import Product.Product;
import Product.SmartPhone;
import Product.Tablet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CreateListOfDataProduct listProduct = new CreateListOfDataProduct();
        List<Product> arrayProduct = new ArrayList<>();

        List<Laptop> arrayListLap = listProduct.createDataLaptop();
        List<SmartPhone> arrayListPhone = listProduct.createDataSmartphone();
        List<Tablet> arrayListTab = listProduct.createDataTablet();

//        arrayProduct.addAll(arrayListLap);
//        arrayProduct.addAll(arrayListPhone);
//        arrayProduct.addAll(arrayListTab);

        FileOutputStream fileOutputStream = new FileOutputStream(new File("laptop"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(arrayListLap);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("laptop");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Laptop> arrayLaptop = (List<Laptop>) objectInputStream.readObject();
        objectInputStream.close();

        for (Laptop laptop : arrayLaptop){
            System.out.println(laptop);
        }

        for (Laptop laptop : arrayListLap){
            System.out.println(laptop);
        }
//        for (SmartPhone smartPhone : arrayListPhone){
//            System.out.println(smartPhone);
//        }
//        for (Tablet tablet : arrayListTab){
//            System.out.println(tablet);
//        }

        for (Product product : arrayProduct){
            System.out.println(product);
        }
    }
}
