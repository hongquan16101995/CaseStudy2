package Data.CreateData;

import Product.*;

import java.util.ArrayList;

public class CreateListOfDataProduct {
    private CreateOfDataProduct createOfDataProduct;

    public CreateListOfDataProduct(){
        createOfDataProduct = new CreateOfDataProduct();
        createOfDataProduct.setAll();
    }

    public ArrayList<Laptop> createDataLaptop() {
        ArrayList<Laptop> laptopArrayList = new ArrayList<>();
        ArrayList<String> idlist = createOfDataProduct.getIdLaptop();
        ArrayList<String> namelist = createOfDataProduct.getNameLaptop();
        ArrayList<String> brandlist = createOfDataProduct.getBrandLaptop();
        ArrayList<String> pricelist = createOfDataProduct.getPriceLaptop();

        for (int i = 0; i < namelist.size(); i++) {
            int id = Integer.parseInt(idlist.get(i));
            String name = namelist.get(i);
            String brand = brandlist.get(i);
            int price = Integer.parseInt(pricelist.get(i));
            Laptop laptop = new Laptop(id, name, brand, price);
            laptopArrayList.add(laptop);
        }
        return laptopArrayList;
    }

    public ArrayList<SmartPhone> createDataSmartphone() {
        ArrayList<SmartPhone> smartPhoneArrayList = new ArrayList<>();
        ArrayList<String> idlist = createOfDataProduct.getIdSmartphone();
        ArrayList<String> namelist = createOfDataProduct.getNameSmartphone();
        ArrayList<String> brandlist = createOfDataProduct.getBrandSmartphone();
        ArrayList<String> pricelist = createOfDataProduct.getPriceSmartphone();

        for (int i = 0; i < namelist.size(); i++) {
            int id = Integer.parseInt(idlist.get(i));
            String name = namelist.get(i);
            String brand = brandlist.get(i);
            int price = Integer.parseInt(pricelist.get(i));
            SmartPhone smartPhone = new SmartPhone(id, name, brand, price);
            smartPhoneArrayList.add(smartPhone);
        }
        return smartPhoneArrayList;
    }

    public ArrayList<Tablet> createDataTablet() {
        ArrayList<Tablet> tabletArrayList = new ArrayList<>();
        ArrayList<String> idlist = createOfDataProduct.getIdTablet();
        ArrayList<String> namelist = createOfDataProduct.getNameTablet();
        ArrayList<String> brandlist = createOfDataProduct.getBrandTablet();
        ArrayList<String> pricelist = createOfDataProduct.getPriceTablet();

        for (int i = 0; i < namelist.size(); i++) {
            int id = Integer.parseInt(idlist.get(i));
            String name = namelist.get(i);
            String brand = brandlist.get(i);
            int price = Integer.parseInt(pricelist.get(i));
            Tablet tablet = new Tablet(id, name, brand, price);
            tabletArrayList.add(tablet);
        }
        return tabletArrayList;
    }
}
