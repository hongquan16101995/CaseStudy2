package MainCase;

import Data._OIDataByTGDD.ListProducts;
import Product.Laptop;
import Product.SmartPhone;
import Product.Tablet;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ListProducts listProducts = new ListProducts();
        ArrayList<Laptop> listLaptop = listProducts.getListLaptop();
        ArrayList<SmartPhone> listSmartPhone = listProducts.getListSmartphone();
        ArrayList<Tablet> listTablet = listProducts.getListTablet();
    }
}
