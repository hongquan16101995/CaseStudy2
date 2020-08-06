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
        ArrayList<String> id = createOfDataProduct.getIdLaptop();
        ArrayList<String> name = createOfDataProduct.getNameLaptop();
        ArrayList<String> brand = createOfDataProduct.getBrandLaptop();
        ArrayList<String> price = createOfDataProduct.getPriceLaptop();

        for (int i = 0; i < name.size(); i++) {
            Laptop laptop = new Laptop();
            String id1 = id.get(i);
            laptop.setId(Integer.parseInt(id1));
            String name1 = name.get(i);
            laptop.setName(name1);
            String brand1 = brand.get(i);
            laptop.setBrand(brand1);
            String price1 = price.get(i);
            laptop.setPrice(Integer.parseInt(price1));
            laptopArrayList.add(laptop);
        }
        return laptopArrayList;
    }

    public ArrayList<SmartPhone> createDataSmartphone() {
        ArrayList<SmartPhone> smartPhoneArrayList = new ArrayList<>();
        ArrayList<String> id = createOfDataProduct.getIdSmartphone();
        ArrayList<String> name = createOfDataProduct.getNameSmartphone();
        ArrayList<String> brand = createOfDataProduct.getBrandSmartphone();
        ArrayList<String> price = createOfDataProduct.getPriceSmartphone();

        for (int i = 0; i < name.size(); i++) {
            SmartPhone smartPhone = new SmartPhone();
            String id1 = id.get(i);
            smartPhone.setId(Integer.parseInt(id1));
            String name1 = name.get(i);
            smartPhone.setName(name1);
            String brand1 = brand.get(i);
            smartPhone.setBrand(brand1);
            String price1 = price.get(i);
            smartPhone.setPrice(Integer.parseInt(price1));
            smartPhoneArrayList.add(smartPhone);
        }
        return smartPhoneArrayList;
    }

    public ArrayList<Tablet> createDataTablet() {
        ArrayList<Tablet> tabletArrayList = new ArrayList<>();
        ArrayList<String> id = createOfDataProduct.getIdTablet();
        ArrayList<String> name = createOfDataProduct.getNameTablet();
        ArrayList<String> brand = createOfDataProduct.getBrandTablet();
        ArrayList<String> price = createOfDataProduct.getPriceTablet();

        for (int i = 0; i < name.size(); i++) {
            Tablet tablet = new Tablet();
            String id1 = id.get(i);
            tablet.setId(Integer.parseInt(id1));
            String name1 = name.get(i);
            tablet.setName(name1);
            String brand1 = brand.get(i);
            tablet.setBrand(brand1);
            String price1 = price.get(i);
            tablet.setPrice(Integer.parseInt(price1));
            tabletArrayList.add(tablet);
        }
        return tabletArrayList;
    }
}
