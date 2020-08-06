package _Product;

import java.io.Serializable;

public class Laptop implements _Product, Serializable {
    private int id;
    private String name;
    private String brand;
    private int price;

    public Laptop() {}

    public Laptop(int id, String name, String brand, int price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    public void display(){
        System.out.print("Laptop:");
        System.out.printf("%-6s%-4s%-10d", "", "id:", getId());
        System.out.printf("%-6s%-55s", "name:", getName());
        System.out.printf("%-7s%-18s", "brand:", getBrand());
        System.out.printf("%-7s%-10d", "price:", getPrice());
        System.out.println();
    }
}
