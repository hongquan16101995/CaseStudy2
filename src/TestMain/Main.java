package TestMain;

import Data.CreateData.*;
import Product.Laptop;
import Product.SmartPhone;
import Product.Tablet;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CreateListOfDataProduct listProduct = new CreateListOfDataProduct();
        ArrayList<Laptop> arrayList = new ArrayList<>();
        ArrayList<SmartPhone> arrayList1 = new ArrayList<>();
        ArrayList<Tablet> arrayList2 = new ArrayList<>();

        arrayList = listProduct.createDataLaptop();
        arrayList1 = listProduct.createDataSmartphone();
        arrayList2 = listProduct.createDataTablet();
        for (Laptop laptop : arrayList){
            System.out.println(laptop);
        }
//        for (SmartPhone smartPhone : arrayList1){
//            System.out.println(smartPhone);
//        }
//        for (Tablet tablet : arrayList2){
//            System.out.println(tablet);
//        }
    }
}
