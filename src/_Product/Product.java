package _Product;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String brand;
    private int price;
    private String title;

    public Product() {
    }

    public Product(int id, String name, String brand, int price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void display() {
        System.out.printf("%-9s", getTitle());
        System.out.printf("%-4s%-4s%-10d", "", "id:", getId());
        System.out.printf("%-6s%-55s", "name:", getName());
        System.out.printf("%-7s%-18s", "brand:", getBrand());
        System.out.printf("%-7s%-10d", "price:", getPrice());
        System.out.println();
    }
}
