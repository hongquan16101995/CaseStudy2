package MainCase;

import _Data._OIDataByTGDD.ListProducts;

public class Main {
    public static void main(String[] args) {
    }

    public static void loadData(){
        ListProducts listProducts = new ListProducts();
        listProducts.setListSmartphone();
        listProducts.setListLaptop();
        listProducts.setListTablet();
    }
}
