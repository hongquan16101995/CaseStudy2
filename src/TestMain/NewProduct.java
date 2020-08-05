package TestMain;

import java.io.Serializable;

public class NewProduct implements Serializable {
    private int ID;
    private String name;
    private String brand;
    private int price;

    public NewProduct(int id, String name, String brand, int price) {
        this.ID = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "NewProduct{" + "ID=" + ID + ", name='" + name + '\'' + ", brand='" + brand + '\'' + ", price=" + price + "}";
    }
}
