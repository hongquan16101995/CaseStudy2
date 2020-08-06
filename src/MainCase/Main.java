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


        for (Laptop laptop : arrayListLap){
            System.out.println(laptop);
        }
        for (SmartPhone smartPhone : arrayListPhone){
            System.out.println(smartPhone);
        }
        for (Tablet tablet : arrayListTab){
            System.out.println(tablet);
        }
    }
}
